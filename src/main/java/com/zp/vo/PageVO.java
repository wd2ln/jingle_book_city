package com.zp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalCount;
    private Integer totalPage;
    private List<Object> list;

    public void SetPageSizeAndTotalCount(int pageSize,int totalCount)
    {
        this.pageSize=pageSize;
        this.totalCount=totalCount;
        totalPage= (int)Math.ceil((double)totalCount/pageSize);
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
