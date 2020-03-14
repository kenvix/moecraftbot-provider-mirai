//--------------------------------------------------
// Class MiraiExtraData
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.moecraftbot.ng.bot.provider.mirai

import com.kenvix.moecraftbot.ng.lib.bot.BotExtraPhoto
import net.mamoe.mirai.message.data.CustomFaceFromFile
import java.io.File
import java.io.InputStream
import java.net.URI

class MiraiExtraPhoto(val image: CustomFaceFromFile) : BotExtraPhoto {
    override val fileStream: InputStream
        get() = File(image.filepath).inputStream() as InputStream
    override val fileURI: URI
        get() = File(image.filepath).toURI()
    override val height: Int
        get() = image.height
    override val id: String
        get() = image.fileId.toString()
    override val size: Int
        get() = image.size
    override val width: Int
        get() = image.width
}