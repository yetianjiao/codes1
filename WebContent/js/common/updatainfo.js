//修改自己密码
function updatePassword() {			
	showProgressDialog();
	$("#SearchForm").attr("action", "UserPersionalPasswordUpdate.action");
	$("#SearchForm").ajaxSubmit({
		beforeSubmit : function () {
			if(jQuery('#SearchForm').validationEngine('validate')==false){
				hideProgressDialog();
				return false;
			}
		},
		success : function(html) {
			var msg = $.trim($(html).find("#messageDiv").text());
	        if (msg && "" != msg) {
	            alert(msg);
	        } else {
	        	$("#workplace").html(html);
				initialTable("#dataTable", "UpdatePersonalPasswordIndex.action");
	        }
		},
		complete : function() {
			hideProgressDialog();
		}
	});
}


//修改用户自己信息
function updateInfo(){
	
	showProgressDialog();
	$("#SearchForm").attr("action", "UpdatePersionalUserInfo.action");
	$("#SearchForm").ajaxSubmit({
		beforeSubmit : function () {
			if(jQuery('#SearchForm').validationEngine('validate')==false){
				hideProgressDialog();
				return false;
			}
		},
		success : function(html) {
			var msg = $.trim($(html).find("#messageDiv").text());
	        if (msg && "" != msg) {
	            alert(msg);
	        } else {
	        	$("#workplace").html(html);
				initialTable("#dataTable", "UpdatePersionalInfoIndex.action");
	        }
		},
		complete : function() {
			hideProgressDialog();
		}
	});
	
}