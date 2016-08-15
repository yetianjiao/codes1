<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row-fluid">
	<div class="span12">
		<div class="head clearfix">
			<div class="isw-list"></div>
			<h1>角色列表</h1>
		</div>

		<div class="block-fluid table-sorting clearfix">
			<table cellpadding="0" cellspacing="0" width="100%" class="table" id="dataTable">
				<thead>
					<tr>
						<th width="40px">序号</th>
						<th id="name" sort="" clsss="sorting" role="columnheader">角色名</th>
						<th id="code" sort="" clsss="sorting" role="columnheader">角色代码</th>
						<th role="columnheader">权限设置</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="roleList" status="status">
						<tr>
							<td><s:property value="rowNumberStart + #status.index + 1" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="code" /></td>
							<td><span><button class="btn btn-mini btn-primary" type="button" onclick="redirectPage('RoleRightMgrAddIndex.action?role_id=<s:property value="id" />&role_name=<s:property value="name" />')">
                                            <span class="icon-pencil icon-white"></span>&nbsp;设置&nbsp;</button></span></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>

			<jsp:include page="/jsp/pagingfooter.jsp" flush="true">
				<jsp:param name="_action_name" value="RoleMgrListSearch.action" />
			</jsp:include>
		</div>
	</div>
</div>

