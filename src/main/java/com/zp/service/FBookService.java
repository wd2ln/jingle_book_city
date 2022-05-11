package com.zp.service;

import com.zp.vo.PageInfoVO;

public interface FBookService {
    String findBookTypeById(Integer btId);

    PageInfoVO findBookTypeId(Integer btId, int pageNumber);
}
