package com.zp.dao;

import com.zp.entity.User;
import com.zp.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);
    int deleteByUid(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);
    User selectByKey(Integer uId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}