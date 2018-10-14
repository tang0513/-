package com.txy.meet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.txy.meet.common.DataGrid;
import com.txy.meet.common.FastDFSClient;
import com.txy.meet.common.PageResult;
import com.txy.meet.entity.Guid;
import com.txy.meet.entity.Management;
import com.txy.meet.entity.Schedule;
import com.txy.meet.service.ConfigurationService;

@RestController
@RequestMapping("configuration")
public class ConfigurationController {

	@Autowired
	private ConfigurationService configurationService;
	
	private Logger log=LoggerFactory.getLogger(ConfigurationController.class);
	
	@Value("${FILE_SERVER_URL}")
	private String FILE_SERVER_URL;
	
	/**
	 * 页面初始化查询下拉
	 * @return
	 */
	@RequestMapping("findManageAll")
	public List<Management> findManageAll() {
		List<Management> list = configurationService.findManageAll();
		return list;
	}
	
	@RequestMapping("findGuidByMid")
	public List<Guid> findGuidByMid(Integer mid) {
		List<Guid> list = configurationService.findGuidByMid(mid);
		return list;
	}
	
	/**
	 * 参会指南分页列表
	 * @param currentPage
	 * @param pageSize
	 * @param guid
	 * @return
	 */
	@RequestMapping("listPage")
	public DataGrid listPage(Integer currentPage,Integer pageSize,@RequestBody Guid guid) {
		DataGrid listPage = configurationService.listPage(currentPage,pageSize,guid);
		return listPage;
	}
	
	/**
	 * 会议日程分页列表
	 * @param currentPage
	 * @param pageSize
	 * @param schedule
	 * @return
	 */
	@RequestMapping("findSchePage")
	public DataGrid findSchePage(Integer currentPage,Integer pageSize,@RequestBody Schedule schedule) {
		DataGrid listPage = configurationService.findSchePage(currentPage,pageSize,schedule);
		return listPage;
	}
	
	/**
	 * 参会指南添加,文件上传
	 * @param guid
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("addGuid")
	public PageResult addGuid(Guid guid,MultipartFile file) throws Exception {
		String originalFilename = file.getOriginalFilename();  //获取文件名
		String substring = originalFilename.substring(originalFilename.lastIndexOf(".")+1);  //得到扩展名
		FastDFSClient client=new FastDFSClient("classpath:fdfs_client.conf");
		String uploadFile = client.uploadFile(file.getBytes(), substring);
		String url=FILE_SERVER_URL+uploadFile;   //获取图片的完整地址
		guid.setUrl(url);
		int i = configurationService.addGuid(guid);
		if(i>0) {
			return new PageResult(true, "添加成功");
		}else {
			return new PageResult(false, "添加失败");
		}
	}
	
	
	/**
	 * 会议日程添加
	 * @param schedule
	 * @return
	 */
	@RequestMapping("addSchedule")
	public PageResult addSchedule(Schedule schedule) {
		int i = configurationService.addSchedule(schedule);
		if(i>0) {
			return new PageResult(true, "添加成功");
		}else {
			return new PageResult(false, "添加失败");
		}
	}
	
	/**
	 * 参会指南批删
	 * @param ids
	 * @return
	 */
	@RequestMapping("deld1")
	public PageResult deld1(int[] ids) {
		int i = configurationService.delDuleByIds(ids);
		if(i>0) {
			return new PageResult(true, "删除成功");
		}else {
			return new PageResult(false, "删除失败");
		}
	}
	
	/**
	 * 会议日程批删
	 * @param ids
	 * @return
	 */
	@RequestMapping("deld3")
	public PageResult deld3(int[] ids) {
		int i = configurationService.delScheduleByIds(ids);
		if(i>0) {
			return new PageResult(true, "删除成功");
		}else {
			return new PageResult(false, "删除失败");
		}
	}
	
}
