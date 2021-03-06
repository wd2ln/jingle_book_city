package com.zp.dao;

import com.zp.entity.Booktype;
import com.zp.entity.BooktypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BooktypeMapper {
    long countByExample(BooktypeExample example);

    int deleteByExample(BooktypeExample example);

    int deleteByPrimaryKey(Integer btId);

    int insert(Booktype record);

    int insertSelective(Booktype record);

    List<Booktype> selectByExample(BooktypeExample example);

    Booktype selectByPrimaryKey(Integer btId);

    int updateByExampleSelective(@Param("record") Booktype record, @Param("example") BooktypeExample example);

    int updateByExample(@Param("record") Booktype record, @Param("example") BooktypeExample example);

    int updateByPrimaryKeySelective(Booktype record);

    int updateByPrimaryKey(Booktype record);

    List<Booktype> select();

    int insertType(String tbname);

    int updateType(Integer btid, String btname);

    String findBookTypeById(int btId);

    int findCountBookById(int btId);

    List findBooksByBtid(int btId, int pageIndex, int pageSize);
}