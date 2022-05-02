package com.zp.vo;

import com.zp.entity.Booktype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    private Integer code;
    private String message;
    private Boolean success;
    private List<Booktype> data;
}
