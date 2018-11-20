package com.lexiang.vertx.web.entity;

public class CustomerStoryWithBLOBs extends CustomerStory {
    private String divCustomer;

    public String getDivCustomer() {
        return divCustomer;
    }

    public void setDivCustomer(String divCustomer) {
        this.divCustomer = divCustomer == null ? null : divCustomer.trim();
    }
}