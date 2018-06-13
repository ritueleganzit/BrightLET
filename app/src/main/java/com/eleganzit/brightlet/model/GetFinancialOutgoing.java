package com.eleganzit.brightlet.model;

/**
 * Created by Uv on 6/11/2018.
 */

public class GetFinancialOutgoing
{
    String address,fees,advertisiing;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getAdvertisiing() {
        return advertisiing;
    }

    public void setAdvertisiing(String advertisiing) {
        this.advertisiing = advertisiing;
    }

    public GetFinancialOutgoing(String address, String fees, String advertisiing) {
        this.address = address;
        this.fees = fees;
        this.advertisiing = advertisiing;
    }
}

