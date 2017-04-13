myApp.controller('homeController', function($scope,$uibModal, $state, taskService,$timeout){
	$scope.todoDisplay= false;
	$scope.result = []; // Http call Then server kal ka data
	 $scope.isList = false;
	 this.refresh=function(){
		 $state.reload();
	 }
	 $scope.load_modal_sms = function (data) {
	        var modal = $uibModal.open({
	          templateUrl: "template/popup.html",
	          ariaLabelledBy: 'modal-title-bottom',
	          ariaDescribedBy: 'modal-body-bottom',
	          size: 'sm',
	          controller:function($uibModalInstance){
	        	  this.title=data.title;
	        	  this.id = data.id;
	        	  var $ctrl = this;
	        	  this.description = data.description;
	      	       this.cancel = function () {
	          	  console.log('called')
	          	    $uibModalInstanceProvider.dismiss('cancel');
	          	  };
	        	  this.ok = function () {
	        		    $uibModalInstance.close({title:$ctrl.title,description:$ctrl.description,id:$ctrl.id});
	        	  };

	        	  this.cancel = function () {
	        		    $uibModalInstance.dismiss('cancel');
	        	};
	        	  
	          },
	          controllerAs:"$ctrl"
//	          scope: data
	        });
	        modal.result.catch(function(error){
	        	console.log("error::",error);   	
	        }).then(function(data)
	        		{$state.reload();
	        	if(data)
	        		{
	        		console.log("data::",data);	
	        		}
	        	 	
	        		})
	        
	    };

	this.signout=function(){
		console.log('signout');
		var httpobj=taskService.signoutUser().then(function(data){
			if(data.data.status==1){
				console.log(data.data.message);
				$state.go("login");
			}
		})
	}
	
	
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
	this.updateEnable=function(index){
		$scope.result=$scope.result.map(function(ret){
			ret.update=false
			return ret;
		}); // Reset To all update
		
		$scope.result[index].update=true; // set only one field
	}
	this.updateTask=function(index , id){
		
		$scope.result[index].update=true;
		$scope.todoDisplay= false;
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
// console.log(todos);signoutUser
// if( todos )
// {
// for(var i=0; i<todos.length; i++ )
// {
// $scope.result.push(todos[i]);
//					 
// console.log(todos[i]);
// }
// }
		}
		else{
			$state.go("login");
		}
		jqueryFunction();
	}).catch(function(){});
	
	this.save = function(){
		 var httpObj = taskService.createTask($scope.todo).then(function(data){
			 if(data.data.status==1)
			 {
				 delete $scope.todo;
				 $scope.result.push( data.data.doTask );
				 $scope.todoDisplay= fasignoutUserlse;
					console.log(data);
					if(data.data.status == 1)
					{
						$scope.result = data.data.list;
// console.log(todos);signoutUser
// if( todos )
// {
// for(var i=0; i<todos.length; i++ )
// {
// $scope.result.push(todos[i]);
//								 
// console.log(todos[i]);
// }
// }
					}
					else{/* When the user clicks on the button, 
						toggle between hiding and showing the dropdown content */
						function myFunction() {
						    document.getElementById("myDropdown").classList.toggle("show");
						}

						// Close the dropdown if the user clicks outside of it
						window.onclick = function(event) {
						  if (!event.target.matches('.dropbtn')) {

						    var dropdowns = document.getElementsByClassName("dropdown-content");
						    var i;
						    for (i = 0; i < dropdowns.length; i++) {
						      var openDropdown = dropdowns[i];
						      if (openDropdown.classList.contains('show')) {
						        openDropdown.classList.remove('show');
						      }
						    }
						  }
						}
						$state.go("login");
					}
					jqueryFunction();
				
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
	/*this.doshow = function(){
		$scope.todoDisplay= true;
	}
	this.dohide = function(){
		$scope.todoDisplay= false;
	}*/
});


myApp.service('taskService',function($http){
	this.createTask = function(todo){ 
		return $http({
			url:"http://localhost:8080/toDoApp_2017/createtask",method:"post",data:todo});
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
	
	this.signoutUser=function(){
		return $http({url:"http://localhost:8080/toDoApp_2017/signout"});
	}
});
function jqueryFunction(){
	/*
	 * $('#products').mouseenter(function() { $('#products')
	 * $('#ButtonChange').show(); }).mouseout(function() {
	 * $('#ButtonChange').hide(); })
	 */
}

/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}