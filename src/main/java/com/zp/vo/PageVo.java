package com.zp.vo;

import com.zp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {
    private Integer pageSize;
    private Integer pageNumber;
    private Integer totalPage;
    private Integer totalCount;

    private List<User> list;
}
