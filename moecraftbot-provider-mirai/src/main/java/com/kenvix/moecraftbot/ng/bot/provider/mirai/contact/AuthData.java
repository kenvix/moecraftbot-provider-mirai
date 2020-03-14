//--------------------------------------------------
// Class AuthData
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.moecraftbot.ng.bot.provider.mirai.contact;

public class AuthData {
    public AuthData(String authKey) {
        this.authKey = authKey;
    }

    public AuthData() {
    }

    /**
     * authKey : U9HSaDXl39ksd918273hU
     */

    private String authKey;

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }
}
