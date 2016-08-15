<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="messageDiv" style="display: none;">
	<s:actionmessage />
	<s:actionerror />
</div>

<form id="SearchForm">
	<s:textfield style="display:none" name="user.id"></s:textfield>
	<div class="row-fluid">
		<div class="span12">
			<div class="head clearfix">
				<div class="isw-plus"></div>
				<h1>编辑用户</h1>
			</div>

			<div class="block-fluid">
				<div class="row-form clearfix">
					<div class="row-form clearfix">
						<div class="span1">
							用户名<font color="red">*</font>
						</div>
						<div class="span4">
							<s:textfield name="user.username" cssClass="validate[required]" />
						</div>
						<div class="span1">昵称</div>
						<div class="span4">
							<s:textfield name="user.nickname" />
						</div>

					</div>

					<div class="row-form clearfix">
						<div class="span1">
							角色<font color="red">*</font>
						</div>
						<div class="span4">
							<s:select list="roleList" name="user.role_id" listKey="id"
								listValue="name" cssClass="validate[required]"></s:select>
						</div>
						<div class="span1">
							帐户状态<font color="red">*</font>
						</div>
						<div class="span4">
							<s:select list="userStatusList" name="user.user_state"
								listKey="code" listValue="name" cssClass="validate[required]"></s:select>
						</div>
					</div>

					<div class="row-form clearfix">
						<div class="span1">性别</div>
						<div class="span4">
							<label class="checkbox inline"> <s:radio list="sexList"
									name="user.gender" listKey="code" listValue="name"></s:radio>
							</label>
						</div>
						<div class="span1">生日</div>
						<div class="span4">
							<s:textfield name="user.birthday" onclick="new Calendar().show(this);" readonly="true">
                                <s:param name="value">
                                    <s:date name="user.birthday" format="yyyy-MM-dd" />
                                </s:param>
                            </s:textfield>
						</div>
					</div>

					<div class="row-form clearfix">
						<div class="span1">座机</div>
						<div class="span4">
							<s:textfield name="user.telephone"
								cssClass="validate[custom[phone]]" />
						</div>
						<div class="span1">手机</div>
						<div class="span4">
							<s:textfield name="user.mobile"
								cssClass="validate[custom[phone]]" />
						</div>

					</div>

					<div class="row-form clearfix">
						<div class="span1">电子邮箱</div>
						<div class="span4">
							<s:textfield name="user.email" cssClass="validate[custom[email]]" />
						</div>
						<div class="span1">QQ</div>
						<div class="span4">
							<s:textfield name="user.qq" cssClass="validate[custom[number]]" />
						</div>
					</div>

					<div class="row-form clearfix">
						<div class="span1">住址</div>
						<div class="span4">
							<s:textfield name="user.address" />
						</div>
						<div class="span1">邮政编码</div>
						<div class="span4">
							<s:textfield name="user.post_code"
								cssClass="validate[custom[post_code]]" />
						</div>
					</div>

					<div class="row-form clearfix">
						<div class="span1">头像</div>
						<div class="span1">
							<div id="uploadPreview"></div>
						</div>
						<div class="span5">
							<input type="file" id="uploadImage" name="file" />
						</div>
					</div>

					<div class="row-form clearfix">
						<div class="span12">
							<button class="btn btn-danger" type="button"
								onclick="edit('User')">
								<span class="icon-pencil icon-white"></span>&nbsp;&nbsp;修改
							</button>
							<button class="btn btn-warning" type="button"
								onclick="redirectPage('UserMgrListSearch.action')">
								<span class="icon-minus icon-white"></span>&nbsp;&nbsp;取消
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("#SearchForm").validationEngine({
					promptPosition : "topLeft",
					scroll : true,
					ajaxSubmit : true
				});

				$("#uploadImage").on(
						"change",
						function() {
							// Get a reference to the fileList
							var files = !!this.files ? this.files : [];
							// If no files were selected, or no FileReader support, return
							if (!files.length || !window.FileReader) {
								return;
							}

							// Only proceed if the selected file is an image
							if (/^image/.test(files[0].type)) {
								// Create a new instance of the FileReader
								var reader = new FileReader();
								// Read the local file as a DataURL
								reader.readAsDataURL(files[0]);
								// When loaded, set image data as background of div
								reader.onloadend = function() {

									$("#uploadPreview").css("background-image",
											"url(" + this.result + ")");
								};

							}

						});

			});
</script>
