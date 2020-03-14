//--------------------------------------------------
// Class AuthResult
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.moecraftbot.ng.bot.provider.mirai.contact;

public class AuthResult {
    /**
     * code : 0
     * session : UnVerifiedSession
     */

    private int code;
    private String session;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
