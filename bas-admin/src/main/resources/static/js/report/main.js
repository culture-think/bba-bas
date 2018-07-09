var ReportMain = function () {
	var vehicles = [];
	var displayDate = false;
	
    var initDate = function () {
    	$("div.date").html(Util.dateFormat(new Date(), true));
    };
    
    var initVehicles = function(){
    	displayDate = !displayDate;
    	var newVehicles = ReportAjax.getVehicles() || [];
    	
    	var same = vehicles.length == newVehicles.length;
    	
    	$.each(vehicles, function(index, vehicle){
    		if(!same){
    			return;
    		}
    		
    		same = newVehicles[index] && vehicle.id == newVehicles[index].id;
    	});
    	
    	vehicles = newVehicles;
    	
    	if(!same){
    		changeAll(vehicles);
    		return;
    	}
    	
    	$.each(vehicles, function(index, vehicle){
    		vehicle.arcosTotal = vehicle.arcosTotal || {isTranserfing : false, collectedTime : null, today : 0};
    		vehicle.edrTotal = vehicle.edrTotal || {isTranserfing : false, collectedTime : null, today : 0};
    		
    		var arcosStatus = vehicle.arcosTotal.isTranserfing ? "Transerfing" : "Collected";
    		var arcosStatusColor = vehicle.arcosTotal.isTranserfing ? "blue" : "green";
    		
    		var edrStatus = vehicle.edrTotal.isTranserfing ? "Transerfing" : "Collected";
    		var edrStatusColor = vehicle.edrTotal.isTranserfing ? "blue" : "green";
    		
    		var arcosCollectedTime = null;
    		if(vehicle.arcosTotal.collectedTime){
    			arcosCollectedTime = new Date();
    			arcosCollectedTime.setTime(vehicle.arcosTotal.collectedTime);
    		}
    		
    		var edrCollectedTime = null;
    		if(vehicle.edrTotal.collectedTime){
    			edrCollectedTime = new Date();
    			edrCollectedTime.setTime(vehicle.edrTotal.collectedTime);
    		}
    		
    		$("#" + vehicle.id + " a").attr("href", vehicle.picName);
    		$("#" + vehicle.id + " img").attr("src", vehicle.picName);
    		$("#" + vehicle.id + " .top").text(vehicle.vinCode);
    		
    		$("#" + vehicle.id + " .desc.left .status").text(arcosStatus);
    		$("#" + vehicle.id + " .desc.left .collected-date").text(Util.dateFormat(arcosCollectedTime, true));
    		$("#" + vehicle.id + " .desc.left .collected-time").text(Util.dateFormat(arcosCollectedTime, false));    		
    		$("#" + vehicle.id + " .desc.left .today").text('Today:' + Util.convertMB(vehicle.arcosTotal.today) + 'MB');
    		
    		$("#" + vehicle.id + " .desc.left .status").removeClass("blue", "green");
    		$("#" + vehicle.id + " .desc.left .status").addClass(arcosStatusColor);
    		

    		$("#" + vehicle.id + " .desc.right .status").text(edrStatus);
    		$("#" + vehicle.id + " .desc.right .collected-date").text(Util.dateFormat(edrCollectedTime, true));
    		$("#" + vehicle.id + " .desc.right .collected-time").text(Util.dateFormat(edrCollectedTime, false));
    		$("#" + vehicle.id + " .desc.right .today").text('Today:' + Util.convertMB(vehicle.edrTotal.today) + 'MB');
    		
    		$("#" + vehicle.id + " .desc.right .status").removeClass("blue", "green");
    		$("#" + vehicle.id + " .desc.right .status").addClass(edrStatusColor);
    		
    	});
    	
    };
    
    var changeAll = function(vehicles) {
    	$("div.responsive").remove();
    	$("p.text_line").remove();
    	
    	$vehicles = $("div.vehicles");
    	var htmlText = "";
    	$.each(vehicles, function(index, vehicle){
    		if(index && index % 7 == 0){
    			htmlText += '<p class="text_line"></p>';
    		}
    		vehicle.arcosTotal = vehicle.arcosTotal || {isTranserfing : false, collectedTime : null, today : 0};
    		vehicle.edrTotal = vehicle.edrTotal || {isTranserfing : false, collectedTime : null, today : 0};
    		
    		var arcosStatus = vehicle.arcosTotal.isTranserfing ? "Transerfing" : "Collected";
    		var arcosStatusColor = vehicle.arcosTotal.isTranserfing ? "blue" : "green";
    		
    		var edrStatus = vehicle.edrTotal.isTranserfing ? "Transerfing" : "Collected";
    		var edrStatusColor = vehicle.edrTotal.isTranserfing ? "blue" : "green";
    		
    		var arcosCollectedTime = null;
    		if(vehicle.arcosTotal.collectedTime){
    			arcosCollectedTime = new Date();
    			arcosCollectedTime.setTime(vehicle.arcosTotal.collectedTime);
    		}
    		
    		var edrCollectedTime = null;
    		if(vehicle.edrTotal.collectedTime){
    			edrCollectedTime = new Date();
    			edrCollectedTime.setTime(vehicle.edrTotal.collectedTime);
    		}
    		
    		htmlText += 	'<div class="responsive" id=' + vehicle.id + '>'
    			           +'    <div class="img">'
    			           +'        <a target="_blank" href="' + vehicle.picName + '">'
    			           +'            <img src="' + vehicle.picName + '" width="300" height="200">'
    			           +'        </a>'
    			           +'        <div>'
    			           +'            <div class="top">' + vehicle.vinCode + '</div>'
    			           +'            <div class="desc left">Arcos'
    			           +'                <p class="status ' + arcosStatusColor + '">' + arcosStatus + '</p>'
    			           +'                <p class="collected-date">' + Util.dateFormat(arcosCollectedTime, true) + '</p>'
    			           +'                <p class="collected-time">' + Util.dateFormat(arcosCollectedTime, false) + '</p>'    			           
    			           +'                <p class="today">Today:' + Util.convertMB(vehicle.arcosTotal.today) + 'MB</p>'
    			           +'            </div>'
    			           +'            <div class="desc right">EDR'
    			           +'                <p class="status ' + edrStatusColor + '">' + edrStatus + '</p>'
    			           +'                <p class="collected-date">' + Util.dateFormat(edrCollectedTime, true) + '</p>'
    			           +'                <p class="collected-time">' + Util.dateFormat(edrCollectedTime, false) + '</p>'    			           
    			           +'                <p class="today">Today:' + Util.convertMB(vehicle.edrTotal.today) + 'MB</p>'
    			           +'            </div>' 
    			           +'        </div>'
    			           +'    </div>'					    
    			           +'</div>';
    	});
    	$vehicles.append(htmlText);    	
    };
    
    return {
        init: function () {
        	//初始化日期
        	initDate(); 
        	
            //初始化车辆信息列表
        	initVehicles();
        	
            $(".header").click(function(){
            	window.location.href = "/";
            });
        }

    };

}();

jQuery(document).ready(function() {
	ReportMain.init();
	
	setInterval(function(){
		ReportMain.init();
	}, 5 * 1000)
});