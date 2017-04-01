myApp.controller('homeController', function($scope, $state, taskService,$timeout){
	$scope.todoDisplay= false;
	$scope.result = []; //Http call Then server kal ka data
	
	taskService.getAllTask().then(function(data){
		console.log(data);
		if(data.data.status == 1)
		{
			 var todos = data.data.list;
			 console.log(todos);
			 if( todos )
			 {
				 for(var i=0; i<todos.length; i++ )
				 {
					 $scope.result.push(todos[i]);
					 
					 console.log(todos[i]);
				 }
			 }
		}
		else{
			 // Not action Remain in same page or error page
		}
	}).catch(function(){});
	
	this.save = function(){
		 var httpObj = taskService.createTask($scope.todo).then(function(data){
			 if(data.data.status==1)
			 {
				 console.log(data.data.doTask);
				 $scope.result.push( data.data.doTask );
				 
				 $scope.todoDisplay= false;
				 	//
			 }else{
					 // Not action Remain in same page or error page
			 }
			// console.log($scope.result);
		 }).catch(function(){});
	}
	this.ShowHide = function(){
		$scope.todoDisplay= true;
	}
	
});

myApp.service('taskService',function($http){
	this.createTask = function(todo){ 
		return $http({
			url:"http://localhost:8080/toDoApp_2017/createtask",
			method:"post",
			data:todo
		});
	}
	
	this.getAllTask = function(todo){ 
		return $http({url:"http://localhost:8080/toDoApp_2017/todoList"});
	}
	
});
