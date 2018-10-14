package com.txy.meet.mapper;

import java.util.List;

import com.txy.meet.entity.Management;
import com.txy.meet.entity.Provinces;

public interface ManagementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Management record);

    int insertSelective(Management record);

    Management selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Management record);

    int updateByPrimaryKey(Management record);

	List<Management> findByMeeting(Management management);

}