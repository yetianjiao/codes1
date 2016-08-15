<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="css/zTreeStyle/dataTree.css" type="text/css">
<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="js/common/product_tree.js"></script>

<div class="row-fluid">
	<div class="span3">
		<div class="head clearfix">
			<div class="isw-documents"></div>
			<h1>树形目录</h1>
		</div>
		<div class="block-fluid">
			<div class="zTreeDemoBackground left">
				<ul id="tree" class="ztree"></ul>
			</div>
		</div>
	</div>

	<div class="span9" id="span9">
		<div class="head clearfix">
			<div class="isw-list"></div>
			<h1>分类列表</h1>
		</div>

		<div class="block-fluid table-sorting clearfix">
			<table cellpadding="0" cellspacing="0" width="100%" class="table" id="dataTable">
				<thead>
					<tr>
						<th width="40px">序号</th>
						<th id="base_system_product.name" sort="" clsss="sorting" role="columnheader">所属产品</th>
						<th id="base_system_field.code" sort="" clsss="sorting" role="columnheader">分类代码</th>
						<th id="base_system_field.name" sort="" clsss="sorting" role="columnheader">分类名称</th>
						<th id="base_system_field.remark" sort="" clsss="sorting" role="columnheader">备注</th>
						<th id="base_system_field.allow_edit_option" sort="" clsss="sorting" role="columnheader">允许编辑</th>

					</tr>
				</thead>
				<tbody>
					<s:iterator value="fieldList" status="status">
						<tr>
							<td><s:property value="rowNumberStart + #status.index + 1" /></td>
							<td><s:property value="system_product_name" /></td>
							<td><s:property value="code" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="remark" /></td>
							<td><s:if test="allow_edit_option==1">
									<span class="icon-ok" title="允许编辑"></span>
								</s:if> <s:else>
									<span class="icon-remove" title="禁止编辑"></span>
								</s:else></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<jsp:include page="/jsp/pagingfooter.jsp" flush="true">
				<jsp:param name="_action_name" value="DictionaryMgrListSearch.action" />
			</jsp:include>
		</div>
	</div>
</div>



