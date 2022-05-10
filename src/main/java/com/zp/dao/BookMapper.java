package com.zp.dao;

import com.zp.entity.Book;
import com.zp.entity.BookExample;
import java.util.List;

//<<<<<<< HEAD
//import com.zp.entity.BookOrderOrderitem;
//=======
////import com.zp.entity.BookOrderOrderitem;
//>>>>>>> yu
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

//<<<<<<< HEAD
//    List<BookOrderOrderitem> selectByStatus(Integer ostatus);
//=======
////    List<BookOrderOrderitem> selectByStatus(Integer ostatus);
//>>>>>>> yu
    Book selectByBname(Integer bId);

    Book selectByPrimaryKey(Integer bId);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

//<<<<<<< HEAD
    int queryCountOfBooks();

    List<Book> queryBooks(@Param("i") int i, @Param("i1") int i1);
//<<<<<<< HEAD
//=======
//    int searchBookKeyword(String keyword);
//<<<<<<< HEAD
////>>>>>>> zsj
//=======

    List<Book> searchBookByKeyword(@Param("keyword") String keyword,@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);

    int findCountBooks();

    List<Book> findBooks(int pageIndex, int pageSize);

    int findBooksById();
//>>>>>>> zsj
//=======
    int searchBookKeyword(String keyword);

    int addBook(Book book);

    void delBook(Integer bid);

    int updateBook(Book book);
//>>>>>>> yu
}