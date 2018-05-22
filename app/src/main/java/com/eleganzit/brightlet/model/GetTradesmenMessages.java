package com.eleganzit.brightlet.model;

/**
 * Created by Uv on 5/22/2018.
 */

public class GetTradesmenMessages
{
    int profile_pic;
    String name,address;

    public int getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(int profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GetTradesmenMessages(int profile_pic, String name, String address) {
        this.profile_pic = profile_pic;
        this.name = name;
        this.address = address;
    }
}
