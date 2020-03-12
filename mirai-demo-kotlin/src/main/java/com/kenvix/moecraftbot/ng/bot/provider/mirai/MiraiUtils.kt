@file:JvmName("MiraiUtils")

package com.kenvix.moecraftbot.ng.bot.provider.mirai

import com.kenvix.moecraftbot.ng.lib.bot.*
import net.mamoe.mirai.contact.QQ
import net.mamoe.mirai.event.MessageSubscribersBuilder
import net.mamoe.mirai.message.FriendMessage
import net.mamoe.mirai.message.GroupMessage
import net.mamoe.mirai.message.MessagePacket
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.id
import net.mamoe.mirai.message.data.sequenceId

fun MessagePacket<*, *>.toBotUpdate(messageType: MessageType): BotUpdate<MessagePacket<*, *>> {
    return BotUpdate(
        updateObject = this,
        message = BotMessage(
            id = this.message.id,
            sender = this.sender.toBotUser(),
            messageFrom = this.messageFrom,
            messageType = messageType,
            replyToMessage = null,
            extraData = this.getExtraData(messageType)
        ),
        chatId = this.subject.id,
        updateId = this.message.id
    )
}

val MessageChain.messageType
    get(): MessageType {
        return
    }

val MessageChain.extraData

val MessagePacket<*, *>.messageFrom
    get(): MessageFrom = when (this) {
        is GroupMessage -> MessageFrom.Group
        is FriendMessage -> MessageFrom.Private
        else -> MessageFrom.Unknown
    }

fun <TSender : QQ> TSender.toBotUser(): BotUser {
    return BotUser(
        id = this.id,
        name = this.nick,
        description = ""
    )
}