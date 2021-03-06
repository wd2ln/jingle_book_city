package com.zp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zp.util.PriceUtil;
import java.util.*;

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

    private Integer oAmount;

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

    private List<Orderitem> itemList = new ArrayList<Orderitem>();

    public List<Orderitem> getItemList() {
        return itemList;
    }

    public void setItemList(List<Orderitem> itemList) {
        this.itemList = itemList;
    }
    private Map<Integer,Orderitem> itemMap = new HashMap<Integer,Orderitem>();

    public Map<Integer, Orderitem> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Integer, Orderitem> itemMap) {
        this.itemMap = itemMap;
    }
    //????????????
    public void addbooks(Book book) {
        //????????????bId
        if (itemMap.containsKey(book.getbId())){
            //??????bId???????????????orderItem
        Orderitem orderitem = itemMap.get(book.getbId());
            //??????OiAmount(??????) +1;
        orderitem.setOiAmount(orderitem.getOiAmount()+1);
       }else {
            //?????????Orderitem????????????bId???new ??????orderitem??????????????????
           Orderitem orderitem = new Orderitem();

           orderitem.setOiPrice(book.getbPrice());
           orderitem.setOiAmount(1);
           orderitem.setBook(book);
           orderitem.setOrder(this);
           orderitem.setbId(book.getbId());
           //?????????map???
           itemMap.put(book.getbId(),orderitem);
       }
        //???????????? oAmount(????????????)???oTotal(??????) ??????
       oAmount++;
       oTotal= PriceUtil.add(oTotal,book.getbPrice());
    }
    //????????????
    public void lessen(Integer bId) {
        //????????????bId
        if (itemMap.containsKey(bId)){
            Orderitem orderitem=itemMap.get(bId);
            //  -
            orderitem.setOiAmount(orderitem.getOiAmount()-1);
           // ??????Orderitem?????????????????????OiAmount??????
            oAmount--;
            //????????????
            oTotal=PriceUtil.lenssen(oTotal,orderitem.getOiPrice());
            //??????????????????0????????????bId??????????????????????????????
            if (orderitem.getOiAmount()<=0){
                itemMap.remove(bId);
            }
        }
    }
    //????????????
    public void delete(Integer bId) {
        //????????????bId
        if (itemMap.containsKey(bId)){
            Orderitem orderitem = itemMap.get(bId);

            oTotal=PriceUtil.lenssen(oTotal, orderitem.getOiPrice()*orderitem.getOiAmount());
            oAmount-=orderitem.getOiAmount();

            itemMap.remove(bId);
        }
    }
}
