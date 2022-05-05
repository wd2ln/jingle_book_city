package com.zp.service;

import com.zp.entity.Book;
import com.zp.entity.Order;
import com.zp.entity.User;

import java.util.List;

public interface BookService {
    List<Book> sel(int rtype, Integer pageNumber, Integer pageSize);

    Book selBookId(Integer bId, Order order);

    User getUserInfo(Integer user);

    void insertOrder(Order order);

    Book sell(Integer bId);
}
