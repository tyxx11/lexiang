package com.lexiang.vertx.web.entity;

public class HomePageContentWithBLOBs extends HomePageContent {
    private String divTop;

    private String divMid;

    private String divBot;

    public String getDivTop() {
        return divTop;
    }

    public void setDivTop(String divTop) {
        this.divTop = divTop == null ? null : divTop.trim();
    }

    public String getDivMid() {
        return divMid;
    }

    public void setDivMid(String divMid) {
        this.divMid = divMid == null ? null : divMid.trim();
    }

    public String getDivBot() {
        return divBot;
    }

    public void setDivBot(String divBot) {
        this.divBot = divBot == null ? null : divBot.trim();
    }
}