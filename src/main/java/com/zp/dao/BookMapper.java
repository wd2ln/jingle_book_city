package com.zp.dao;

import com.zp.entity.Book;
import com.zp.entity.BookExample;
import java.util.List;

//import com.zp.entity.BookOrderOrderitem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer bId);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

//    List<BookOrderOrderitem> selectByStatus(Integer ostatus);
    Book selectByBname(Integer bId);

    Book selectByPrimaryKey(Integer bId);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    int queryCountOfBooks();

    List<Book> queryBooks(@Param("i") int i, @Param("i1") int i1);
    int searchBookKeyword(String keyword);

    int addBook(Book book);
}