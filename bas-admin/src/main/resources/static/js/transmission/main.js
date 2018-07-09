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
                url: '/api/transmissions?_t=' + new Date().getTime(),
                dataSrc: ''
            },
            columns: [
                      { data:"id", title: "ID", visible: false, searchable: false},// 0
                      { data:"vehicle", title: "VIN No.", visible: true, searchable: true},// 1
                      
                      { data:"arcosTotal", title: "Arcos Total(MB)", visible: true, searchable: true},// 2
                      { data:"edrTotal", title: "EDR Total(MB)", visible: true, searchable: true},// 3
                      
                      { data:"arcosToday", title: "Arcos Today(MB)", visible: true, searchable: true},// 4
                      { data:"edrToday", title: "EDR Today(MB)", visible: true, searchable: true},// 5
                                            
            ],
            columnDefs: [{
            				"render": function ( data, type, row, a, b, c ) {
            					if(!data || !data.vinCode){
									return "";
								}
								return data.vinCode;
							 },
							 "targets": [1]
						},{
							 "render": function ( data, type, row, a, b, c ) {
								if(!data){
									return 0;
								}
								return Math.round(10 * data / (1024 * 1024)) /10;
							 },
							 "targets": [2, 3, 4, 5]
						}     
            ]            
      });
          
      // 处理鼠标点击选中状态
		$('#definition-table tbody').on( 'click', 'tr', function () {
			if ($(this).hasClass('selected') ) {
				$(this).removeClass('selected');
		        return;
		    }
			
			table.$('tr.selected').removeClass('selected');
		    $(this).addClass('selected');
		});

    }
    
    return {
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
            initTable(); 
            
            // 初始化全局模态对话框
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