package com.zp.entity;

import java.util.Date;

public class User {
    private Integer uId;

    private String uName;

    private String uPwd;

    private String uRealname;

    private Date uRedgt;

    private Integer uRole;

    private String uMark;

    private String uPhone;

    private String uAddress;

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    private String isadmin;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd == null ? null : uPwd.trim();
    }

    public String getuRealname() {
        return uRealname;
    }

    public void setuRealname(String uRealname) {
        this.uRealname = uRealname == null ? null : uRealname.trim();
    }

    public Date getuRedgt() {
        return uRedgt;
    }

    public void setuRedgt(Date uRedgt) {
        this.uRedgt = uRedgt;
    }

    public Integer getuRole() {
        return uRole;
    }

    public void setuRole(Integer uRole) {
        this.uRole = uRole;
    }

    public String getuMark() {
        return uMark;
    }

    public void setuMark(String uMark) {
        this.uMark = uMark == null ? null : uMark.trim();
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress == null ? null : uAddress.trim();
    }
}