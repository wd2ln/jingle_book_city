package com.zp.entity;

import java.util.List;

public class Orderitem {
    private Integer oiId;

    private Float oiPrice;

    private Integer oiAmount;
    private Book book;



    private Integer bId;

    public Book getBook() {
        return book;
    }

//    public void setBook(Book book) {
//        this.book = book;
//    }

    private String oId;

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

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
    }




//<<<<<<< HEAD
//=======
    public void setBook(Book book) {
        this.book = book;
    }

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
//>>>>>>> ssj
}