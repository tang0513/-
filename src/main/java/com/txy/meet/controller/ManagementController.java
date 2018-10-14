package com.txy.meet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.txy.meet.common.DataGrid;
import com.txy.meet.common.PageResult;
import com.txy.meet.entity.Cities;
import com.txy.meet.entity.Management;
import com.txy.meet.entity.Provinces;
import com.txy.meet.service.ManagementService;

@RestController
@RequestMapping("management")
public class ManagementController {

	private Logger log=LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired
	private ManagementService managementService;
	
	@RequestMapping("listPage")
	@ResponseBody
	public DataGrid listPage(Integer currentPage,Integer pageSize,@RequestBody Management management) {
		DataGrid listPage = managementService.listPage(currentPage,pageSize,management);
		return listPage;
	}
	
	@RequestMapping("addmanagement")
	public PageResult addmanagement(@RequestBody Management management) {
		int i = managementService.addManageMent(management);
		if(i>0) {
			return new PageResult(true, "添加成功");
		}else {
			return new PageResult(true, "添加失败");
		}
	}
	
	@RequestMapping("findProAll")
	public List<Provinces> findProAll() {
		List<Provinces> list = managementService.findProAll();
		return list;
	}
	
	@RequestMapping("findByCities")
	public List<Cities> findByCities(String provinceid) {
		List<Cities> list = managementService.findByCitiesByProVinceid(provinceid);
		return list;
	}
	
	@RequestMapping("findOne")
	public Management findOne(Integer id) {
		Management management = managementService.findOne(id);
		return management;
	}
	
	@RequestMapping("delOne")
	public PageResult delOne(Integer id) {
		int i = managementService.delOne(id);
		if(i>0) {
			return new PageResult(true, "删除成功");
		}else {
			return new PageResult(false, "删除失败");
		}
	}
	
	@RequestMapping("del")
	public PageResult del(int[] ids) {   //前台有多选框，执行的是批删的操作，传到后端的值为数组结构
		int i = managementService.del(ids);
		if(i>0) {
			return new PageResult(true, "删除成功");
		}else {
			return new PageResult(false, "删除失败");
		}
	}
	
	@RequestMapping("update")
	public PageResult update(@RequestBody Management management) {
		int i = managementService.update(management);
		if(i>0) {
			return new PageResult(true, "修改成功");
		}else {
			return new PageResult(false, "修改失败");
		}
	}
	
	
	
}
