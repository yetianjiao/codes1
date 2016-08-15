<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="messageDiv" style="display: none;">
	<s:actionmessage />
	<s:actionerror />
</div>

<form id="SearchForm">
<s:hidden name="student.id"></s:hidden>
	<div class="row-fluid">
		<div class="span12">
			<div class="head clearfix">
				<div class="isw-plus"></div>
				<h1>修改学生</h1>
			</div>

			<div class="block-fluid">
				<div class="row-form clearfix">
					<div class="row-form clearfix">
						<div class="span2">
							学生姓名<font color="red">*</font>
						</div>
						<div class="span4">
							<s:textfield name="student.name" cssClass="validate[required]" />
						</div>
					</div>
					
					<div class="row-form clearfix">
                        <div class="span2">
                                                                                                学号<font color="red">*</font>
                        </div>
                        <div class="span4">
                            <s:textfield name="student.sn" cssClass="validate[required]" />
                        </div>
                    </div>				
					
					<div class="row-form clearfix">
						<div class="span2">性别</div>
                        <div class="span4">
                            <label class="checkbox inline"> <s:radio list="genderList" name="student.gender" listKey="code" listValue="name"></s:radio>
                            </label>
                        </div>
					</div>

					<div class="row-form clearfix">
						<div class="span2">年龄</div>
						<div class="span4">
							<s:textfield name="student.age" />
						</div>
					</div>
					

					<div class="row-form clearfix">
						<div class="span12">
							<button class="btn btn-danger" type="button" onclick="edit('Student')">
								<span class="icon-ok icon-white"></span>&nbsp;&nbsp;提交
							</button>
							<button class="btn btn-warning" type="button" onclick="redirectPage('StudentMgrListSearch.action')">
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
	$(document).ready(function() {
		$("#SearchForm").validationEngine({
			promptPosition : "topLeft",
			scroll : true,
			ajaxSubmit : true
		});
        
	});
</script>
