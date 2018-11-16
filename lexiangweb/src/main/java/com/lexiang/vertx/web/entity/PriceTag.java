package com.lexiang.vertx.web.entity;

public class PriceTag extends PriceTagKey {
    private String tagName;

    private String tagDescribe;

    private String tagPhoto;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public String getTagDescribe() {
        return tagDescribe;
    }

    public void setTagDescribe(String tagDescribe) {
        this.tagDescribe = tagDescribe == null ? null : tagDescribe.trim();
    }

    public String getTagPhoto() {
        return tagPhoto;
    }

    public void setTagPhoto(String tagPhoto) {
        this.tagPhoto = tagPhoto == null ? null : tagPhoto.trim();
    }
}