package com.zp.entity;

import org.springframework.stereotype.Repository;


public class Booktype {
    private Integer btId;

    private String btName;

    public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public String getBtName() {
        return btName;
    }

    public void setBtName(String btName) {
        this.btName = btName == null ? null : btName.trim();
    }
}