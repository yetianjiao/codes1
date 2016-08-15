function getRemark(target) {
	var eventElement = $(event.srcElement);
	var remark = eventElement.val();
	if (remark != "" && remark != null) {
		var field = eventElement.attr("id");
		$.ajax({
			url : "BaseDataDictionarySearch.action",
			data : "remark=" + remark + "&field=" + field+"&searchBy=code",
			type : "POST",
			dataType : 'json',
			success : function(jsonData) {
				var jsonObject = eval(jsonData);
				var indx = jsonObject.remark;
				var value = jsonObject.text;
				if (value == "null") {
					alert("请输入正确的助记代码");
					eventElement.val("");
				} else {
					eventElement.val(value);
					if (target != null && indx != "null") {
						setAddtional(target, indx);
					}
				}
			},
			error : function(error, state) {
				showErrMsg(error);
			}
		});
	} else {
		if (target != null) {
			$("#" + target).val("");
		}
	}
}
function setAddtional(target, code) {
	$('#' + target).val(code);
}
function initial() {
	$("#dicCategories").accordion({
		heightStyle : "content"
	});
	$("#dicCategories li a").click(function () {
		$(".current").removeClass("current");
		$(this).addClass("current");
	});
}

function show(name) {
	$.ajax(name).done(function(html) {
		$("#dicRecords").html(html);
		initialTable("#dataTable", name);
	});
}

function showPage(name, pageNo) {
	$("#SearchForm").attr("action", name);
	$("#SearchForm").ajaxSubmit({
		data: {"pageNumber" : pageNo},
		success : function(html) {
			$("#dicRecords").html(html);
			initialTable("#dataTable", name);
		}
	});
}

function initialTable(table, name) {
	$(table + " thead th").addClass("ui-state-default tableHead");
	$(table + " thead th[sort]").append("<span class='ui-icon ui-icon-triangle-2-n-s' />");
	$(table + " thead th[sort]").click(function() {
		sortTable(this, name);
	});
	$(table + " tbody tr:odd").addClass("odd");
	$(table + " tbody tr:even").addClass("even");
}

function sortTable(object, name) {
	var parameter;
	if ("desc" != $(object).attr("sort")) {
		parameter = "descRow=" + $(object).attr("id");
		$(object).attr("sort", "desc");
	} else {
		parameter = "ascRow=" + $(object).attr("id");
		$(object).attr("sort", "asc");
	}
	
	//获取keywords
   // var keyword= $("#keyword").val();
   // parameter+="&keyword="+keyword;
    
	parameter += "&pageNumber=1";
	$.ajax({
		url : name,
		data : parameter
	}).done(function(html) {
		$("#dataTable tbody").html($(html).find("#dataTable tbody").html());
		$("#dataTable tbody tr:odd").addClass("odd");
		$("#dataTable tbody tr:even").addClass("even");
		$("#tableStatistics").html($(html).find("#tableStatistics").html());
	});
}

function submitForm() {
	var form = $("#searchForm");
	var action = form.attr("action");
	if ("none" == form.css("display")) {
		form[0].reset();
		form.css("display", "block");
	} else {
		form.ajaxSubmit({
			success : function(html) {
				$("#dicRecords").html(html);
				initialTable("#dataTable", action);
			}
		});
	}
}

function getCompanyName(target) {
	var eventElement = $(event.srcElement);
	var remark = eventElement.val();
	if (remark != "" && remark != null) {
		var field = eventElement.attr("id");
		$.ajax({
			url : "BaseDataDictionarySearch.action",
			data : "remark=" + remark + "&field=company" +"&searchBy=code",
			type : "POST",
			dataType : 'json',
			success : function(jsonData) {
				var jsonObject = eval(jsonData);
				var indx = jsonObject.remark;
				var value = jsonObject.text;
				if (value == "null") {
					alert("请输入正确的助记代码");
					eventElement.val("");
				} else {
					eventElement.val(value);
					if (target != null && indx != "null") {
						setAddtional(target, indx);
					}
				}
			},
			error : function(error, state) {
				showErrMsg(error);
			}
		});
	} else {
		if (target != null) {
			$("#" + target).val("");
		}
	}
}
