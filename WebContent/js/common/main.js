function direct(action) {
	location.replace(action);
}
function loginOut() {
	if (confirm("您确定要注销?")) {
		direct('LoginOut');
	}
}

function redirectPage(name) {
	$.ajax(name).done(function(html) {
		$("#workplace").html(html);

		initialTable("#dataTable", name);
	});
}
function redirectPageForArticleAudit(name, class_num) {
	$.ajax(name).done(function(html) {
		$("#workplace").html(html);
		initialTable("#dataTable", name);
		var num = $.trim($(html).find(class_num).text());
		$(".audit_article_num").val(num);

	});
}

/**
 * show progress dialog.it will block the ui.
 */
function showProgressDialog() {
	$('#progressDialogDivId').OpenDiv();
}

/**
 * Hide the progress dialog.
 */
function hideProgressDialog() {
	$('#progressDialogDivId').CloseDiv();
}

/**
 * open notification detail
 * 
 * @param indx
 */
function openModal(indx) {
	jQuery.ajax({
		url : action,
		data : "indx=" + indx,
		type : "POST",
		cache : false,
		beforeSend : function(XMLHttpRequest) {
			showProgressDialog();
		},
		success : function(html) {
			$("#openModal").html(html);
			$("#openModal").dialog({
				title : title,
				width : 800,
				modal : true,
				buttons : {
					"Ok" : function() {
						$(this).dialog("close");
					},
					Cancel : function() {
						$(this).dialog("close");
					}
				}
			});
		},
		error : function(error, state) {
			showErrMsg(error);
		},
		complete : function() {
			hideProgressDialog();
		}
	});

}

function openRejectModal(indx) {

	$("#openRejectModal").dialog({

		title : "驳回原因",
		width : 800,
		modal : true,
		buttons : {
			"Ok" : function() {
				var audit_reason = $("#audit_reason").val();
				$.ajax({
					url : "ArticleRejectMgrEdit.action",
					data : "indx=" + indx + "&audit_reason=" + audit_reason,
					success : function(data) {
						$("#openRejectModal").dialog("close");
						$("#openRejectModal").remove();
						redirectPage("ArticleAuditMgrListSearch.action");

					}
				});
			},
			Cancel : function() {
				$(this).dialog("close");
			}
		}
	});
}

/**
 * 弹出错误提示
 * 
 * @param error
 */
function showErrMsg(error) {
	// hideProgressDialog();
	alert(err_alert + error.responseText);
}

function showPageForm(pageNo) {
	$("#pageNO").val(pageNo);
	var form = $("#pageForm");
	var action = form.attr("action");
	showProgressDialog();
	form.ajaxSubmit({
		type : "POST",
		cache : false,
		beforeSend : function() {
		},
		success : function(html) {
			$("#workplace").html(html);
			initialTable("#dataTable", action);
		},

		complete : function() {
			hideProgressDialog();
		}
	});
}

function saveRight(action) {
	showProgressDialog();
	$("#SearchForm").attr("action", action);
	
	$("#SearchForm").ajaxSubmit({
		type: "post",
		
		success : function(html) {
			var err = $.trim($(html).find(".errorMessage").text());
			if (err && "" != err) {
				alert(err);
			} else {
				var msg = $.trim($(html).find(".actionMessage").text());
				if (msg && "" != msg) {
					alert(msg);
				}
				$("#workplace").html(html);
				initialTable("#dataTable", action);
			}

		},
		complete : function() {
			hideProgressDialog();
		}
	});
}

function search(type) {

	showProgressDialog();
	$("#SearchForm").attr("action", type + "MgrListSearch.action");
	$("#SearchForm").ajaxSubmit({
		success : function(html) {
			$("#workplace").html(html);
			initialTable("#dataTable", type + "MgrListSearch.action");
		},
		complete : function() {
			hideProgressDialog();
		}
	});

}

