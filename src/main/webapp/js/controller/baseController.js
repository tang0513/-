app.controller('baseController', function($scope) {

	// 分页控件配置
	$scope.paginationConf = {
		currentPage : 1, // 当前页
		totalItems : 10, // 共有多少条数据
		itemsPerPage : 5, // 每页显示的条数
		perPageOptions : [ 5, 10, 15, 20, 25 ],//
		onChange : function() {
			$scope.reloadList();
		}
	};
	//会议日程列表
	$scope.schePaginationConf = {
		currentPage : 1, // 当前页
		totalItems : 10, // 共有多少条数据
		itemsPerPage : 5, // 每页显示的条数
		perPageOptions : [ 5, 10, 15, 20, 25 ],//
		onChange : function() {
			$scope.scheReloadList();
		}
	};
	
	
	$scope.searchEntity = {};
	
	//重新加载列表
	$scope.reloadList = function() {
		$scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage, $scope.searchEntity);
	};
	//会议日程
	$scope.scheReloadList = function() {
		$scope.findSchePage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage, $scope.searchEntity);
	};
	

	$scope.selectChecked = [];
	$scope.updateSelect = function($event, id) {
		if ($event.target.checked) {
			$scope.selectChecked.push(id);
			console.info("$scope.selectChecked" + $scope.selectChecked);
		} else {
			var index = $scope.selectChecked.indexOf(id);
			$scope.selectChecked.splice(index, 1);
		}
		console.info("$scope.selectChecked" + $scope.selectChecked);
	};
	
	
	//从集合中按照key查询对象
	$scope.searchObjectByKey=function(list,key,keyValue){
		for(var i=0;i<list.length;i++){
			if(list[i][key]==keyValue){
				return list[i];
			}			
		}		
		return null;
	};

	
	

	
});
