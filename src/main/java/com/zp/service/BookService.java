package com.zp.service;

import com.zp.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> sel(int rtype, Integer pageNumber, Integer pageSize);


    Book queryBookByID(Integer bId);
}
