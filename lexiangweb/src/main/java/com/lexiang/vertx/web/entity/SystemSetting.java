package com.lexiang.vertx.web.entity;

import java.util.Date;

public class SystemSetting extends SystemSettingKey {
    private String log1;

    private String log2;

    private String telNum;

    private String address;

    private String companyName;

    private Date timeStamp;

    public String getLog1() {
        return log1;
    }

    public void setLog1(String log1) {
        this.log1 = log1 == null ? null : log1.trim();
    }

    public String getLog2() {
        return log2;
    }

    public void setLog2(String log2) {
        this.log2 = log2 == null ? null : log2.trim();
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum == null ? null : telNum.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}