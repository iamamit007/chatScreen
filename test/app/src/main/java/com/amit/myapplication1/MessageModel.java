package com.amit.myapplication1;

public class MessageModel {
    String message;
    String time;
    String senderName;
    boolean isSendByOthers;

    public MessageModel(String message, String time, String senderName, boolean isSendByOthers) {
        this.message = message;
        this.time = time;
        this.senderName = senderName;
        this.isSendByOthers = isSendByOthers;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public String getSenderName() {
        return senderName;
    }

    public boolean isSendByOthers() {
        return isSendByOthers;
    }
}
