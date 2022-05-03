package com.zp.service;

import com.zp.entity.Booktype;
import com.zp.vo.ResultVO;

import java.util.List;


public interface BookTypeService {
    ResultVO typeList();

    List<Booktype> select();
}
