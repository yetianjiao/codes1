<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type='text/javascript' src='js/common/updatainfo.js'></script>

<form id="SearchForm">
	<div class="row-fluid">
		<div class="span12">
			<div class="head clearfix">
				<div class="isw-edit"></div>
				<h1>修改个人信息</h1>
			</div>

			<div class="block-fluid">
				<div class="row-form clearfix">
					<div class="row-form clearfix">
					    <div class="span2">用户名</div>
                        <div class="span4">
                            <s:text name="user.username" />
                        </div>
                        
						<div class="span2">昵称</div>
						<div class="span4">
							<s:textfield name="user.nickname" />
						</div>
						
					</div>
					<div class="row-form clearfix">
                        <div class="span2">角色</div>
                        <div class="span4">
                            <s:if test="user.role_name!=null">
                                <s:text name="user.role_name"></s:text>
                            </s:if>
                            <s:else>
                                <span>无</span>
                            </s:else>
                        </div>

                        <div class="span2">帐户状态</div>
                        <div class="span4">
                            <s:if test="user.user_state_name!=null">
                                <s:text name="user.user_state_name"></s:text>
                            </s:if>
                            <s:else>
                                <span>无</span>
                            </s:else>
                        </div>
                    </div>
					

					<div class="row-form clearfix">
					    <div class="span2">性别</div>
                        <div class="span4">
                            <label class="checkbox inline"> <s:radio list="sexList" name="user.gender" listKey="code" listValue="name"></s:radio>
                            </label>
                        </div>
                       
						<div class="span2">生日</div>
						<div class="span4">
							<s:textfield name="user.birthday" onclick="new Calendar().show(this);" readonly="true">
								<s:param name="value">
									<s:date name="user.birthday" format="yyyy-MM-dd" />
								</s:param>
							</s:textfield>
						</div>
						
					</div>

					<div class="row-form clearfix">
						
						<div class="span2">座机</div>
                        <div class="span4">
                            <s:textfield name="user.telephone" cssClass="validate[custom[phone]]" />
                        </div>
						<div class="span2">手机</div>
						<div class="span4">
							<s:textfield name="user.mobile" cssClass="validate[custom[phone]]" />
						</div>
					</div>

					<div class="row-form clearfix">
						<div class="span2">电子邮箱</div>
                        <div class="span4">
                            <s:textfield name="user.email" cssClass="validate[custom[email]]" />
                        </div>
						<div class="span2">QQ</div>
						<div class="span4">
							<s:textfield name="user.qq" cssClass="validate[custom[number]]" />
						</div>
					</div>

					<div class="row-form clearfix">
						<div class="span2">住址</div>
						<div class="span4">
							<s:textfield name="user.address" />
						</div>
						<div class="span2">邮政编码</div>
						<div class="span4">
							<s:textfield name="user.post_code" cssClass="validate[custom[post_code]" />
						</div>
					</div>
                    
                    <div class="row-form clearfix">
                        <div class="span2">LOGO图片</div>
                        <div class="span1">
                            <div id="uploadPreview"></div>
                        </div>
                        <div class="span5">
                            <input type="file" id="uploadImage" name="file" />
                        </div>
                    </div>
					
					<div class="row-form clearfix">
						<div class="span12">
							<button class="btn btn-success" type="button" onclick="updateInfo()">
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
