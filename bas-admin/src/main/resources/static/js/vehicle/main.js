var DefinitionMain = function () {
	
    var initTable = function () {
        var table = $('#definition-table');

        var fixedHeaderOffset = 0;
        if (App.getViewPort().width < App.getResponsiveBreakpoint('md')) {
            if ($('.page-header').hasClass('page-header-fixed-mobile')) {
                fixedHeaderOffset = $('.page-header').outerHeight(true);
            } 
        } else if ($('.page-header').hasClass('navbar-fixed-top')) {
            fixedHeaderOffset = $('.page-header').outerHeight(true);
        }

        var oTable = table.dataTable({
            fixedHeader: {
                header: true,
                footer: true,
                headerOffset: fixedHeaderOffset
            },

            "order": [
                [1, 'asc']
            ],
            
            "lengthMenu": [
                [5, 10, 15, 30, -1],
                [5, 10, 15, 30, "All"] // change per page values here
            ],
            // set the initial value
            "pageLength": 10,
            ajax : {
                url: '/api/vehicles?_t=' + new Date().getTime(),
                dataSrc: ''
            },
            columns: [
                      { data:"id", title: "ID", visible: false, searchable: false},//0
                      { data:"vinCode", title: "VIN No.", visible: true, searchable: true},//1
                      { data:"vCode", title: "V No.", visible: true, searchable: true},//2

                      { data:"edrMlogSn", title: "EDR Mlog SN", visible: true, searchable: true},//3
                      { data:"edrWifiModuleSn", title: "EDR WIFI Module SN", visible: true, searchable: true},//4
                      { data:"arcosSn", title: "ARCOS SN", visible: true, searchable: true},//5
                      { data:"carOwner", title: "Car owner", visible: true, searchable: true},//6
                      { data:"edrType", title: "EDR type", visible: true, searchable: true},//7
                      
                      
                      { data:"available", title: "Available", visible: true, searchable: true},//3
                      { data:"picName", title: "Picture", visible: false, searchable: true},//4
                      { data:"arcosFilePath", title: "ARCOS File Path", visible: false, searchable: true},//5   
                      { data:"edrFilePath", title: "EDR File Path", visible: false, searchable: true},//6
                      
                      { data:"arcosTotal", title: "ARCOS Status", visible: true, searchable: true},//7   
                      { data:"arcosTotal.today", title: "ARCOS Today(MB)", visible: true, searchable: true},//8
                      { data:"arcosTotal.lastTime", title: "ARCOS LastTime(MB)", visible: false, searchable: true},//9                       
                      { data:"arcosTotal.total", title: "ARCOS Total(MB)", visible: true, searchable: true},//10  
                      { data:"arcosTotal.collectedTime", title: "ARCOS Collected Time", visible: false, searchable: true},//11
                      { data:"arcosTotal.startFileSizeToday", title: "ARCOS Start File Size Today(MB)", visible: false, searchable: true},//12
                      
                      
                      { data:"edrTotal", title: "EDR Status", visible: true, searchable: true},//13   
                      { data:"edrTotal.today", title: "EDR Today(MB)", visible: true, searchable: true},//14  
                      { data:"edrTotal.lastTime", title: "EDR LastTime(MB)", visible: false, searchable: true},//15                       
                      { data:"edrTotal.total", title: "EDR Total(MB)", visible: true, searchable: true},//16      
                      { data:"arcosTotal.collectedTime", title: "ARCOS Collected Time", visible: false, searchable: true},//17
                      { data:"arcosTotal.startFileSizeToday", title: "ARCOS Start File Size Today(MB)", visible: false, searchable: true},//18
                                            
            ],
            columnDefs: [
                         {
                         	"render": function ( data, type, row, a, b, c ) {
                         		if(!data){
                         			return '<span class="label label-sm label-default"> Not Available </span>';
                         		}
                         		
                         		return '<span class="label label-sm label-success"> Available </span>';
                             },
                             "targets": [8]
                           },
                           {
                            	"render": function ( data, type, row, a, b, c ) {
                            		if(!data){
                            			return 0;
                            		}
                            		
                               	return Math.round(10 * data / (1024 * 1024)) /10
                                },
                                "targets": [13, 14, 15, 17, 19, 20, 21, 23]
                              },                           
                           {
                            	"render": function ( data, type, row, a, b, c ) {
                             		if(!!data.isTranserfering){
                             			return '<span class="label label-sm label-warning"> Transerfering </span>';
                             		}
                             		
                             		return '<span class="label label-sm label-success"> Connected </span>'; 
                                },
                                "targets": [12, 18]
                            },
                            {
                                "createdCell": function (td, cellData, rowData, row, col) {
                                	$(td).css('background-color', '#4682B4')
                                },
                                "targets": [1, 12, 13, 18, 19]
                            }
                              
            ]            
      });
          
      //处理鼠标点击选中状态
		$('#definition-table tbody').on( 'click', 'tr', function () {
			if ($(this).hasClass('selected') ) {
				$(this).removeClass('selected');
		        return;
		    }
			
			table.$('tr.selected').removeClass('selected');
		    $(this).addClass('selected');
		});
      //删除数据
	  $('#definition-delete').click(function () {
    	    var entity = $('#definition-table').DataTable().row('.selected').data();
    	    if(!entity){
	    		$("#page-error-modal .error-modal-message").text("No role is selected.");
	    		$("#page-error-modal").modal("show");    	
        	  
	    		return false;
	    	}
    	    $("#to-delete-definition").data("entity", entity);
      });

      //查看用户
      $('#definition-view').click(function () {
    	    var entity = $('#definition-table').DataTable().row('.selected').data();
    	    if(!entity){
	    		$("#page-error-modal .error-modal-message").text("No role is selected.");
	    		$("#page-error-modal").modal("show");    	
        	  
	    		return false;
	    	}
    	    ViewDefinition.inject(entity);
      }); 
    //编辑数据
      $('#definition-edit').click(function () {
            var entity = $('#definition-table').DataTable().row('.selected').data();
            if(!entity){
	    		$("#page-error-modal .error-modal-message").text("No role is selected.");
	    		$("#page-error-modal").modal("show");    	
        	  
	    		return false;
	    	}
            EditDefinition.inject(entity);
      });
    }
    
    return {
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
            initTable(); 
            
            //初始化全局模态对话框
            $("#page-error-modal").modal({show: false}); 
            
            $(".page-header").click(function(){
            	window.location.href = "/";
            });
        }

    };

}();

jQuery(document).ready(function() {
	DefinitionMain.init();
});