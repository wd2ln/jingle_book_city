package com.zp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zp.dao.BookMapper;
import com.zp.entity.Book;
import com.zp.entity.BookExample;
import com.zp.service.BookService;
import com.zp.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
   @Autowired
   private BookMapper bookDao;

    @Override
    public List<Book> sel(int rtype, Integer pageNumber, Integer pageSize) {

        PageHelper.startPage(pageNumber,pageSize);


        BookExample example = new BookExample();

        BookExample.Criteria criteria = example.createCriteria();

        criteria.andBtIdEqualTo(rtype);

        List<Book> books = bookDao.selectByExample(example);
       // String bid = books.get(0).getBid();
        //System.out.printf();
        PageInfo<Book> info = new PageInfo<>(books);

        return info.getList();
    }

    @Override
    public Book find(int bId) {
        return bookDao.selectByPrimaryKey(bId);
    }

    @Override
    public PageVo searchBook(int pageNumber, String keyword) {
        PageVo p = new PageVo();
        p.setPageNumber(pageNumber);
        int count=0;
        count=bookDao.searchBookKeyword(keyword);
        return null;
    }
}
