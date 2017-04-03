myApp.controller('homeController', function($scope, $state, taskService,$timeout){
	$scope.todoDisplay= false;
	$scope.result = []; //Http call Then server kal ka data
	
	this.deleteTask=function(id){
		console.log(id);
		var httpObj=taskService.deleteTodo(id).then(function(data){
			console.log(data);
			if(data.data.status==1){
				console.log(data.data.message);
				$state.reload();
				
			}
		})
		
	};
	this.updateTask=function(index , id){
		$scope.result[index].update=true;
		console.log(index);
		console.log($scope.i);
		console.log(id);
		var obj = $scope.result[index];
		console.log(obj);
		var httpobj = taskService.updateToDo(id, obj).then(function(data){
			console.log(data);
			if(data.data.status==1){
				console.log(data.data.message);
				$state.reload();
			}
		})
	}

	
	taskService.getAllTask().then(function(data){
		console.log(data);
		if(data.data.status == 1)
		{
			$scope.result = data.data.list;
//			 console.log(todos);
//			 if( todos )
//			 {
//				 for(var i=0; i<todos.length; i++ )
//				 {
//					 $scope.result.push(todos[i]);
//					 
//					 console.log(todos[i]);
//				 }
//			 }
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
	
	this.deleteTodo=function(id){
		return $http({url:"http://localhost:8080/toDoApp_2017/delete/"+id, method:"post"});
	}
	
	this.updateToDo=function(id, todo){
		return $http({url:"http://localhost:8080/toDoApp_2017/update/"+id, method:"post",data:todo});
	}
});
