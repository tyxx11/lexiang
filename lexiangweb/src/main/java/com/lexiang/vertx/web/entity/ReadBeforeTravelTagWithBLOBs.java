package com.lexiang.vertx.web.entity;

public class ReadBeforeTravelTagWithBLOBs extends ReadBeforeTravelTag {
    private String tagDescribe;

    public String getTagDescribe() {
        return tagDescribe;
    }

    public void setTagDescribe(String tagDescribe) {
        this.tagDescribe = tagDescribe == null ? null : tagDescribe.trim();
    }
}