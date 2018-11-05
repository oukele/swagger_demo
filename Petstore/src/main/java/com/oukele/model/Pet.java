package com.oukele.model;

import javax.validation.constraints.NotBlank;

public class Pet {
    private Integer pId;

    private String pName;

    private String photoUrls;

    private String status;

    private Integer cId;
    private Tag tag;

    private Integer tId;

    private Category category;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String photoUrls) {
        this.photoUrls = photoUrls == null ? null : photoUrls.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", photoUrls='" + photoUrls + '\'' +
                ", status='" + status + '\'' +
                ", tag=" + tag +
                ", category=" + category +
                '}';
    }
}