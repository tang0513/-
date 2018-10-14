 //service 里面封装的是url请求
      app.service('managementService',function($http){
    	  this.findAll=function(){
    		  return $http.get('../management/list.do');
    	  };
    	  this.findPage=function(currentPage,pageSize,searchEntity){
    		  return  $http.post('../management/listPage.do?currentPage='+currentPage+"&pageSize="+pageSize,searchEntity);
    	  };
    	  this.save=function(entity){
    		  return  $http.post('../management/addmanagement.do',entity);
    	  };
    	  this.del=function(selectChecked){
    		  return $.get("../management/del.do?ids="+selectChecked);
    	  };
    	  this.findOne=function(id){
    		  return $.post("../management/findOne.do?id="+id);
    	  };
    	  this.update=function(entity){
    		  return $.post("../management/update.do",entity);
    	  };
    	  this.findProAll=function(){
    		  return $http.get("../management/findProAll.do");
    	  };
    	  this.findByCities=function(provinceid){
    		  return $http.get('../management/findByCities.do?provinceid='+provinceid);
    	  };
    	  this.delOne=function(id){
    		  return $.get("../management/delOne.do?id="+id);
    	  };
    	  
      })