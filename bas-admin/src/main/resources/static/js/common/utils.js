var Util = function () {
    var dateFormat = function(theDate, displayDate){
    	if(!theDate){
    		return "N/A";
    	}
    	
    	var result = theDate.getFullYear() + "/" +  (theDate.getMonth() + 1) + "/" + theDate.getDate();
    	if(displayDate){
    		return result;
    	}
    	if(displayDate == false){
    		return doubleDigitFormat(theDate.getHours()) + ":" +  doubleDigitFormat(theDate.getMinutes()) + ":" + doubleDigitFormat(theDate.getSeconds());
    	}
    	
    	
    	return result + " " + doubleDigitFormat(theDate.getHours()) + ":" +  doubleDigitFormat(theDate.getMinutes()) + ":" + doubleDigitFormat(theDate.getSeconds());
    };
    
    var doubleDigitFormat = function(digit){
    	if(digit >= 10){
    		return digit;
    	}
    	
    	return "0" + digit;
    }
    
    var convertMB = function(bytes){
    	bytes = bytes || 0;
    	return Math.round(10 * bytes / (1024 * 1024)) /10
    };
    
    
    return {
    	dateFormat: dateFormat, 
    	convertMB: convertMB
    };

}();