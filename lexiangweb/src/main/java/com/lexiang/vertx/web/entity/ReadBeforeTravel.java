package com.lexiang.vertx.web.entity;

public class ReadBeforeTravel extends ReadBeforeTravelKey {
    private Integer tagId;

    private Integer productId;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}