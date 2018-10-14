package com.txy.meet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.txy.meet.entity.Cities;

public interface CitiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cities record);

    int insertSelective(Cities record);

    Cities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cities record);

    int updateByPrimaryKey(Cities record);

    @Select("select * from con_cities where provinceid = #{provinceid}")
	List<Cities> findCitiesByProvinceid(@Param("provinceid")String provinceid);

    @Select("select * from con_cities where cityid = #{cityid}")
	Cities findCitiesByCities(Cities cities);
}