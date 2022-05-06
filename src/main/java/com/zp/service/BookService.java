package com.zp.service;

import com.zp.entity.Book;
import com.zp.vo.PageVO;

import java.util.List;

public interface BookService {
    Object byId(Integer bId);

    Boolean addBook(Book b);

    PageVO queryBook(Integer pageNumber, Integer rtyper);
}
