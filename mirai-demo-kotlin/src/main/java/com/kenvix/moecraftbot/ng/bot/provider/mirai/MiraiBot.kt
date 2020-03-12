//--------------------------------------------------
// Class MiraiBot
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.moecraftbot.ng.bot.provider.mirai

import com.kenvix.moecraftbot.ng.lib.bot.*
import kotlinx.coroutines.runBlocking
import net.mamoe.mirai.BotFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


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

    val isMessageFeatureSupported =
        driver.isAnyFeatureSupported(DriverFeature.TextMessage, DriverFeature.MixedMessage, DriverFeature.File)
    val isTextMessageFeatureSupported =
        driver.isAnyFeatureSupported(DriverFeature.TextMessage, DriverFeature.MixedMessage)
    val isCommandFeatureSupported = driver.isFeatureSupported(DriverFeature.Command)
    val isEventFeatureSupported = driver.isFeatureSupported(DriverFeature.Event)

    override fun getLogTag(): String = "MiraiBotProvider"


    override fun onEnable() {
        logger.fine("This bot provider is based on mirai project. (HTTP API)")
        logger.fine("See miral github: https://github.com/mamoe/mirai")

        okHttpClient = OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).connectTimeout(1, TimeUnit.SECONDS).build()
        retrofit = Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(GsonConverterFactory.create()).build()
        Class.forName("net.mamoe.mirai.qqandroid.QQAndroid")

        messager = MiraiMessager(this)

        runBlocking { messager.login() }

        logger.fine("Mirai Bot API Loaded")
        driver.onBotProviderConnect(this)
    }

    private val apiUrl: String
            get() = "http://localhost:${options.mirai.port}"

    override fun sendMessage(chatId: Long, message: String, type: MessageType, replyToMessageId: Long?, messageFrom: MessageFrom): BotMessage
        = messager.sendMessage(chatId, message, type, replyToMessageId, messageFrom)

    override fun banUser(chatId: Long, userId: Long, duration: Int) {
        super.banUser(chatId, userId, duration)
    }

    override fun deleteMessage(chatId: Long, messageId: Long) {
        super.deleteMessage(chatId, messageId)

    }

    override fun kickUser(chatId: Long, userId: Long) {
        super.kickUser(chatId, userId)
    }

    override fun muteUser(chatId: Long, userId: Long, duration: Int) {
        super.muteUser(chatId, userId, duration)
    }

    override fun onCommand(update: BotUpdate<*>, commandText: String) {
        super.onCommand(update, commandText)
    }

    override fun onEvent(update: BotUpdate<*>, eventType: MessageType) {
        super.onEvent(update, eventType)
    }

    override fun onUpgrade(newVersionCode: Int, oldVersionCode: Int) {
        super.onUpgrade(newVersionCode, oldVersionCode)
    }

    override fun onSystemConsoleInput(input: String): Boolean {
        return true
    }
}