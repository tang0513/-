app.service('uploadService',function($http){
	
	this.uploadFile=function(){
		var formdata=new FormData();
		formdata.append('file',file.files[0]);    //file文件上传框的name   file.files[0]取得第一个文件上传框
		
		//以下return块，搭配使用，指定文件上传模块
		return $http({
			url:'../pages/upload.do',     //提交路径
			method:'post',    		//提交方式
			data:formdata,    		//提交对象
			headers:{'Content-Type' :undefined},    //制定提交类型，默认为json类型，undefined将其妆花为Multipart类型
			transformRequest: angular.identity      //将提交表单转化为二进制序列化
		});				
	};
	
	
});