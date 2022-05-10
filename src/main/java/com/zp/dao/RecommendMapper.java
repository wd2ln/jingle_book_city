package com.zp.dao;

import com.zp.entity.Book;
import com.zp.entity.Recommend;
import com.zp.entity.RecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendMapper {
    long countByExample(RecommendExample example);

    int deleteByExample(RecommendExample example);

    int deleteByPrimaryKey(Integer rId);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    List<Recommend> selectByExample(RecommendExample example);

    Recommend selectByPrimaryKey(Integer rId);

    int updateByExampleSelective(@Param("record") Recommend record, @Param("example") RecommendExample example);

    int updateByExample(@Param("record") Recommend record, @Param("example") RecommendExample example);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);

    int findRecommendcountBooksByrType(int rType);

    List<Book> searchBookByRecommendType(int rType, int pageIndex, int pageSize);

    int findBookByRtypeAndBid(int i, Integer getbId);
}