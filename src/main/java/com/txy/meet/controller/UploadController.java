package com.txy.meet.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.txy.meet.common.FastDFSClient;
import com.txy.meet.common.PageResult;


@Controller
@RequestMapping("pages")
public class UploadController {

	private Logger log=LoggerFactory.getLogger(UploadController.class);
	
	@Value("${FILE_SERVER_URL}")
	private String FILE_SERVER_URL;
	
	@RequestMapping("upload")
	@ResponseBody
	public PageResult upload(MultipartFile file,HttpServletRequest request) throws Exception {
		
		String originalFilename = file.getOriginalFilename();  //获取文件名
		String substring = originalFilename.substring(originalFilename.lastIndexOf(".")+1);  //得到扩展名
		
		FastDFSClient client=new FastDFSClient("classpath:fdfs_client.conf");
		String uploadFile = client.uploadFile(file.getBytes(), substring);
		String url=FILE_SERVER_URL+uploadFile;   //获取图片的完整地址
			
		return PageResult.success(url);
	}
	
	
}
