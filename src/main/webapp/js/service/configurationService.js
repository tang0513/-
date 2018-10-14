 //service 里面封装的是url请求
      app.service('configurationService',function($http){
    	  this.findManageAll=function(){
    		  return $http.get('../configuration/findManageAll.do');
    	  };
    	  //分页查询列表
    	  this.findPage=function(currentPage,pageSize,searchEntity){
    		  return  $http.post('../configuration/listPage.do?currentPage='+currentPage+"&pageSize="+pageSize,searchEntity);
    	  };
    	  //会议日程分页查询列表
    	  this.findSchePage=function(currentPage,pageSize,searchEntity){
    		  return  $http.post('../configuration/findSchePage.do?currentPage='+currentPage+"&pageSize="+pageSize,searchEntity);
    	  };
    	  
    	  this.save=function(entity){
    		  return  $http.post('../configuration/addConfiguration.do',entity);
    	  };
    	  this.del=function(selectChecked){
    		  return $.get("../configuration/del.do?ids="+selectChecked);
    	  };
    	  this.findGuidByMid=function(mid){
    		  return $.get("../configuration/findGuidByMid.do?mid="+mid);
    	  };
    	  this.update=function(entity){
    		  return $.post("../configuration/update.do",entity);
    	  };
    	  this.findProAll=function(){
    		  return $http.get("../configuration/findProAll.do");
    	  };
    	  this.deld1=function(selectChecked){
    		  return $.get("../configuration/deld1.do?ids="+selectChecked);
    	  };
    	  this.deld3=function(selectChecked){
    		  return $.get("../configuration/deld3.do?ids="+selectChecked);
    	  };
      })