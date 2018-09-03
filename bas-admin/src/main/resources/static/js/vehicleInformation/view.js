var ViewVehicle = function () {
    //inject a entity
    var inject = function(entity) {
    	var children = $("#form_view").find("p.form-control-static");
    	children.each(function(i, control) {
    		if(entity[control.id] == null){
    			return true;
    		}
			$(control).text(entity[control.id]);
		});
    };

    return {
        //
    	inject: function (entity) {
    		inject(entity); 
        }
    };

}();