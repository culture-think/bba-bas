var Lock = function () {

    return {
        //main function to initiate the module
        init: function () {
        	var currentUser = LockAjax.getCurrentUser().data;
        	
        	$("#userName").text(currentUser.displayName);
        	$("#notThisUser").text("Not "+ currentUser.displayName + "?");
        }

    };

}();

var LockAjax = function() {
	var getCurrentUser = function(leave) {
		var result = {
				success: false
		};
		$.ajax({
			url: "/users/me",
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
		getCurrentUser: function() {
			var result = getCurrentUser();
			return result;
		}
	}
}();

jQuery(document).ready(function() {
    Lock.init();
});