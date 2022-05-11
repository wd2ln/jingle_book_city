package com.zp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zp.dao.*;
import com.zp.entity.*;
import com.zp.dao.BookMapper;
import com.zp.dao.RecommendMapper;
import com.zp.entity.Book;
import com.zp.entity.BookExample;
import com.zp.service.BookService;
import com.zp.vo.PageVO;
import com.zp.vo.ResultVO;
import com.zp.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
   @Autowired
   private BookMapper bookDao;
   @Autowired
   private OrderitemMapper orderitemMapper;
   @Autowired
   private BookMapper bookMapper;
   @Autowired
   private OrderMapper orderMapper;
   @Autowired
   private UserMapper userMapper;
   @Autowired
    private RecommendMapper recommendDao;
    @Autowired
   private RecommendMapper recommendMapper;

    @Override
    public List<Book> sel(int rtype, Integer pageNumber, Integer pageSize) {

        PageHelper.startPage(pageNumber,pageSize);


        BookExample example = new BookExample();

        BookExample.Criteria criteria = example.createCriteria();



        List<Book> books = bookMapper.selectByExample(example);
        PageInfo<Book> info = new PageInfo<>(books);

        return info.getList();
    }

    @Override
    public void insertOrder(Order order) {
        int i = orderMapper.insert(order);
    }

    @Override
    public Book sell(Integer bId) {
        return bookMapper.selectByPrimaryKey(bId);
    }

    @Override
    public Book find(int bId) {
        return bookDao.selectByPrimaryKey(bId);
    }

    @Override
    public Object byId(Integer bId) {
        Book g = bookDao.selectByPrimaryKey(bId);

        return g;
    }

    @Override
    public User getUserInfo(Integer user) {
        User user1 = userMapper.selectByKey(user);
        if (user1!=null){
            return user1;
        }
        return null;
    }


    @Override
    public PageVo searchBook(int pageNumber, String keyword) {
        PageVo p = new PageVo();
        p.setPageNumber(pageNumber);
        int count = 0;
        try {
            count = bookDao.searchBookKeyword(keyword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        p.setPageSizeAndTotalCount(8, count);
        List l = null;
        try {
            l = bookDao.searchBookByKeyword("%" + keyword + "%", (pageNumber - 1) * 8, 8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        p.setList(l);
        return p;
    }

    @Override
    public ResultVO addBook(Book book) {
        int i = bookDao.addBook(book);
        ResultVO vo;

        if (i < 0) {
            vo = new ResultVO(400, "添加失败", false, null);
        } else {
            vo = new ResultVO(200, "添加成功", true, null);
        }

        return vo;
    }

    @Override
    public PageVO queryBook(Integer pageNumber, Integer rtype) {
        PageVO p = new PageVO();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            if (rtype == 0)
                totalCount = bookDao.queryCountOfBooks();
            else
                totalCount = recommendDao.queryRecommendCountOfBooksByTypeID(rtype);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        p.SetPageSizeAndTotalCount(8, totalCount);
        List<Book> list = null;
        try {
            if (rtype == 0)
                list = bookDao.queryBooks((pageNumber - 1) * 8, 8);
            else
                list = recommendDao.queryBookByRecommendType(rtype, (pageNumber - 1) * 8, 8);
            for (int i = 0; i < list.size(); i++) {
                Book book = list.get(i);
                book.setScroll(recommendDao.queryBookByRtypeAndBid(1, book.getbId()) >= 1);
                book.setHot(recommendDao.queryBookByRtypeAndBid(2, book.getbId()) >= 1);
                book.setNew(recommendDao.queryBookByRtypeAndBid(3, book.getbId()) >= 1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        p.setList((List) list);
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
    @Override
    public Book queryBookByID(Integer bId) {
        return bookMapper.selectByPrimaryKey(bId);
    }

    public ResultVO addRecommendBook(Integer bid, Integer rtype) {
        int i = recommendDao.addRecommendBook(bid,rtype);
        ResultVO vo;

        if (i < 0) {
            vo = new ResultVO(400, "添加失败", false, null);
        } else {
            vo = new ResultVO(200, "添加成功", true, null);
        }

        return vo;
    }

    @Override
    public ResultVO delRecommendBook(Integer bid, Integer rtype) {
        int i = recommendDao.delRecommendBook(bid,rtype);
        ResultVO vo;

        if (i < 0) {
            vo = new ResultVO(400, "移出失败", false, null);
        } else {
            vo = new ResultVO(200, "移出成功", true, null);
        }

        return vo;
    }

    @Override
    public Boolean delBook(Integer bid) {
        try {
            bookDao.delBook(bid);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public ResultVO updateBook(Book book) {
        int i = bookDao.updateBook(book);
        ResultVO vo;

        if (i < 0) {
            vo = new ResultVO(400, "添加失败", false, null);
        } else {
            vo = new ResultVO(200, "添加成功", true, null);
        }

        return vo;
    }
}
