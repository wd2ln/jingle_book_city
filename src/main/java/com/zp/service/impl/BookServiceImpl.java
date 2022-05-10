package com.zp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zp.dao.BookMapper;
import com.zp.dao.RecommendMapper;
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
   @Autowired
   private RecommendMapper recommendMapper;

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
        try {
            count=bookDao.searchBookKeyword(keyword);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        p.setPageSizeAndTotalCount(8,count);
        List l=null;
        try {
            l=bookDao.searchBookByKeyword("%"+keyword+"%",(pageNumber-1)*8,8);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        p.setList(l);
        return p;
    }

    @Override
    public PageVo recommendBook(Integer rType, int pageNumber) {
        PageVo p = new PageVo();
        p.setPageNumber(pageNumber);
        int count=0;
        try {
            if (rType==0) {
                count = bookDao.findCountBooks();
            }else {
                count=recommendMapper.findRecommendcountBooksByrType(rType);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        p.setPageSizeAndTotalCount(8,count);
        List<Book> l=null;
        try {
            if (rType==0) {
                l=bookDao.findBooks((pageNumber - 1) * 8, 8);
            }else {
                l = recommendMapper.searchBookByRecommendType(rType, (pageNumber - 1) * 8, 8);
            }
            for(int i=0;i<l.size();i++) {
                Book book=l.get(i);
                book.setScroll(recommendMapper.findBookByRtypeAndBid(1,book.getbId())>=1);
                book.setHot(recommendMapper.findBookByRtypeAndBid(2,book.getbId())>=1);
                book.setNew(recommendMapper.findBookByRtypeAndBid(3,book.getbId())>=1);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        p.setList((List)l);
        return p;
    }
}
