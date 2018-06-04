package com.maxpro.model;

import com.maxpro.support.model.ChatStatus;


public class Chat {

    private ChatStatus chatStatus;
    private String content;
    private String sender;

    public Chat() {
    }

    public ChatStatus getChatStatus() {
        return chatStatus;
    }

    public void setChatStatus(ChatStatus chatStatus) {
        this.chatStatus = chatStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "chatStatus=" + chatStatus +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
