<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type='text/javascript' src='js/common/updatainfo.js'></script>

<div id="messageDiv" style="display: none;">
	<s:actionmessage />
	<s:actionerror />
</div>

<form id="SearchForm">
	<div class="row-fluid">
		<div class="span12">
			<div class="head clearfix">
				<div class="isw-edit"></div>
				<h1>修改密码</h1>
			</div>

			<div class="block-fluid">

				<div class="row-form clearfix">
					<div class="row-form clearfix">
						<div class="span2">
							旧密码<font color="red">*</font>
						</div>
						<div class="span4">
							<s:password name="password" cssClass="validate[required]" />
						</div>
					</div>
					<div class="row-form clearfix">
						<div class="span2">
							新密码<font color="red">*</font>
						</div>
						<div class="span4">
							<s:password id="pw" name="password_new" cssClass="validate[required]" />
						</div>
					</div>
					<div class="row-form clearfix">
						<div class="span2">
							确认密码<font color="red">*</font>
						</div>
						<div class="span4">
							<s:password name="password_confirm" cssClass="validate[equals[pw],required]" />
						</div>
					</div>
					<div class="row-form clearfix">
						<div class="span12">
							<button class="btn btn-success" type="button" onclick="updatePassword()">
								<span class="icon-ok icon-white"></span>&nbsp;&nbsp;修改
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>

<script type="text/javascript">
	$(document).ready(function() {
		$("#SearchForm").validationEngine({
			promptPosition : "topLeft",
			scroll : true,
			ajaxSubmit : true
		});
	});
</script>
