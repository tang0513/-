package com.txy.meet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.txy.meet.entity.Guid;
import com.txy.meet.entity.Schedule;

public interface GuidMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Guid record);

    int insertSelective(Guid record);

    Guid selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Guid record);

    int updateByPrimaryKey(Guid record);

    @Select("select * from con_guid where mid = #{mid}")
	List<Guid> findGuidByMid(@Param("mid")Integer mid);

	List<Guid> findByGuid(Guid guid);

}