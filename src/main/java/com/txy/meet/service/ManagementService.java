package com.txy.meet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.txy.meet.common.Constant;
import com.txy.meet.common.DataGrid;
import com.txy.meet.entity.Cities;
import com.txy.meet.entity.Management;
import com.txy.meet.entity.Provinces;
import com.txy.meet.mapper.CitiesMapper;
import com.txy.meet.mapper.ManagementMapper;
import com.txy.meet.mapper.ProvincesMapper;

@Service
public class ManagementService {

	private Logger log=LoggerFactory.getLogger(ManagementService.class);
	
	@Autowired
	private ManagementMapper meetingMapper;
	
	@Autowired
	private ProvincesMapper provincesMapper;
	
	@Autowired
	private CitiesMapper citiesMapper;

	/**
	 * 会议列表
	 * @param currentPage
	 * @param pageSize
	 * @param management
	 * @return
	 */
	public DataGrid listPage(Integer currentPage, Integer pageSize, Management management) {
		PageHelper.startPage(currentPage, pageSize);
		List<Management> list=findManagementList(management);
		PageInfo<Management> pageInfo=new PageInfo<Management>(list);
		return new DataGrid(pageInfo.getTotal(),pageInfo.getList());
	}
	
	/**
	 * 查询数据库方法，每次查询更新状态
	 * @param management
	 * @return
	 */
	private List<Management> findManagementList(Management management) {
		List<Management> list = meetingMapper.findByMeeting(management);
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");//可以方便地修改日期格式
		String rightTime = dateFormat.format( now );
		try {
			Date d1= dateFormat.parse(rightTime);
			for (Management management2 : list) {
				if(d1.getTime() > management2.getStartTime().getTime() && d1.getTime()<management2.getEndTime().getTime()) {
					management2.setMstates(Constant.MEET_STATUS_STARTING);
				}
				if(d1.getTime() > management2.getEndTime().getTime()) {
					management2.setMstates(Constant.MEET_STATUS_LODER);
				}
				if(d1.getTime()<management2.getStartTime().getTime()) {
					management2.setMstates(Constant.MEET_STATUS_NOSTART);
				}
				meetingMapper.updateByPrimaryKey(management2);
			}
		} catch (ParseException e) {
			log.info("获取当前日期异常");
		}
		return list;
	}

	/**
	 * 会议添加
	 * @param management
	 * @return
	 */
	public int addManageMent(Management management) {
		Cities cities = new Cities();
		cities.setCityid(management.getCityid().toString());
		cities = citiesMapper.findCitiesByCities(cities);
		management.setMcity(cities.getCity());
		return meetingMapper.insert(management);
	}

	/**
	 * 下拉框查找省份
	 * @return
	 */
	public List<Provinces> findProAll() {
		return provincesMapper.findProAll();
	}

	/**
	 * 根据省份所选中的id来查找城市，实现二级联动
	 * @param provinceid
	 * @return
	 */
	public List<Cities> findByCitiesByProVinceid(String provinceid) {
		return citiesMapper.findCitiesByProvinceid(provinceid);
	}

	/**
	 * 修改回显
	 * @param id
	 * @return
	 */
	public Management findOne(Integer id) {
		return meetingMapper.selectByPrimaryKey(id);
	}

	/**
	 * 单个删除
	 * @param id
	 * @return
	 */
	public int delOne(Integer id) {
		return meetingMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	public int del(int[] ids) {
		int i = 0;
		for (int id : ids) {
			i = meetingMapper.deleteByPrimaryKey(id);
		}
		return i;
	}

	/**
	 * 修改
	 * @param management
	 * @return
	 */
	public int update(Management management) {
		return meetingMapper.updateByPrimaryKey(management);
	}
	
	
	
}
