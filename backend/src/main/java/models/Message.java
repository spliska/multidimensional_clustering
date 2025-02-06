package models;

import java.util.Date;

public class Message {
    String sender;
    String receiver;
    Date date;

    public Message(String sender, String receiver, Date date) {
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