function add(type) {
	showProgressDialog();
	$("#SearchForm").attr("action", type + "MgrAdd.action");
	if (CKEDITOR.instances.editor1) {
		var content = CKEDITOR.instances.editor1.getData();
		$("#editor1").val(content);
	}
	$("#SearchForm").ajaxSubmit({
		type: "post",
		beforeSubmit : function() {

			if (jQuery('#SearchForm').validationEngine('validate') == false) {
				hideProgressDialog();
				return false;
			}

			return checkCompany();
		},
		success : function(html) {
			var err = $.trim($(html).find(".errorMessage").text());
			if (err && "" != err) {
				alert(err);
			} else {
				var msg = $.trim($(html).find(".actionMessage").text());
				if (msg && "" != msg) {
					alert(msg);
				}
				$("#workplace").html(html);
				initialTable("#dataTable", type + "MgrListSearch.action");
			}

		},
		complete : function() {
			hideProgressDialog();
		}
	});
}

function edit(type) {

	showProgressDialog();
	$("#SearchForm").attr("action", type + "MgrEdit.action");
	if (CKEDITOR.instances.editor1) {
		var content = CKEDITOR.instances.editor1.getData();
		$("#editor1").val(content);
	}

	$("#SearchForm").ajaxSubmit({
		type: "post",
		beforeSubmit : function() {
			if (jQuery('#SearchForm').validationEngine('validate') == false) {
				hideProgressDialog();
				return false;
			}
			return checkCompany();
		},
		success : function(html) {
			var err = $.trim($(html).find(".errorMessage").text());
			if (err && "" != err) {
				alert(err);
			} else {
				var msg = $.trim($(html).find(".actionMessage").text());
				if (msg && "" != msg) {
					alert(msg);
				}
				$("#workplace").html(html);
				initialTable("#dataTable", type + "MgrListSearch.action");
			}
		},
		complete : function() {
			hideProgressDialog();
		}
	});

}

function editIndex(type, indx) {
	$.ajax({
		url : type + "MgrEditIndex.action",
		data : "indx=" + indx
	}).done(function(html) {
		$("#workplace").html(html);
	});
}

function del(type, indx) {
	$.ajax({
		url : type + "MgrDelete.action",
		data : "indx=" + indx
	}).done(function(html) {
		$("#workplace").html(html);
		initialTable("#dataTable", type + "MgrListSearch.action");
	});
}

/*******************************************************************************
 * 通过审核
 * 
 * @param indx
 */
function audit(indx) {
	$.ajax({
		url : "ArticleAuditMgrEdit.action",
		data : "indx=" + indx
	}).done(function(html) {
		$("#workplace").html(html);
		initialTable("#dataTable", "ArticleAuditMgrListSearch.action");
	});

}

/*******************************************************************************
 * 没有通过审核
 * 
 * @param indx
 */
function reject(indx) {
	$.ajax({
		url : "ArticleRejectMgrEdit.action",
		data : "indx=" + indx
	}).done(function(html) {
		$("#workplace").html(html);
		initialTable("#dataTable", "ArticleAuditMgrListSearch.action");
	});

}

function detail(action, title, indx) {
	/*
	 * $.get(action, { data : "indx=" + indx }, function(data, textStatus,
	 * object) { $(object.responseText).dialog({ resizable : true, title :
	 * title, width : 1024, height : 768, modal : true, buttons : { "关闭" :
	 * function() { $(this).dialog("close"); } } }); });
	 */

	$.ajax({
		url : action,
		data : "indx=" + indx,
		success : function(data, textStatus, object) {
			$(object.responseText).dialog({
				resizable : true,
				title : title,
				width : 1024,
				height : 768,
				modal : true

			});

		}

	});

}

function checkCompany() {

	var company_id = $("#company_id").val();
	if ($("#tip") != null) {
		$("#tip").remove();
	}
	if (document.getElementById("span6") != null) {
		if (company_id == "" && $("#span6") != "undefined") {
			var text = "请选择搜索框中的信息";
			var s = document.createElement("span");
			s.id = "tip";
			s.innerHTML = text;
			s.style.color = "red";
			document.getElementById("span6").appendChild(s);
			hideProgressDialog();
			$("#autoCompleteCompany").focus();
			return false;
		}
	}

	return true;
}
