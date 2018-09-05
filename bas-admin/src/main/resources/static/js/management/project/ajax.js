var ProjectAjax = function() {
	var addProject = function(project) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/projects",
			type: "POST",
			data: JSON.stringify(project),
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
	var deleteProject = function(id) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/projects/" + id,
			type: "DELETE",
			async: false
		}).done(function(data){
			result.success = true;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	var getProject = function(id) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/projects/" + id,
			type: "GET",
			dataType: "json",
			async: false
		}).done(function(data){
			result.success = true;
			result.data = data;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	var updateProject = function(id, project) {
		var result = null;
		$.ajax({
			url: "/api/projects/" + id,
			type: "PUT",
			data: JSON.stringify(project),
			async: false,
			//设置请求头信息
            contentType: 'application/json;charset=utf-8'
		}).done(function(data){
			result = data;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	
	return {
		addProject: function(project) {
			var result = addProject(project);
			return result;
		},
		deleteProject: function(id) {
			var result = deleteProject(id);
			return result;
		},
		getProject: function(id) {
			var result = getProject(id);
			return result;
		},
		updateProject: function(id, project) {
			var result = updateProject(id, project);
			return result;
		},
	}
}();
