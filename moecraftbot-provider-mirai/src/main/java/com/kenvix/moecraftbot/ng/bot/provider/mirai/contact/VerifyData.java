//--------------------------------------------------
// Class VerifyResult
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.moecraftbot.ng.bot.provider.mirai.contact;

public class VerifyData {
    /**
     * sessionKey : UnVerifiedSession
     * qq : 123456789
     */

    private String sessionKey;
    private int qq;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }
}
