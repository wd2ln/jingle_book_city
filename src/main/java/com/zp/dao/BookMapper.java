package com.zp.dao;

import com.zp.entity.Book;
import com.zp.entity.BookExample;
import java.util.List;
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

    Book selectByBname(Integer bId);

    Book selectByPrimaryKey(Integer bId);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    int queryCountOfBooks();

    List<Book> queryBooks(@Param("i") int i, @Param("i1") int i1);

    List<Book> searchBookByKeyword(@Param("keyword") String keyword,@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);

    int findCountBooks();

    List<Book> findBooks(int pageIndex, int pageSize);

    int findBooksById();

    int searchBookKeyword(String keyword);

    int addBook(Book book);

    void delBook(Integer bid);

    int updateBook(Book book);
}