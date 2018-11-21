package com.lexiang.vertx.web.entity;

import java.util.Date;

public class CustomerStoryDetail extends CustomerStoryDetailKey {
    private String picAddress;

    private Integer customerStoryId;

    private Date timeStamp;

    private Integer status;

    public String getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress == null ? null : picAddress.trim();
    }

    public Integer getCustomerStoryId() {
        return customerStoryId;
    }

    public void setCustomerStoryId(Integer customerStoryId) {
        this.customerStoryId = customerStoryId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}