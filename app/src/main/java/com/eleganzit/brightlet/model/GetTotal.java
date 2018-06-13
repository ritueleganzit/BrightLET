package com.eleganzit.brightlet.model;

/**
 * Created by Uv on 6/12/2018.
 */

public class GetTotal
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

    public GetTotal(String title, String cost) {
        this.title = title;
        this.cost = cost;
    }
}
