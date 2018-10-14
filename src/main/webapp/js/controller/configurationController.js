  app.controller('configurationController',function($scope,$controller,$location,configurationService,$http){
    	 $controller('baseController',{$scope:$scope});
    	 $scope.entity={configuration:{}};//定义页面实体结构  //定义实体类结构
    	  $scope.findManageAll=function(){
    		  configurationService.findManageAll().success(
    				function(resp){
    			     $scope.managementList = resp;
    		  })
    	  }
    	  
    	  $scope.mstatus=['未审核','已审核','审核未通过','关闭'];//会议状态
    	  
    	  //分页查询列表
    	  $scope.findPage=function(currentPage,pageSize,searchEntity){
    		 configurationService.findPage(currentPage,pageSize,searchEntity).success(
      				function(resp){
      			    $scope.list = resp.rows;
      			    $scope.paginationConf.totalItems=resp.total;
      		  })
    	  }
    	  //会议日程
    	  $scope.findSchePage=function(currentPage,pageSize,searchEntity){
     		 configurationService.findSchePage(currentPage,pageSize,searchEntity).success(
       				function(resp){
       			    $scope.scheList = resp.rows;
       			    $scope.schePaginationConf.totalItems=resp.total;
       		  })
     	  }
    	  
    	  
    	  //增加商品
    	  $scope.save=function(){
    		 if($scope.configuration.id!=null){                    //如果有ID
    			 configurationService.update($scope.configuration).success({     //修改
    				 function(resp){
    					 if(resp==true){
    						 alert("修改成功");
    						 $scope.entity={};
       		    		  	 editor.html("");                     //清空富文本编辑器
       		    		  location.href="configuration.html";             //跳转到商品列表页
    					 }
    					 if(resp!=true) alert("修改失败");
    				 }
    			 });
    		 }else{
    			 if($scope.configuration.firstNum!=null){
    				 $scope.configuration.mphone=$scope.configuration.firstNum+$scope.configuration.SecondNum;
    			 }
    			 configurationService.save($scope.configuration).success(        //增加
    		    	function(resp){
    		    		if(resp.status){
    		    			alert(resp.msg);
    		    			$scope.configuration={};                       //清空所有绑定entity的值
      		    		  	editor.html(""); 
    		    		}else{
    		    			alert(resp.msg);
    		    		}
    		    	});
    		 }
    	  }
    	
    	    
    	    
    	$scope.mstatus=['未审核','已审核','审核未通过','关闭'];//商品状态
    	
    	$scope.itemCatList=[];//商品分类列表
    	//加载商品分类列表
    	$scope.findItemCatList=function(){		
    		configurationService.findAll().success(
    				function(response){							
    					for(var i=0;i<response.length;i++){
    						$scope.itemCatList[response[i].id]=response[i].name;
    					}
    				});
    	}
    	
    	$scope.findProAll=function(){
    		configurationService.findProAll().success(
    				function(resp){
    					$scope.proList=resp; 
    				}
    		);
    	}
    	
      //读取二级分类
  	  $scope.$watch('configuration.mid', function(newValue) {
  		  $scope.searchEntity.mid=newValue;
  		  $scope.list={};
  		  $scope.scheList={};
  		  $scope.reloadList();
  		  $scope.scheReloadList();
  	  }); 
  	  
  	  $scope.deld1 = function(){
  		configurationService.deld1($scope.selectChecked).success(
  				function(resp){
  					if(resp.status){
  			    		 alert(resp.msg);
  	  				   	 $scope.reloadList();
  	      			 }else{
  	      				alert(resp.msg);
  	      			 }
  				}
  		);
  	  }
  	  
  	$scope.deld3 = function(){
  		configurationService.deld3($scope.selectChecked).success(
  				function(resp){
  					if(resp.status){
  			    		 alert(resp.msg);
  	  				   	 $scope.reloadList();
  	      			 }else{
  	      				alert(resp.msg);
  	      			 }
  				}
  		);
  	  }
    	
    	




        
        
        
    	  
      });