package com.eleganzit.brightlet.model;

/**
 * Created by Uv on 6/11/2018.
 */

public class GetFinancialBottom
{
    String title,cost;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public GetFinancialBottom(String title, String cost) {
        this.title = title;
        this.cost = cost;
    }
}
