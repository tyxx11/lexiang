package com.lexiang.vertx.web.entity;

public class TrvalType extends TrvalTypeKey {
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}