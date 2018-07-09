ViewDefinition = function () {
    // inject a entity
    var inject = function(entity) {
    	var children = $("#form_definition-view").find("p.form-control-static");
    	children.each(function(i, control) {
    		if(entity[control.id] == null){
    			return true;
    		}
			$(control).text(entity[control.id]);
		});
    	
    	
    	var arcosStatus = "Transerfering"
    	if(!entity.arcosTotal.isTranserfering){
    		arcosStatus = "Collected";
    	}
    	
    	if(entity.arcosTotal.collectedTime){
    		var collectedTime = new Date(entity.arcosTotal.collectedTime);
    		arcosStatus = arcosStatus + "(" + Util.dateFormat(collectedTime) + ")";
    	}
    	$("#form_definition-view #arcosStatus").text(arcosStatus);
    	
    	var arcosData = Util.convertMB(entity.arcosTotal.total) + "MB";
    	arcosData = arcosData + " : " + Util.convertMB(entity.arcosTotal.today) + "MB";
    	arcosData = arcosData + " : " + Util.convertMB(entity.arcosTotal.lastTime) + "MB";
    	arcosData = arcosData + " : " + Util.convertMB(entity.arcosTotal.startFileSizeToday) + "MB";
    	$("#form_definition-view #arcosData").text(arcosData);
    	
    	var edrStatus = "Transerfering"
    	if(!entity.edrTotal.isTranserfering){
    		edrStatus = "Collected";
    	}
    	
    	if(entity.edrTotal.collectedTime){
    		var collectedTime = new Date(entity.arcosTotal.collectedTime);
    		edrStatus = edrStatus + "(" + Util.dateFormat(collectedTime) + ")";
    	}
    	$("#form_definition-view #edrStatus").text(edrStatus);
    	
    	var edrData = Util.convertMB(entity.edrTotal.total) + "MB";
    	edrData = edrData + " : " + Util.convertMB(entity.edrTotal.today) + "MB";
    	edrData = edrData + " : " + Util.convertMB(entity.edrTotal.lastTime) + "MB";
    	edrData = edrData + " : " + Util.convertMB(entity.edrTotal.startFileSizeToday) + "MB";
    	$("#form_definition-view #edrData").text(edrData);    	
    };
    
    // 清空数据
    var empty = function() {
    	var children = $("#form_definition-view").find("p.form-control-static");
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