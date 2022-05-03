package com.zp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateVo {
    private Integer uId;
    private String uPhone;
    private String uAddress;
}
