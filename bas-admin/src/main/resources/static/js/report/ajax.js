var ReportAjax = function() {
	var getVehicles = function() {
		var result = null;
		$.ajax({
			url: "/api/vehicles?available=true&_t=" + new Date().getTime(),
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
	
	return {
		getVehicles: function() {
			var result = getVehicles();
			return result;
		}
	}
}();
