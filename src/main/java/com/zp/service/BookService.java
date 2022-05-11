package com.zp.service;

import com.zp.entity.Book;
import com.zp.entity.Order;
import com.zp.entity.User;
import com.zp.vo.PageVO;
import com.zp.vo.PageVo;
import com.zp.vo.ResultVO;

import java.util.List;

public interface BookService {
    List<Book> sel(int rtype, Integer pageNumber, Integer pageSize);

    User getUserInfo(Integer user);
    Object byId(Integer bId);

    ResultVO addBook(Book b);

    PageVO queryBook(Integer pageNumber, Integer rtyper);

    void insertOrder(Order order);

    Book sell(Integer bId);

    Book find(int bId);

    PageVo searchBook(int pageNumber, String keyword);

    Book queryBookByID(Integer bId);

    PageVo recommendBook(Integer rType, int pageNumber);

    ResultVO addRecommendBook(Integer bid, Integer rtype);

    ResultVO delRecommendBook(Integer bid, Integer rtype);

    Boolean delBook(Integer bid);

    ResultVO updateBook(Book book);
}
