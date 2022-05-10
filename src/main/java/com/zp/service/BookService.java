package com.zp.service;

import com.zp.entity.Book;
//<<<<<<< HEAD
import com.zp.entity.Order;
import com.zp.entity.User;
import com.zp.vo.PageVO;
import com.zp.vo.PageVo;

//=======
import com.zp.entity.Books;
import com.zp.vo.PageVO;
import com.zp.vo.ResultVO;
//>>>>>>> yu

import java.util.List;

public interface BookService {
    List<Book> sel(int rtype, Integer pageNumber, Integer pageSize);

//<<<<<<< HEAD
//    Book selBookId(Integer bId, Order order);

    User getUserInfo(Integer user);
    Object byId(Integer bId);

    ResultVO addBook(Book b);

    PageVO queryBook(Integer pageNumber, Integer rtyper);

//<<<<<<< HEAD
    void insertOrder(Order order);

    Book sell(Integer bId);
//    Book find(int bId);
//
//    PageVo searchBook(int pageNumber, String keyword);
//<<<<<<< HEAD
//=======

    Book queryBookByID(Integer bId);
//>>>>>>> ssj
//=======

    PageVo recommendBook(Integer rType, int pageNumber);
//>>>>>>> zsj
//=======
    ResultVO addRecommendBook(Integer bid, Integer rtype);

    ResultVO delRecommendBook(Integer bid, Integer rtype);

    Boolean delBook(Integer bid);

    ResultVO updateBook(Book book);
//>>>>>>> yu
}
