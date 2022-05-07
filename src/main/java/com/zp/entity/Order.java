package com.zp.entity;

import java.util.ArrayList;
import com.zp.vo.BookVo;

import java.util.Date;
import java.util.List;

public class Order {
    private String oId;
    private List<String> bName;

    public List<String>  getbName() {
        return bName;
    }

    public void setbName(List<String>  bName) {
        this.bName = bName;
    }

    private Float oTotal;
    private String itemMap;

    public String getItemMap() {
        return itemMap;
    }

    public void setItemMap(String itemMap) {
        this.itemMap = itemMap;
    }

    private Integer oAmount;
//    private List<String> btName;
    private List<Orderitem> itemList;

    public List<Orderitem> getItemList() {
        return itemList;
    }

    public void setItemList(List<Orderitem> itemList) {
        this.itemList = itemList;
    }

//    public List<String>  getBtName() {
//        return btName;
//    }
//
//    public void setBtName(List<String>  btName) {
//        this.btName = btName;
//    }

    public Float getOiPrice() {
        return oiPrice;
    }

    public void setOiPrice(Float oiPrice) {
        this.oiPrice = oiPrice;
    }

    private Float oiPrice;

    private Integer oStatus;

    private Integer oPaytype;

    private Integer uId;

    private Date oDatetime;

    private String oRealname;

    private String oPhone;

    private String oAddress;

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
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
        this.oRealname = oRealname == null ? null : oRealname.trim();
    }

    public String getoPhone() {
        return oPhone;
    }

    public void setoPhone(String oPhone) {
        this.oPhone = oPhone == null ? null : oPhone.trim();
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress == null ? null : oAddress.trim();
    }




    public void addbooks(Book book) {

    }
}
