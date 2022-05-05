package com.zp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class BookOrderOrderitem{
    private Integer bId;

    private String bIsbn;

    private String bName;
    private String oId;

    private Float oTotal;

    private Integer oAmount;

    private Integer oStatus;

    private Integer oPaytype;

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

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
        this.bIsbn = bIsbn;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public Float getoTotal() {
        return oTotal;
    }

    public void setoTotal(Float oTotal) {
        this.oTotal = oTotal;
    }

    public Integer getoAmount() {
        return oAmount;
    }

    public void setoAmount(Integer oAmount) {
        this.oAmount = oAmount;
    }

    public Integer getoStatus() {
        return oStatus;
    }

    public void setoStatus(Integer oStatus) {
        this.oStatus = oStatus;
    }

    public Integer getoPaytype() {
        return oPaytype;
    }

    public void setoPaytype(Integer oPaytype) {
        this.oPaytype = oPaytype;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getoDatetime() {
        return oDatetime;
    }

    public void setoDatetime(Date oDatetime) {
        this.oDatetime = oDatetime;
    }

    public String getoRealname() {
        return oRealname;
    }

    public void setoRealname(String oRealname) {
        this.oRealname = oRealname;
    }

    public String getoPhone() {
        return oPhone;
    }

    public void setoPhone(String oPhone) {
        this.oPhone = oPhone;
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress;
    }

    public Integer getOiId() {
        return oiId;
    }

    public void setOiId(Integer oiId) {
        this.oiId = oiId;
    }

    public Float getOiPrice() {
        return oiPrice;
    }

    public void setOiPrice(Float oiPrice) {
        this.oiPrice = oiPrice;
    }

    public Integer getOiAmount() {
        return oiAmount;
    }

    public void setOiAmount(Integer oiAmount) {
        this.oiAmount = oiAmount;
    }

    public String getBtName() {
        return btName;
    }

    public void setBtName(String btName) {
        this.btName = btName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public String getbPublisher() {
        return bPublisher;
    }

    public void setbPublisher(String bPublisher) {
        this.bPublisher = bPublisher;
    }

    public String getbCover() {
        return bCover;
    }

    public void setbCover(String bCover) {
        this.bCover = bCover;
    }

    public String getbImage1() {
        return bImage1;
    }

    public void setbImage1(String bImage1) {
        this.bImage1 = bImage1;
    }

    public String getbImage2() {
        return bImage2;
    }

    public void setbImage2(String bImage2) {
        this.bImage2 = bImage2;
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
        this.bMark = bMark;
    }

    private Integer uId;

    private Date oDatetime;

    private String oRealname;

    private String oPhone;

    private String oAddress;
    private Integer oiId;

    private Float oiPrice;

    private Integer oiAmount;
    private String btName;

    private String bAuthor;

    private String bPublisher;

    private String bCover;

    private String bImage1;

    private String bImage2;

    private Float bPrice;

    private Integer btId;

    private Integer bStock;

    private String bMark;

}
