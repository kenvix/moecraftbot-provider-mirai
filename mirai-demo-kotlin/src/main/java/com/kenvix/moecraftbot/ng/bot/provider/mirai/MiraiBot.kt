//--------------------------------------------------
// Class MiraiBot
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.moecraftbot.ng.bot.provider.mirai

import com.kenvix.moecraftbot.ng.bot.provider.mirai.contact.AuthData
import com.kenvix.moecraftbot.ng.bot.provider.mirai.contact.api.MiraiAuth
import com.kenvix.moecraftbot.ng.lib.bot.AbstractBotProvider
import com.kenvix.moecraftbot.ng.lib.bot.BotMessage
import com.kenvix.moecraftbot.ng.lib.bot.MessageType
import com.kenvix.moecraftbot.ng.lib.exception.InvalidAuthorizationException
import demo.subscribe.directlySubscribe
import demo.subscribe.messageDSL
import kotlinx.coroutines.runBlocking
import net.mamoe.mirai.Bot
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.utils.FileBasedDeviceInfo
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.math.log


class MiraiBot: AbstractBotProvider<MiraiOptions>() {
    override val providerName: String = "MiraiBot"
    override val providerVersion: String = "1.0"
    override val providerVersionCode: Int = 1
    override val providerOptions: Int = OPTION_REDIRECT_STDIN
    override val configFileName: String = "mirai"
    override val botName: String = "MiraiBot"

    private lateinit var okHttpClient: OkHttpClient
    private lateinit var retrofit: Retrofit
    private lateinit var sessionKey: String
    private lateinit var messager: MiraiMessager

    override fun getLogTag(): String = "MiraiBotProvider"


    override fun onEnable() {
        logger.fine("This bot provider is based on mirai project. (HTTP API)")
        logger.fine("See miral github: https://github.com/mamoe/mirai")

        okHttpClient = OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).connectTimeout(1, TimeUnit.SECONDS).build()
        retrofit = Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(GsonConverterFactory.create()).build()
        messager = MiraiMessager(this)

        runBlocking { messager.login() }

        logger.fine("Mirai Bot API Loaded")
        driver.onBotProviderConnect(this)
    }

    private val apiUrl: String
            get() = "http://localhost:${options.mirai.port}"

    override fun sendMessage(chatId: Long, message: String, type: MessageType, replyToMessageId: Long?): BotMessage {
        TODO()
    }

    override fun onSystemConsoleInput(input: String): Boolean {
        return true
    }
}