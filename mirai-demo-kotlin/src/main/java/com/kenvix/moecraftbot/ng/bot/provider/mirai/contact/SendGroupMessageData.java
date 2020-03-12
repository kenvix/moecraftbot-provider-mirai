//--------------------------------------------------
// Class SendGroupMessageResult
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.moecraftbot.ng.bot.provider.mirai.contact;

import java.util.List;

public class SendGroupMessageData {

    /**
     * sessionKey : YourSession
     * target : 987654321
     * messageChain : [{"type":"Plain","text":"hello\n"},{"type":"Plain","text":"world"}]
     */

    private String sessionKey;
    private int target;
    private List<MessageChainBean> messageChain;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public List<MessageChainBean> getMessageChain() {
        return messageChain;
    }

    public void setMessageChain(List<MessageChainBean> messageChain) {
        this.messageChain = messageChain;
    }

    public static class MessageChainBean {
        /**
         * type : Plain
         * text : hello

         */

        private String type;
        private String text;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
