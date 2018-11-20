package com.lexiang.vertx.web.entity;

public class TravelTopo extends TravelTopoKey {
    private Integer productId;

    private String name;

    private String travelDate;

    private String photoAddress;

    private String accommodation;

    private String food;

    private String rangeOfDriving;

    private String topoAlias;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate == null ? null : travelDate.trim();
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress == null ? null : photoAddress.trim();
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation == null ? null : accommodation.trim();
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food == null ? null : food.trim();
    }

    public String getRangeOfDriving() {
        return rangeOfDriving;
    }

    public void setRangeOfDriving(String rangeOfDriving) {
        this.rangeOfDriving = rangeOfDriving == null ? null : rangeOfDriving.trim();
    }

    public String getTopoAlias() {
        return topoAlias;
    }

    public void setTopoAlias(String topoAlias) {
        this.topoAlias = topoAlias == null ? null : topoAlias.trim();
    }
}