package com.lexiang.vertx.web.entity;

import java.util.Date;

public class StaticPages extends StaticPagesKey {
    private String aboutUsPage;

    private String homePage;

    private Date timeStamp;

    private Integer status;

    public String getAboutUsPage() {
        return aboutUsPage;
    }

    public void setAboutUsPage(String aboutUsPage) {
        this.aboutUsPage = aboutUsPage == null ? null : aboutUsPage.trim();
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage == null ? null : homePage.trim();
    }

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