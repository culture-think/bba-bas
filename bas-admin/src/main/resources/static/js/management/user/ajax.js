var UserAjax = function() {
	var addUser = function(user) {
		var result = {
				success: false
				};
		$.ajax({
			url: "/api/users",
			type: "POST",
			data: JSON.stringify(user),
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
	var deleteUser = function(id) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/users/" + id,
			type: "DELETE",
			async: false
		}).done(function(data){
			result.success = true;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	var getUser = function(id) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/users/" + id,
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
	var updateUser = function(id, user) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/users/" + id,
			type: "PUT",
			data: JSON.stringify(user),
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
		addUser: function(user) {
			var result = addUser(user);
			return result;
		},
		deleteUser: function(id) {
			var result = deleteUser(id);
			return result;
		},
		getUser: function(id) {
			var result = getUser(id);
			return result;
		},
		updateUser: function(id, user) {
			var result = updateUser(id, user);
			return result;
		},
	}
}();
