<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="css/zTreeStyle/dataTree.css" type="text/css">
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="js/psp/product_tree.js"></script>

 <div class="row-fluid" id="optionHead">

	<div class="span9" id="span9">
		<div class="head clearfix">
			<div class="isw-list"></div>
			<h1>选项列表</h1>

			<s:if test="allow_edit==1">
				<ul class="buttons">
					<li><button class="btn btn-warning" type="button" onclick="redirectPage('OptionMgrAddIndex.action?field_id=<s:property value="field_id" />&field_name=<s:property value="field_name" />')">
							<span class="icon-plus icon-white"></span>&nbsp;新增&nbsp;
						</button>&nbsp;</li>
				</ul>
			</s:if>

		</div>

		<div class="block-fluid table-sorting clearfix">
			<table cellpadding="0" cellspacing="0" width="100%" class="table" id="dataTable">
				<thead>
					<tr>
						<th width="40px">序号</th>
						<th id="base_system_field.name" sort="" clsss="sorting" role="columnheader">所属分类</th>
						<th id="base_system_option.code" sort="" clsss="sorting" role="columnheader">代码</th>
						<th id="base_system_option.name" sort="" clsss="sorting" role="columnheader">名称</th>
						<th id="base_system_option.remark" sort="" clsss="sorting" role="columnheader">备注</th>
						<th width="120px">操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="optionList" status="status">
						<tr>
							<td><s:property value="rowNumberStart + #status.index + 1" /></td>
							<td><s:property value="system_field_name" /></td>
							<td><s:property value="code" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="remark" /></td>
							<td><s:if test="allow_edit==1">
									<span><button class="btn btn-mini btn-primary" type="button" onclick="editIndex('Option','<s:property value="id" />')">
											<span class="icon-pencil icon-white"></span>&nbsp;编辑&nbsp;
										</button></span>
									<span><button class="btn btn-mini btn-danger" type="button" onclick="del('Option','<s:property value="id" />')">
											<span class="icon-remove icon-white"></span>&nbsp;删除&nbsp;
										</button></span>
								</s:if> <s:else>
									<span class="icon-remove" title="禁止编辑"></span>
								</s:else></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>

			<jsp:include page="/jsp/pagingfooter.jsp" flush="true">
				<jsp:param name="_action_name" value="OptionMgrListSearch.action" />
			</jsp:include>
		</div>
		</div>
</div>

