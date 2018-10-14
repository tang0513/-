package com.txy.meet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.txy.meet.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from con_user")
	List<User> findUserAll();
}