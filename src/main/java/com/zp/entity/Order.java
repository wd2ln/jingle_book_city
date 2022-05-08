package com.zp.entity;

//<<<<<<< HEAD
import java.util.ArrayList;
import com.zp.vo.BookVo;

import java.util.Date;
import java.util.List;
//=======
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zp.util.PriceUtil;


import java.util.*;
//>>>>>>> ssj

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
//    private String itemMap;

//    public String getItemMap() {
//        return itemMap;
//    }

//    public void setItemMap(String itemMap) {
//        this.itemMap = itemMap;
//    }

    private Integer oAmount;
//    private List<String> btName;
//    private List<Orderitem> itemList;

//    public List<Orderitem> getItemList() {
//        return itemList;
//    }
//
//    public void setItemList(List<Orderitem> itemList) {
//        this.itemList = itemList;
//    }

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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



//<<<<<<< HEAD
//=======
    private List<Orderitem> itemList = new ArrayList<Orderitem>();

    public List<Orderitem> getItemList() {
        return itemList;
    }

    public void setItemList(List<Orderitem> itemList) {
        this.itemList = itemList;
    }
    private Map<Integer,Orderitem> itemMap = new HashMap<Integer,Orderitem>();
//>>>>>>> ssj

    public Map<Integer, Orderitem> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Integer, Orderitem> itemMap) {
        this.itemMap = itemMap;
    }
    //增加图书
    public void addbooks(Book book) {
        //获取关键bId
        if (itemMap.containsKey(book.getbId())){
            //根据bId找到对应的orderItem
        Orderitem orderitem = itemMap.get(book.getbId());
            //设置OiAmount(总量) +1;
        orderitem.setOiAmount(orderitem.getOiAmount()+1);
       }else {
            //如果在Orderitem中未查到bId，new 一个orderitem，设置初始值
           Orderitem orderitem = new Orderitem();

           orderitem.setOiPrice(book.getbPrice());
           orderitem.setOiAmount(1);
           orderitem.setBook(book);
           orderitem.setOrder(this);
           orderitem.setbId(book.getbId());
           //存放于map中
           itemMap.put(book.getbId(),orderitem);
       }
        //对订单中 oAmount(图书总数)、oTotal(总价) 递加
       oAmount++;
       oTotal= PriceUtil.add(oTotal,book.getbPrice());
    }
    //减去图书
    public void lessen(Integer bId) {
        //获取关键bId
        if (itemMap.containsKey(bId)){
            Orderitem orderitem=itemMap.get(bId);
            //  -
            orderitem.setOiAmount(orderitem.getOiAmount()-1);
           // 更新Orderitem中图书数量，随OiAmount递减
            oAmount--;
            //更新价格
            oTotal=PriceUtil.lenssen(oTotal,orderitem.getOiPrice());
            //如果图书减至0，则根据bId在购物车中移除该图书
            if (orderitem.getOiAmount()<=0){
                itemMap.remove(bId);
            }
        }
    }
    //删除图书
    public void delete(Integer bId) {
        //获取关键bId
        if (itemMap.containsKey(bId)){
            Orderitem orderitem = itemMap.get(bId);

            oTotal=PriceUtil.lenssen(oTotal, orderitem.getOiPrice()*orderitem.getOiAmount());
            oAmount-=orderitem.getOiAmount();

            itemMap.remove(bId);
        }
    }
}
