//--------------------------------------------------
// Interface MiraiSendMessage
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.moecraftbot.ng.bot.provider.mirai.contact.api;

import com.kenvix.moecraftbot.ng.bot.provider.mirai.contact.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MiraiMessage {
    @POST("/sendFriendMessage")
    Call<SendMessageResult> sendFriendMessage(@Body SendFriendMessageData sendFriendMessageData);

    @POST("/sendGroupMessage")
    Call<SendMessageResult> sendGroupMessage(@Body SendGroupMessageData sendGroupMessageData);

    @POST("/recall")
    Call<CommonResult> recall(@Body RecallData recallData);
}
