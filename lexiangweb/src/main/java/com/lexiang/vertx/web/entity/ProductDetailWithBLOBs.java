package com.lexiang.vertx.web.entity;

public class ProductDetailWithBLOBs extends ProductDetail {
    private String divBaomingwuyou;

    private String divTiyanwuyou;

    private String divJiagewuyou;

    private String divCommonProblems;

    private String divTravelCharacteristic;

    private String divCancelOrder;

    private String divExplain;

    public String getDivBaomingwuyou() {
        return divBaomingwuyou;
    }

    public void setDivBaomingwuyou(String divBaomingwuyou) {
        this.divBaomingwuyou = divBaomingwuyou == null ? null : divBaomingwuyou.trim();
    }

    public String getDivTiyanwuyou() {
        return divTiyanwuyou;
    }

    public void setDivTiyanwuyou(String divTiyanwuyou) {
        this.divTiyanwuyou = divTiyanwuyou == null ? null : divTiyanwuyou.trim();
    }

    public String getDivJiagewuyou() {
        return divJiagewuyou;
    }

    public void setDivJiagewuyou(String divJiagewuyou) {
        this.divJiagewuyou = divJiagewuyou == null ? null : divJiagewuyou.trim();
    }

    public String getDivCommonProblems() {
        return divCommonProblems;
    }

    public void setDivCommonProblems(String divCommonProblems) {
        this.divCommonProblems = divCommonProblems == null ? null : divCommonProblems.trim();
    }

    public String getDivTravelCharacteristic() {
        return divTravelCharacteristic;
    }

    public void setDivTravelCharacteristic(String divTravelCharacteristic) {
        this.divTravelCharacteristic = divTravelCharacteristic == null ? null : divTravelCharacteristic.trim();
    }

    public String getDivCancelOrder() {
        return divCancelOrder;
    }

    public void setDivCancelOrder(String divCancelOrder) {
        this.divCancelOrder = divCancelOrder == null ? null : divCancelOrder.trim();
    }

    public String getDivExplain() {
        return divExplain;
    }

    public void setDivExplain(String divExplain) {
        this.divExplain = divExplain == null ? null : divExplain.trim();
    }
}