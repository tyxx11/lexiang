package com.lexiang.vertx.web.entity;

public class ProductDetail extends ProductDetailKey {
    private Integer productId;

    private Integer teamMemberUpperLimit;

    private String signUpPeople;

    private String gatheringPlace;

    private String disbandedPlace;

    private Integer travelTopoId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTeamMemberUpperLimit() {
        return teamMemberUpperLimit;
    }

    public void setTeamMemberUpperLimit(Integer teamMemberUpperLimit) {
        this.teamMemberUpperLimit = teamMemberUpperLimit;
    }

    public String getSignUpPeople() {
        return signUpPeople;
    }

    public void setSignUpPeople(String signUpPeople) {
        this.signUpPeople = signUpPeople == null ? null : signUpPeople.trim();
    }

    public String getGatheringPlace() {
        return gatheringPlace;
    }

    public void setGatheringPlace(String gatheringPlace) {
        this.gatheringPlace = gatheringPlace == null ? null : gatheringPlace.trim();
    }

    public String getDisbandedPlace() {
        return disbandedPlace;
    }

    public void setDisbandedPlace(String disbandedPlace) {
        this.disbandedPlace = disbandedPlace == null ? null : disbandedPlace.trim();
    }

    public Integer getTravelTopoId() {
        return travelTopoId;
    }

    public void setTravelTopoId(Integer travelTopoId) {
        this.travelTopoId = travelTopoId;
    }
}