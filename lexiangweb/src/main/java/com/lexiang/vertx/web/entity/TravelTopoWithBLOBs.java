package com.lexiang.vertx.web.entity;

public class TravelTopoWithBLOBs extends TravelTopo {
    private String div1;

    private String div2;

    private String div3;

    public String getDiv1() {
        return div1;
    }

    public void setDiv1(String div1) {
        this.div1 = div1 == null ? null : div1.trim();
    }

    public String getDiv2() {
        return div2;
    }

    public void setDiv2(String div2) {
        this.div2 = div2 == null ? null : div2.trim();
    }

    public String getDiv3() {
        return div3;
    }

    public void setDiv3(String div3) {
        this.div3 = div3 == null ? null : div3.trim();
    }
}