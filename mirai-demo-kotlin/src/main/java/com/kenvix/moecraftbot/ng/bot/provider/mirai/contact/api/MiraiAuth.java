//--------------------------------------------------
// Interface MiraiAuth
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.moecraftbot.ng.bot.provider.mirai.contact.api;

import com.kenvix.moecraftbot.ng.bot.provider.mirai.contact.AuthData;
import com.kenvix.moecraftbot.ng.bot.provider.mirai.contact.AuthResult;
import com.kenvix.moecraftbot.ng.bot.provider.mirai.contact.CommonResult;
import com.kenvix.moecraftbot.ng.bot.provider.mirai.contact.VerifyData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MiraiAuth {
    @POST("/auth")
    Call<AuthResult> auth(@Body AuthData data);

    @POST("/verify")
    Call<CommonResult> verify(@Body VerifyData data);

    @POST("/release")
    Call<CommonResult> release(@Body VerifyData data);
}
