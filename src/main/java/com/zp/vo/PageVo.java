package com.zp.vo;

import com.zp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo<T> {
    private Integer pageSize;
    private Integer pageNumber;
    private Integer totalPage;
    private Integer totalCount;
//<<<<<<< HEAD
    private List<BookVo> itemList;
    private List<T> list;

    public List<BookVo> getItemList() {
        return itemList;
    }

    public void setItemList(List<BookVo> itemList) {
        this.itemList = itemList;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
//=======

//    private List<User> list;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

//    public List<User> getList() {
//        return list;
//    }
//
//    public void setList(List<User> list) {
//        this.list = list;
//    }

    public void setPageSizeAndTotalCount(int pageSize,int totalCount) {
        this.pageSize=pageSize;
        this.totalCount=totalCount;
        totalPage= (int)Math.ceil((double)totalCount/pageSize);
    }
//>>>>>>> zsj
}
