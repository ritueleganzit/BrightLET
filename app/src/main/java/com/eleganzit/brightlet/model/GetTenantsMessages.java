package com.eleganzit.brightlet.model;

import android.widget.ImageView;
import android.widget.TextView;

import com.eleganzit.brightlet.fonts.TextViewMuseo500;

/**
 * Created by Uv on 5/22/2018.
 */

public class GetTenantsMessages
{
    int profile_pic;
    String name,subject,address;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GetTenantsMessages(int profile_pic, String name, String subject, String address) {
        this.profile_pic = profile_pic;
        this.name = name;
        this.subject = subject;
        this.address = address;
    }
}
