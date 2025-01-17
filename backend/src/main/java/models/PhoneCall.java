package models;

import java.sql.Date;
import java.sql.Time;

public class PhoneCall {
    Date date;
    Time time;
    Time duration;
    String caller;
    String receiver;

    public PhoneCall(Date date, Time time, Time duration, String caller, String receiver) {
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.caller = caller;
        this.receiver = receiver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
