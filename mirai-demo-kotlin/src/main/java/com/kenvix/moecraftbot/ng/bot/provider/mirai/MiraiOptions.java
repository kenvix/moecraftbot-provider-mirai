//--------------------------------------------------
// Class MiraiOptions
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.moecraftbot.ng.bot.provider.mirai;

public class MiraiOptions {
    public Bot bot;
    public Mirai mirai;

    public static class Bot {
        public String name;
        public String password;
        public long qq;
    }

    public static class Mirai {
        public String authKey;
        public int port;
    }
}
