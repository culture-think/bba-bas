var DefinitionAjax = function() {
	var getModules = function() {
		var result = null;
		$.ajax({
			url: "/api/modules?type=2",
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
	var addDefinition = function(definition) {
		var result = {
				success: false
				};
		$.ajax({
			url: "/api/modules",
			type: "POST",
			data: JSON.stringify(definition),
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
	var deleteDefinition = function(id) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/modules/" + id,
			type: "DELETE",
			async: false
		}).done(function(data){
			result.success = true;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	var getDefinition = function(id) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/modules/" + id,
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
	var updateDefinition = function(id, definition) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/modules/" + id,
			type: "PUT",
			data: JSON.stringify(definition),
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
		getModules: function() {
			var result = getModules();
			return result;
		},
		addDefinition: function(definition) {
			var result = addDefinition(definition);
			return result;
		},
		deleteDefinition: function(id) {
			var result = deleteDefinition(id);
			return result;
		},
		getDefinition: function(id) {
			var result = getDefinition(id);
			return result;
		},
		updateDefinition: function(id, definition) {
			var result = updateDefinition(id, definition);
			return result;
		}
	}
}();
