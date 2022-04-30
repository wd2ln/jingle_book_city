package com.zp.entity;

import org.springframework.stereotype.Component;

@Component
public class Book {
    private Integer bId;

    private String bIsbn;

    private String bName;

    private String bAuthor;

    private String bPublisher;

    private String bCover;

    private String bImage1;

    private String bImage2;

    private Float bPrice;

    private Integer btId;

    private Integer bStock;

    private String bMark;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbIsbn() {
        return bIsbn;
    }

    public void setbIsbn(String bIsbn) {
        this.bIsbn = bIsbn == null ? null : bIsbn.trim();
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor == null ? null : bAuthor.trim();
    }

    public String getbPublisher() {
        return bPublisher;
    }

    public void setbPublisher(String bPublisher) {
        this.bPublisher = bPublisher == null ? null : bPublisher.trim();
    }

    public String getbCover() {
        return bCover;
    }

    public void setbCover(String bCover) {
        this.bCover = bCover == null ? null : bCover.trim();
    }

    public String getbImage1() {
        return bImage1;
    }

    public void setbImage1(String bImage1) {
        this.bImage1 = bImage1 == null ? null : bImage1.trim();
    }

    public String getbImage2() {
        return bImage2;
    }

    public void setbImage2(String bImage2) {
        this.bImage2 = bImage2 == null ? null : bImage2.trim();
    }

    public Float getbPrice() {
        return bPrice;
    }

    public void setbPrice(Float bPrice) {
        this.bPrice = bPrice;
    }

    public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public Integer getbStock() {
        return bStock;
    }

    public void setbStock(Integer bStock) {
        this.bStock = bStock;
    }

    public String getbMark() {
        return bMark;
    }

    public void setbMark(String bMark) {
        this.bMark = bMark == null ? null : bMark.trim();
    }
}