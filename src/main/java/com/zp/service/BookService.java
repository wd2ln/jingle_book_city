package com.zp.service;

import com.zp.entity.Book;
import com.zp.entity.Books;
import com.zp.vo.PageVO;
import com.zp.vo.ResultVO;

import java.util.List;

public interface BookService {
    Object byId(Integer bId);

    ResultVO addBook(Book b);

    PageVO queryBook(Integer pageNumber, Integer rtyper);

}
