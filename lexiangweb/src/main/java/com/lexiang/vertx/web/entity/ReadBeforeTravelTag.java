package com.lexiang.vertx.web.entity;

public class ReadBeforeTravelTag extends ReadBeforeTravelTagKey {
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }
}