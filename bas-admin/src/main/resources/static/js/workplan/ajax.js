var WorkplanAjax = function() {
	var addWorkPlan = function(workplan) {
		var result = {
				success: false
				};
		$.ajax({
			url: "/api/work-plans",
			type: "POST",
			data: JSON.stringify(workplan),
			async: false,
			dataType: "json",
        	//设置请求头信息
            contentType: 'application/json;charset=utf-8'
		}).done(function(data){
			result.data = data;
			result.success = true;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	var getWorkplans = function(projectId) {
		var result = null;
		$.ajax({
			url: "/api/work-plans?projectId=" + projectId,
			type: "GET",
			dataType: "json",
			async: false
		}).done(function(data){
			result = data;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	var getVehicles = function() {
		var result = null;
		$.ajax({
			url: "/api/vehicles",
			type: "GET",
			dataType: "json",
			async: false
		}).done(function(data){
			result = data;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	var getUsers = function() {
		var result = null;
		$.ajax({
			url: "/api/users",
			type: "GET",
			dataType: "json",
			async: false
		}).done(function(data){
			result = data;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	var updateWorkplan = function(id, workplan) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/work-plans/" + id,
			type: "PUT",
			data: JSON.stringify(workplan),
			async: false,
			//设置请求头信息
            contentType: 'application/json;charset=utf-8'
		}).done(function(data){
			result.success = true;
			result.data = data;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	
	return {
		addWorkPlan: function(workplan) {
			var result = addWorkPlan(workplan);
			return result;
		},
		getWorkplans: function(projectId) {
			var result = getWorkplans(projectId);
			return result;
		},
		getVehicles: function() {
			var result = getVehicles();
			return result;
		},
		getUsers: function() {
			var result = getUsers();
			return result;
		},
		updateWorkplan: function(id, workplan) {
			var result = updateWorkplan(id, workplan);
			return result;
		},
	}
}();
