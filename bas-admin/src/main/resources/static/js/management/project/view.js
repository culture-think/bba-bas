﻿var ViewProject = function () {
    //inject a entity
    var inject = function(entity) {
    	var children = $("#form_view").find("p.form-control-static");
    	children.each(function(i, control) {
    		if(entity[control.id] == null){
    			return true;
    		}
			$(control).text(entity[control.id]);
		});
    	$("#picture").attr("src",entity.pictureDocument.url||"");
    };

    return {
        //
    	inject: function (entity) {
    		inject(entity); 
        }
    };

}();