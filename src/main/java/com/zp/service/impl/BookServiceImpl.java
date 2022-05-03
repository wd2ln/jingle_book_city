package com.zp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zp.dao.BookMapper;
import com.zp.entity.Book;
import com.zp.entity.BookExample;
import com.zp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
   @Autowired
   private BookMapper bookDao;

   @Override
   public Object byId(Integer bId) {
      Book g = bookDao.selectByPrimaryKey(bId);

      return g;
   }
}
