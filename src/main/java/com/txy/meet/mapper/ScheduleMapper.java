package com.txy.meet.mapper;

import java.util.List;

import com.txy.meet.entity.Schedule;

public interface ScheduleMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);

	List<Schedule> findBySche(Schedule schedule);
}