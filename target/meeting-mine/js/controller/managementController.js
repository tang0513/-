  app.controller('managementController',function($scope,$controller,$location,managementService,$http){
    	 $controller('baseController',{$scope:$scope});
    	 $scope.entity={management:{}};//定义页面实体结构  //定义实体类结构
    	  $scope.findAll=function(){
    		  managementService.findAll().success(
    				function(resp){
    			     $scope.list = resp;
    		  })
    	  }
    	  
    	  $scope.mstatus=['未审核','已审核','审核未通过','关闭'];//会议状态
    	  
    	  $scope.findPage=function(currentPage,pageSize,searchEntity){
    		 managementService.findPage(currentPage,pageSize,searchEntity).success(
      				function(resp){
      			    $scope.list = resp.rows;
      			    $scope.paginationConf.totalItems=resp.total;
      		  })
    	  }
    	  
    	  
    	  //增加商品
    	  $scope.save=function(){
    		  alert($scope.management.mid);
    		 if($scope.management.id!=null){                    //如果有ID
    			 managementService.update($scope.management).success({     //修改
    				 function(resp){
    					 if(resp==true){
    						 alert("修改成功");
    						 $scope.entity={};
       		    		  	 editor.html("");                     //清空富文本编辑器
       		    		  location.href="management.html";             //跳转到商品列表页
    					 }
    					 if(resp!=true) alert("修改失败");
    				 }
    			 });
    		 }else{
    			 managementService.save($scope.management).success(        //增加
    		    	function(resp){
    		    		if(resp.status){
    		    			alert(resp.msg);
    		    			$scope.management={};                       //清空所有绑定entity的值
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
    		managementService.findAll().success(
    				function(response){							
    					for(var i=0;i<response.length;i++){
    						$scope.itemCatList[response[i].id]=response[i].name;
    					}
    				});
    	}
    	
    	$scope.findProAll=function(){
    		managementService.findProAll().success(
    				function(resp){
    					$scope.proList=resp; 
    				}
    		);
    	}
    	
    	//读取二级分类
  	  $scope.$watch('management.proid', function(newValue, oldValue) {          
  	        //根据选择的值，查询二级分类
  		managementService.findByCities(newValue).success(
  	        function(response){
  	        	$scope.citiesList=response; 	    			
  	        });
  	  }); 
    	
    	

  	  $scope.fix=function(){
  		  $scope.fixnum=1;
  		  $scope.movenum=0;
  	  }
  	  
  	  $scope.move=function(){
		  $scope.fixnum=0;
		  $scope.movenum=1;
	  }



        
        
        
    	  
      });