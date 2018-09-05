var TopicAjax = function() {
	var getTopics = function(workPlanId) {
		var result = null;
		$.ajax({
			url: "/api/topics?workPlanId=" + workPlanId,
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
	var updateTopic = function(topicId, topic) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/topics/"+topicId,
			type: "PUT",
			data: JSON.stringify(topic),
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
	var deleteTopic = function(topicId) {
		var result = null;
		$.ajax({
			url: "/api/topics/"+topicId,
			type: "DELETE",
			dataType: "json",
			async: false
		}).done(function(data){
			result = data;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	}
	var getProjects = function() {
		var result = {
				success: false
		};
		$.ajax({
			url: "/api/work-plans",
			type: "GET",
			async: false,
			dataType: "json"
		}).done(function(data){
			result.data = data;
			result.success = true;
		}).fail(function(data){
			console.log(data);
		});
		return result;
	};
	return {
		getTopics: function(workPlanId) {
			var result = getTopics(workPlanId);
			return result;
		},
		updateTopic: function(topicId, topic) {
			var result = updateTopic(topicId, topic);
			return result;
		},
		deleteTopic: function(topicId) {
			var result = deleteTopic(topicId);
			return result;
		},
		getProjects: function() {
			var result = getProjects();
			return result;
		}
	}
}();
