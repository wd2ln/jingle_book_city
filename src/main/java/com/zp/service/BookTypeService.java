package com.zp.service;

import com.zp.entity.Booktype;
import com.zp.vo.ResultVO;


public interface BookTypeService {
    ResultVO typeList();

    ResultVO typeAdd(String tbname);

    ResultVO typeDel(Integer btid);

    ResultVO typeUpdate(Integer btid, String btname);
}
