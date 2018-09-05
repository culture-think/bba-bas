var TopicMain = function() {
	var delId = "";
	var contentData = null;
	$("#leftMenuList").on("click", ".vehicle", function() {
		$(".vehicle").removeClass("topic-selected");
		$(this).addClass("topic-selected");
		var Num = $(this).attr("id").slice(9);
		var workplanId = $("#project" + Num).val();
		initContent(workplanId);
	});
	$("#nve-table-tbody").on("click", "img", function() {
		var url = $(this).attr("src");
		$(".pop-div").show();
		$(".pop-img").html('<img src="' + url + '">');
	});
	$(".pop-div").on("click", "#close-pop", function() {
		$(".pop-img").html("");
		$(".pop-div").hide();
	});
	$("#close-pop").click(function() {
		$(".pop-img").html("");
		$(".pop-div").hide();
	});
	$("#nve-table-tbody").on("click", "video", function() {
		var url = $(this).attr("src");
		$(".pop-div").show();
		$(".pop-img").html('<video src="' + url + '" controls="controls"></video>');
	});
	$("#nve-add").click(function() {
		addNewTr();
	});
	$("#topic-table").on("click", ".save-btn", function() {
		var No = $(this).attr("id").slice(4);
		updateTopic(No);
	});
	$("#topic-table").on("click", ".delete-btn", function() {
		var No = $(this).attr("id").slice(6);
		if ($("#topicId" + No).attr("id")) {
			delId = $("#topicId" + No).val();
		}
		initDeleteData(delId);
	});
	var updateTopic = function(i) {
		var topicId = $("#topicId" + i).val();
		var topic = {
			"id" : topicId,
			"orderNumber" : $("#orderNumber" + i).val(),
			"analyseDepartment" : $("#analyseDepartment" + i).val(),
			"newOrOld" : $("#newOrOld" + i).val(),
			"specialist" : $("#specialist" + i).val(),
			"specialistBi" : $("#specialistBi" + i).val(),
			"pqmAlmNumber" : $("#pqmAlmNumber" + i).val(),
			"atgItNumber" : $("#atgItNumber" + i).val(),
			"remark" : $("#remark" + i).val(),
			"vedios" : [],
		};
		TopicAjax.updateTopic(topicId, topic);
//		initContent();
	};
	initDeleteData = function(delId) {
		TopicAjax.deleteTopic(delId);
		for (var i = 0; i < contentData.length; i++) {
			if (delId == contentData[i].id) {
				contentData.splice(i, 1);
			}
		}
		initTable(contentData);
	}
	var initTable = function(topics) {
		var $item = $('#topic-table');
		var trHtml = '';
		$.each(topics, function(code, topic){
			trHtml +=  '<tr class="nve-table-tr" id="topic'+ code +'">'
						+'<input type="hidden" id="topicId'+ code +'" value="'+ (topic.id || "") +'" /></td>'
						+'<td style="width : 50px;"><input id="orderNumber'+ code +'" type="number" value="'+ (topic.orderNumber || "") +'"></td>'
						+'<td><textarea id="problemDescription'+ code +'" rows="" cols="" disabled="disabled">'+ (topic.problemDescription || "") +'</textarea></td>'
						+'<td style="width : 50px;"><input id="bi'+ code +'" type="number" disabled="disabled" value="'+ (topic.bi || "") +'"></td>'
						+'<td><textarea id="tester'+ code +'" rows="" cols="" disabled="disabled">'+ (topic.tester&&topic.tester.loginName || "") +'</textarea></td>'
						+'<td><textarea id="status'+ code +'" rows="" cols="">'+ (topic.status || "") +'</textarea></td>'
						+'<td><textarea id="analyseDepartment'+ code +'" rows="" cols="">'+ (topic.analyseDepartment || "") +'</textarea></td>'
						+'<td><textarea id="newOrOld'+ code +'" rows="" cols="">'+ (topic.newOrOld || "") +'</textarea></td>'
						+'<td><textarea id="specialist'+ code +'" rows="" cols="">'+ (topic.specialist || "") +'</textarea></td>'
						+'<td><input id="specialistBi'+ code +'" type="number" value="'+ (topic.specialistBi || "") +'"></td>'
						+'<td><textarea id="pqmAlmNumber'+ code +'" rows="" cols="">'+ (topic.pqmAlmNumber || "") +'</textarea></td>'
						+'<td><textarea id="atgItNumber'+ code +'" rows="" cols="">'+ (topic.atgItNumber || "") +'</textarea></td>'
						+'<td><textarea id="remark'+ code +'" rows="" cols="">'+ (topic.remark || "") +'</textarea></td>'
						+'<td><a class="delete-btn" id="delete'+ code +'">DELETE</a>'
						+'<a class="save-btn" id="save'+ code +'">SAVE</a></td><tr/>'
		});
		$("#topic-table").html(trHtml);
		for (var i = 0; i < topics.length; i++) {
			var vedios = topics[i].vedios;
			for(var item in vedios) {
				$("#problemDescriptionDiv" + i).append('<video src="' + (vedios[item].url || "") + '" controls="controls"></video>');
			}
			var pictures = topics[i].pictures;
			for(var item in pictures) {
				$("#problemDescriptionDiv" + i).append('<img src="' + (pictures[item].url || "") + '">');
			}
		}

	}
	var initContent = function(workplanId) {
		var result = TopicAjax.getTopics(workplanId);
		if (!result) {
			return;
		}
		contentData = result;
		initTable(result);
	}
	var addNewTr = function() {
		var code = $("#topic-table .nve-table-tr").length;
		var trHtml = '<tr class="nve-table-tr" id="topic'+ code +'">'
						+'<td style="width : 50px;"><input id="orderNumber'+ code +'" type="number"></td>'
						+'<td><textarea id="problemDescription'+ code +'" rows="" cols="" disabled="disabled"></textarea></td>'
						+'<td style="width : 50px;"><input id="bi'+ code +'" type="number" disabled="disabled"></td>'
//						+'<td><textarea id="comment'+ code +'" rows="" cols="" disabled="disabled"></textarea></td>'
						+'<td><textarea id="testerId'+ code +'" rows="" cols="" disabled="disabled"></textarea></td>'
						+'<td><textarea id="status'+ code +'" rows="" cols=""></textarea></td>'
						+'<td><textarea id="analyseDepartment'+ code +'" rows="" cols=""></textarea></td>'
						+'<td><textarea id="newOrOld'+ code +'" rows="" cols=""></textarea></td>'
						+'<td><textarea id="specialist'+ code +'" rows="" cols=""></textarea></td>'
						+'<td><textarea id="specialistBi'+ code +'" rows="" cols=""></textarea></td>'
						+'<td><textarea id="pqmAlmNumber'+ code +'" rows="" cols=""></textarea></td>'
						+'<td><textarea id="atgItNumber'+ code +'" rows="" cols=""></textarea></td>'
						+'<td><textarea id="remark'+ code +'" rows="" cols=""></textarea></td>'
						+'<td><a class="delete-btn" id="delete'+ code +'">DELETE</a>'
						+'<a class="delete-btn" id="save'+ code +'">SAVE</a></td><tr/>'
		$("#topic-table").append(trHtml);
	}
	return {
//		init : function() {
//		},
		initContent: function(workplanId) {
			initContent(workplanId);
		}

	};

}();

//jQuery(document).ready(function() {
//	TopicMain.init();
//});