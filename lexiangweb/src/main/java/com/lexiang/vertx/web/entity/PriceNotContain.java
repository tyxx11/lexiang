package com.lexiang.vertx.web.entity;

public class PriceNotContain extends PriceNotContainKey {
    private Integer productId;

    private Integer tagId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}