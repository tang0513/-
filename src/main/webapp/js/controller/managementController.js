  app.controller('managementController',function($scope,$controller,$location,managementService,uploadService,$http){
    	 $controller('baseController',{$scope:$scope});
    	 $scope.entity={management:{}};//定义页面实体结构  //定义实体类结构
    	 $scope.management={};
    	  $scope.findAll=function(){
    		  managementService.findAll().success(
    				function(resp){
    			     $scope.list = resp;
    		  })
    	  }
    	  
    	  $scope.status=['未开始','进行中','已结束'];
    	  
    	  $scope.findPage=function(currentPage,pageSize,searchEntity){
    		 managementService.findPage(currentPage,pageSize,searchEntity).success(
      				function(resp){
      			    $scope.list = resp.rows;
      			    $scope.paginationConf.totalItems=resp.total;
      		  })
    	  }
    	  $scope.uploadFile=function(){
    		  uploadService.uploadFile().success(
    				  function(resp){
    			
    					  $scope.management.url=resp.data;
    					  console.info($scope.management.url);
    				  }
    		  );
    	  };
    	  
    	  //增加商品
    	  $scope.save=function(){
    		 if($scope.management.id!=null){                    //如果有ID
    			 managementService.update($scope.management).success({     //修改
    				 function(resp){
    					 if(resp.status){
    						 alert(resp.msg);
    						 $scope.management={};
       		    		  	 editor.html("");                     //清空富文本编辑器
       		    		  	 location.href="management.html";             //跳转到商品列表页
    					 }else{
    						 alert(resp.msg);
    					 }
    				 }
    			 });
    		 }else{
    			 if($scope.management.firstNum!=null){
    				 $scope.management.mphone=$scope.management.firstNum+$scope.management.SecondNum;
    			 }
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
  	  
  	//查询实体 
  	$scope.findOne=function(){
  		var id= $location.search()['id'];//获取参数值
  		if(id==null){
  			return ;
  		}
  		managementService.findOne(id).success(
  			function(response){
  				$scope.management = response;
  				//显示图片列表
  				$scope.management.url=JSON.parse($scope.management.url);
  			});	
  		
  		
  	}
  	
  	//单删
  	$scope.delOne = function(id){
  		managementService.delOne(id).success(
  				function(response){
  					if(response.status){
  						alert(response.msg);
  						$scope.reloadList();
  					}else{
  						alert(response.msg);
  					}
  				}
  		);
  	}
  	
  	
  	//批删
  	$scope.del=function(){
  		managementService.del($scope.selectChecked).success(
		     function(resp){
		    	 if(resp.status){
		    		 alert(resp.msg);
  				   	 $scope.reloadList();
      			 }else{
      				alert(resp.msg);
      			 }
		     }
		  )
	  };



        
        
        
    	  
      });