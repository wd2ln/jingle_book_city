package com.zp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zp.dao.BookMapper;
import com.zp.dao.RecommendMapper;
import com.zp.entity.Book;
import com.zp.entity.BookExample;
import com.zp.service.BookService;
import com.zp.vo.PageVO;
import com.zp.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookDao;
    @Autowired
    private RecommendMapper recommendDao;

    @Override
    public Object byId(Integer bId) {
        Book g = bookDao.selectByPrimaryKey(bId);

        return g;
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
}
