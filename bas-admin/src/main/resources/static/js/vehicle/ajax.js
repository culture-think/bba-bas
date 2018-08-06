var VehicleAjax = function() {
	var addVehicle = function(entity) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/vehicles",
			type: "POST",
			data: JSON.stringify(entity),
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
	var deleteVehicle = function(id) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/vehicles/" + id,
			type: "DELETE",
			async: false
		}).done(function(data){
			result.success = true;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	var getVehicle = function(id) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/vehicles/" + id + "?_t=" + new Date().getTime(),
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
	var updateVehicle = function(id, entity) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/vehicles/" + id,
			type: "PUT",
			data: JSON.stringify(entity),
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
		addVehicle: function(entity) {
			var result = addVehicle(entity);
			return result;
		},
		deleteVehicle: function(id) {
			var result = deleteVehicle(id);
			return result;
		},
		getVehicle: function(id) {
			var result = getVehicle(id);
			return result;
		},
		updateVehicle: function(id, entity) {
			var result = updateVehicle(id, entity);
			return result;
		}
	}
}();
