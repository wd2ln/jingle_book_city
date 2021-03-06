package com.zp.service.impl;

import com.zp.dao.BooktypeMapper;
import com.zp.entity.Booktype;
import com.zp.service.BookTypeService;
import com.zp.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private BooktypeMapper bookTypeDao;

    @Override
    public ResultVO typeList() {
        ResultVO vo;

        List<Booktype> booktypes = bookTypeDao.selectByExample(null);

        if (booktypes.size() == 0){
            vo =new ResultVO(400,"查询失败",false,null);
        }else {
            vo =new ResultVO(200,"查询成功",true,booktypes);
        }


        return vo;
    }

    @Override
    public List<Booktype> select() {
        return bookTypeDao.select();
    }
    public ResultVO typeAdd(String tbname) {
        int i = bookTypeDao.insertType(tbname);

        ResultVO vo;

        if (i<0){
            vo =new ResultVO(400,"添加失败",false,null);
        }else {
            vo =new ResultVO(200,"添加成功",true, null);
        }

        return vo;
    }

    @Override
    public ResultVO typeDel(Integer btid) {
        int i = bookTypeDao.deleteByPrimaryKey(btid);
        ResultVO vo;

        if (i<0){
            vo =new ResultVO(400,"删除失败",false,null);
        }else {
            vo =new ResultVO(200,"删除成功",true, null);
        }

        return vo;
    }

    @Override
    public ResultVO typeUpdate(Integer btid, String btname) {
        int i=bookTypeDao.updateType(btid,btname);
        ResultVO vo;

        if (i<0){
            vo =new ResultVO(400,"修改失败",false,null);
        }else {
            vo =new ResultVO(200,"修改成功",true, null);
        }

        return vo;
    }
}
