package com.zp.service;

import com.zp.vo.PageInfoVO;
import com.zp.vo.PageVo;

public interface FBookService {
    String findBookTypeById(Integer btId);

    PageInfoVO findBookTypeId(Integer btId, int pageNumber);
}
