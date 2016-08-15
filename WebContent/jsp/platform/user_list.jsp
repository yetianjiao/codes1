<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="messageDiv" style="display: none;">
	<s:actionmessage />
	<s:actionerror />
</div>

<form id="SearchForm">
	<div class="row-fluid">
		<div class="span12">
			<div class="head clearfix">
				<div class="isw-zoom"></div>
				<h1>查询条件</h1>
			</div>
			<div class="block-fluid">
				<div class="row-form clearfix">
					<div class="span1">关键字</div>
					<div class="span3">
						<s:textfield name="user.keyword_condition" placeholder="匹配用户名,昵称" />
					</div>
					   <div class="span1">类型</div>
                    <div class="span3">
                        <s:select list="roleList" name="user.role_id" listKey="id" listValue="name"></s:select>
                    </div>
                    <div class="span2">
                        <button class="btn btn-primary" type="button" onclick="search('User')">
                            <span class="icon-search icon-white"></span>&nbsp;查询&nbsp;
                        </button>
                    </div>
						
				</div>
			</div>
		</div>
	</div>
</form>

<div class="row-fluid">
	<div class="span12">
		<div class="head clearfix">
			<div class="isw-list"></div>
			<h1>用户列表</h1>
			<ul class="buttons">
				<li><button class="btn btn-warning" type="button" onclick="redirectPage('UserMgrAddIndex.action')">
						<span class="icon-plus icon-white"></span>&nbsp;新增&nbsp;
					</button>&nbsp;</li>
			</ul>
		</div>

		<div class="block-fluid table-sorting clearfix">
			<table cellpadding="0" cellspacing="0" width="100%" class="table" id="dataTable">
				<thead>
					<tr>
						<th width="40px">序号</th>
						<th id="logo_path" sort="" clsss="" role="columnheader">图片</th>
						<th id="username" sort="" clsss="sorting" role="columnheader">用户名</th>
						<th id="nickname" sort="" clsss="sorting" role="columnheader">昵称</th>
						<th id="role.name" sort="" clsss="sorting" role="columnheader">角色</th>
						<th id="gender" sort="" clsss="sorting" role="columnheader">性别</th>
						<th id="birthday" sort="" clsss="sorting" role="columnheader">生日</th>
						<th id="mobile" sort="" clsss="sorting" role="columnheader">手机</th>
						<th id="user.user_state" sort="" clsss="sorting" role="columnheader">状态</th>
						<th width="120px">操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="userList" status="status">
						<tr>
							<td><s:property value="rowNumberStart + #status.index + 1" /></td>
							<td width="64px"><a href="<%=request.getContextPath()%>${logo_path}" target="_blank"> <img id="listImage" src="<%=request.getContextPath()%>${logo_path}" />
                            </a></td>
							<td><a href="#" onclick="detail('UserMgrDetail.action','用户详情','<s:property value="id" />')"> <span class="icon-user"></span> <s:property value="username" />
							</a></td>
							<td><s:property value="nickname" /></td>
							<td><s:property value="role_name" /></td>
							<td><s:property value="gender_name" /></td>
							<td><s:date name="birthday" format="yyyy-MM-dd" /></td>
							<td><s:property value="mobile" /></td>
							<td><s:property value="user_state_name" /></td>
							
							<s:if test="#session.User.role_id==1">
								<s:if test="#session.User.username==admin">
								<td><span><button class="btn btn-mini btn-primary" type="button" onclick="editIndex('User','<s:property value="id" />')">
											<span class="icon-pencil icon-white"></span>&nbsp;编辑&nbsp;
										</button></span> <span><button class="btn btn-mini btn-danger" type="button" onclick="del('User','<s:property value="id" />')">
											<span class="icon-remove icon-white"></span>&nbsp;删除&nbsp;
										</button></span></td>
								</s:if>
								<s:else>
								    <s:if test="role_id!=1">
								        <td><span><button class="btn btn-mini btn-primary" type="button" onclick="editIndex('User','<s:property value="id" />')">
											<span class="icon-pencil icon-white"></span>&nbsp;编辑&nbsp;
										</button></span> <span><button class="btn btn-mini btn-danger" type="button" onclick="del('User','<s:property value="id" />')">
											<span class="icon-remove icon-white"></span>&nbsp;删除&nbsp;
										</button></span></td>
								    </s:if>	
								     <s:else>
							         <td><span></span></td>
							      </s:else>							
								</s:else>
							 </s:if>
							 <s:if test="#session.User.role_id==2">
							     <s:if test="role_id==3 || role_id==4">
							        <td><span><button class="btn btn-mini btn-primary" type="button" onclick="editIndex('User','<s:property value="id" />')">
										<span class="icon-pencil icon-white"></span>&nbsp;编辑&nbsp;
									</button></span> <span><button class="btn btn-mini btn-danger" type="button" onclick="del('User','<s:property value="id" />')">
										<span class="icon-remove icon-white"></span>&nbsp;删除&nbsp;
									</button></span></td>
							      </s:if>
							      <s:else>
							         <td><span></span></td>
							      </s:else>
							 </s:if>
							
						</tr>
					</s:iterator>
				</tbody>
			</table>

			<jsp:include page="/jsp/pagingfooter.jsp" flush="true">
				<jsp:param name="_action_name" value="UserMgrListSearch.action" />
			</jsp:include>
		</div>
	</div>
</div>

