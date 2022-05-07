package com.zp.service;

import com.zp.entity.Book;
import com.zp.entity.Order;
import com.zp.entity.User;
import com.zp.vo.PageVO;

import java.util.List;

public interface BookService {
    List<Book> sel(int rtype, Integer pageNumber, Integer pageSize);

    Book selBookId(Integer bId, Order order);

    User getUserInfo(Integer user);
    Object byId(Integer bId);

    Boolean addBook(Book b);

    PageVO queryBook(Integer pageNumber, Integer rtyper);

    void insertOrder(Order order);

    Book sell(Integer bId);
}
