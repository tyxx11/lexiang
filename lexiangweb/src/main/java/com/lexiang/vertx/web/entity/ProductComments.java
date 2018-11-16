package com.lexiang.vertx.web.entity;

public class ProductComments extends ProductCommentsKey {
    private String name;

    private String comentsConntent;

    private String profilePhoto;

    private Integer productId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getComentsConntent() {
        return comentsConntent;
    }

    public void setComentsConntent(String comentsConntent) {
        this.comentsConntent = comentsConntent == null ? null : comentsConntent.trim();
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto == null ? null : profilePhoto.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}