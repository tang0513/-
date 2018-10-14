package com.txy.meet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.txy.meet.common.DataGrid;
import com.txy.meet.entity.Guid;
import com.txy.meet.entity.Management;
import com.txy.meet.entity.Schedule;
import com.txy.meet.mapper.GuidMapper;
import com.txy.meet.mapper.ManagementMapper;
import com.txy.meet.mapper.ScheduleMapper;

@Service
public class ConfigurationService {

	@Autowired
	private GuidMapper guidMapper;   //会议指南
	
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	@Autowired
	private ManagementMapper managementMapper;   //会议管理

	public List<Management> findManageAll() {
		Management management = new Management();
		return managementMapper.findByMeeting(management);
	}

	public List<Guid> findGuidByMid(Integer mid) {
		return guidMapper.findGuidByMid(mid);
	}

	public DataGrid listPage(Integer currentPage, Integer pageSize, Guid guid) {
		PageHelper.startPage(currentPage, pageSize);
		List<Guid> list=guidMapper.findByGuid(guid);
		PageInfo<Guid> pageInfo=new PageInfo<Guid>(list);
		return new DataGrid(pageInfo.getTotal(),pageInfo.getList());
	}

	public DataGrid findSchePage(Integer currentPage, Integer pageSize, Schedule schedule) {
		PageHelper.startPage(currentPage, pageSize);
		List<Schedule> list=scheduleMapper.findBySche(schedule);
		PageInfo<Schedule> pageInfo=new PageInfo<Schedule>(list);
		return new DataGrid(pageInfo.getTotal(),pageInfo.getList());
	}

	public int addGuid(Guid guid) {
		return guidMapper.insert(guid);
	}

	public int addSchedule(Schedule schedule) {
		return scheduleMapper.insert(schedule);
	}

	public int delDuleByIds(int[] ids) {
		int i = 0;
		for (int id : ids) {
			i = guidMapper.deleteByPrimaryKey(id);
		}
		return i;
	}

	public int delScheduleByIds(int[] ids) {
		int i = 0;
		for (int id : ids) {
			i = scheduleMapper.deleteByPrimaryKey(id);
		}
		return i;
	}
	
}
