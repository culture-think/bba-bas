var ViewUser = function () {
    //inject a entity
    var inject = function(entity) {
    	var children = $("#form_view").find("p.form-control-static");
    	children.each(function(i, control) {
    		if(entity[control.id] == null){
    			return true;
    		}
    		if (control.id == "type") {
    			if(!entity[control.id]) {
    				$(control).text();
    				return;
    			}
    			var content = entity[control.id] == 1 ? "Admin":"Normal User";
    			$(control).text(content);
    			return;
    		}
			$(control).text(entity[control.id]);
		});
    };
    
    //清空数据
    var empty = function() {
    	var children = $("#form_project-view").find("p.form-control-static");
    	children.each(function(i, control) {
			$(control).text(null);
		});
    };

    return {
        //
    	inject: function (entity) {
    		inject(entity); 
        },
        empty: function () {
        	empty(); 
        }
        
    };

}();