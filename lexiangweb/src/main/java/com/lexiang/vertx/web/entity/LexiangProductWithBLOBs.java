package com.lexiang.vertx.web.entity;

public class LexiangProductWithBLOBs extends LexiangProduct {
    private String intro;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}