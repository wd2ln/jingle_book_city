package com.zp.vo;

import com.zp.entity.Book;
import com.zp.entity.User;

import java.util.List;

public class PageInfoVO {
    private Integer pageSize;
    private Integer pageNumber;
    private Integer totalPage;
    private Integer totalCount;

    private List<Book> list;

    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSizeAndTotalCount(int pageSize,int totalCount) {
        this.pageSize=pageSize;
        this.totalCount=totalCount;
        totalPage= (int)Math.ceil((double)totalCount/pageSize);
    }
    @Override
    public String toString() {
        return "PageInfoVO{" +
                "pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }

    public PageInfoVO() {
    }

    public PageInfoVO(Integer pageSize, Integer pageNumber, Integer totalPage, Integer totalCount, List<Book> list) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.list = list;
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

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
