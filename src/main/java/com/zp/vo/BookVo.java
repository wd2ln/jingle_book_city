package com.zp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookVo {
    private String bName;
    private Float oiPrice;
    private Integer oiAmount;
}
