package com.zp.service;

import com.zp.entity.Booktype;
import com.zp.vo.ResultVO;

import java.util.List;


public interface BookTypeService {
    ResultVO typeList();


    List<Booktype> select();

    ResultVO typeAdd(String tbname);

    ResultVO typeDel(Integer btid);

    ResultVO typeUpdate(Integer btid, String btname);
}
