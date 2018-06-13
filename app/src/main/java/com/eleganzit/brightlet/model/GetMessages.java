package com.eleganzit.brightlet.model;

/**
 * Created by Uv on 6/6/2018.
 */

public class GetMessages
{
    String from_pic,name,message,from,to,time;

    public String getFrom_pic() {
        return from_pic;
    }

    public void setFrom_pic(String from_pic) {
        this.from_pic = from_pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public GetMessages(String from_pic, String name, String message, String from, String to, String time) {
        this.from_pic = from_pic;
        this.name = name;
        this.message = message;
        this.from = from;
        this.to = to;
        this.time = time;
    }
}
