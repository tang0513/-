package com.txy.meet.mapper;

import java.util.List;

import com.txy.meet.entity.Provinces;

public interface ProvincesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Provinces record);

    int insertSelective(Provinces record);

    Provinces selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provinces record);

    int updateByPrimaryKey(Provinces record);

	List<Provinces> findProAll();
}