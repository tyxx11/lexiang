package com.lexiang.vertx.web.entity;

import java.util.Date;

public class HomePageContent extends HomePageContentKey {
    private Date timeStamp;

    private Integer status;

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