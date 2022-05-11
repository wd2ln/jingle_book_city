package com.zp.service.impl;

import com.zp.dao.BookMapper;
import com.zp.dao.BooktypeMapper;
import com.zp.service.FBookService;
import com.zp.vo.PageInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FBookTypeServiceImpl implements FBookService {
    @Autowired
    private BooktypeMapper booktypeMapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public String findBookTypeById(Integer btId) {
        return booktypeMapper.findBookTypeById(btId);
    }

    @Override
    public PageInfoVO findBookTypeId(Integer btId, int pageNumber) {
        PageInfoVO p = new PageInfoVO();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            if (btId==-1){
                totalCount=bookMapper.findBooksById();
            }else {
                totalCount=booktypeMapper.findCountBookById(btId);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        p.setPageSizeAndTotalCount(8, totalCount);
        List l=null;
        try {
            if (btId==-1){
                l=bookMapper.findBooks((pageNumber-1)*8,8);
            }else {
                l=booktypeMapper.findBooksByBtid(btId,(pageNumber-1)*8,8);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        p.setList(l);
        return p;
    }
}
