package com.eleganzit.brightlet.model;

/**
 * Created by Uv on 6/4/2018.
 */

public class GetTenantsList {

    String name,address;


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

    public GetTenantsList(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
