package com.eleganzit.brightlet.model;

/**
 * Created by Uv on 5/23/2018.
 */

public class GetFinancialIncoming
{
    String address,cost;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public GetFinancialIncoming(String address, String cost) {
        this.address = address;
        this.cost = cost;
    }
}
