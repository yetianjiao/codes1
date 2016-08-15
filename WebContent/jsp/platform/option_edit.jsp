<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<form id="SearchForm">
	<div class="row-fluid">
		<div class="span12">
			<div class="head clearfix">
				<div class="isw-edit"></div>
				<h1>编辑选项</h1>
			</div>
			
			<div class="block-fluid">
			
				<s:textfield name="systemOption.id" style="display:none" />
				
				<div class="row-form clearfix">
					<div class="row-form clearfix">
						<div class="span2">
							所属系统分类<font color="red">*</font>
						</div>
						<div class="span4">
							<s:select list="fieldList" name="systemOption.system_field_id" listKey="id" listValue="name" disabled="true"></s:select>
						</div>
					</div>
					
					<div class="row-form clearfix">
						<div class="span2">
							代码<font color="red">*</font>
						</div>
						<div class="span4">
							<s:textfield name="systemOption.code" cssClass="validate[required]" />
						</div>
					</div>
					
					<div class="row-form clearfix">
						<div class="span2">
							名称<font color="red">*</font>
						</div>
						<div class="span4">
							<s:textfield name="systemOption.name" cssClass="validate[required]" />
						</div>
					</div>
					
					<div class="row-form clearfix">
						<div class="span2">排序</div>
						<div class="span4">
							<s:textfield name="systemOption.order_no" cssClass="validate[custom[number]]" />
						</div>
					</div>
					
					<div class="row-form clearfix">
						<div class="span2">备注</div>
						<div class="span4">
							<s:textarea name="systemOption.remark"></s:textarea>
						</div>
					</div>

					<div class="row-form clearfix">
						<div class="span6">
							<button class="btn btn-danger" type="button" onclick="edit('Option')">
								<span class="icon-ok icon-white"></span>&nbsp;&nbsp;提交
							</button>
							<button class="btn btn-warning" type="button" onclick="redirectPage('DictionaryMgrListSearch.action')">
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

