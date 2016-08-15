<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="SearchForm">
<div class="row-fluid">
	<div class="span12">
		<div class="head clearfix">
            <div class="isw-list"></div>
            <h1>角色权限列表</h1>
            <ul class="buttons">
                <li><button class="btn btn-warning" type="button" onclick="saveRight('RoleRightMgrAdd.action')">
                        <span class="icon-plus icon-white"></span>&nbsp;保存&nbsp;
                    </button>&nbsp;</li>
                    <li><button class="btn btn-info" type="button" onclick="redirectPage('RoleMgrListSearch.action')">
                        <span class="icon-back icon-white"></span>&nbsp;返回&nbsp;
                    </button>&nbsp;</li>
            </ul>
        </div>
        <s:hidden name="role_id"></s:hidden>

		<div class="block-fluid table-sorting clearfix">
			<table cellpadding="0" cellspacing="0" width="100%" class="table" id="dataTable">
				<thead>
					<tr>
						<th width="40px">选择</th>
						<th id="name" sort="" clsss="sorting" role="columnheader">权限名</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="roleRightList" status="status">
						<tr>
						  <s:if test="hasright=='checked'">
						      <td><input type="checkbox" name="codes" value="${code}" checked/></td>
						  </s:if>
						  <s:else>
						      <td><input type="checkbox" name="codes" value="${code}"/></td>
						  </s:else>
							<td><s:property value="name" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		
		</div>
	</div>
</div>
</form>
