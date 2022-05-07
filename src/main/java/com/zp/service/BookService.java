package com.zp.service;

import com.zp.entity.Book;
import com.zp.vo.PageVo;

import java.util.List;

public interface BookService {
    List<Book> sel(int rtype, Integer pageNumber, Integer pageSize);

    Book find(int bId);

    PageVo searchBook(int pageNumber, String keyword);
}
