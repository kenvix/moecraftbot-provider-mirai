@file:JvmName("MiraiUtils")

package com.kenvix.moecraftbot.ng.bot.provider.mirai

import com.kenvix.moecraftbot.ng.lib.bot.*
import net.mamoe.mirai.contact.QQ
import net.mamoe.mirai.event.MessageSubscribersBuilder
import net.mamoe.mirai.message.FriendMessage
import net.mamoe.mirai.message.GroupMessage
import net.mamoe.mirai.message.MessagePacket
import net.mamoe.mirai.message.MessageReceipt
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.utils.MiraiExperimentalAPI

fun MessagePacket<*, *>.toBotUpdate(): BotUpdate<MessagePacket<*, *>> {
    var messageType: MessageType? = null
    var quote: QuoteReply? = null

    @Suppress("EXPERIMENTAL_API_USAGE")
    for (msg in message) {
        if (msg is Image) { messageType = MessageType.Photo; break; }
        if (msg is Face) { messageType = MessageType.Photo; break; }
        if (msg is QuoteReply) { quote = msg }
    }

    if (messageType == null)
        messageType = MessageType.Text

    var extraData: BotExtraData? = null


    return BotUpdate(
        updateObject = this,
        message = BotMessage(
            id = this.message.id,
            sender = this.sender.toBotUser(),
            messageFrom = this.messageFrom,
            messageType = messageType,
            replyToMessage = if (quote != null) BotMessage(
                id = quote.source.id,
                sender = botUserOf(id = quote.source.senderId),
                messageFrom = this.messageFrom,
                messageType = MessageType.Text,
                messageText = quote.source.toString(),
                extraData = null
            ) else null,
            extraData = null
        ),
        chatId = this.subject.id,
        updateId = this.message.id
    )
}

fun MessageReceipt<*>.toBotMessage(text: String): BotMessage {
    return BotMessage(
        id = this.source.id,
        sender = null,
        messageFrom = if (isToGroup) MessageFrom.Group else MessageFrom.Private,
        messageType = MessageType.Text,
        messageText = text,
        extraData = null
    )
}

val MessageChain.messageType
    get(): MessageType {
        this.forEach {
            @Suppress("EXPERIMENTAL_API_USAGE")
            when (it) {
                is Image -> return MessageType.Photo
                is Face -> return MessageType.Photo
            }
        }
        return MessageType.Text
    }

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

fun botUserOf(id: Long) = BotUser(id)