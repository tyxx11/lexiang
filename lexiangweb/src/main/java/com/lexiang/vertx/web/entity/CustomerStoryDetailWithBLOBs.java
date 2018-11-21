package com.lexiang.vertx.web.entity;

public class CustomerStoryDetailWithBLOBs extends CustomerStoryDetail {
    private String divCustomerDetail;

    public String getDivCustomerDetail() {
        return divCustomerDetail;
    }

    public void setDivCustomerDetail(String divCustomerDetail) {
        this.divCustomerDetail = divCustomerDetail == null ? null : divCustomerDetail.trim();
    }
}