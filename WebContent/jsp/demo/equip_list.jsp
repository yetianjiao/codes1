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
						<s:textfield name="equip.keyword_condition" placeholder="匹配设备名称物主" />
					</div>
                    <div class="span2">
                        <button class="btn btn-primary" type="button" onclick="search('Equip')">
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
			<h1>物资清单</h1>
			<ul class="buttons">
				<li><button class="btn btn-warning" type="button" onclick="redirectPage('EquipMgrAddIndex.action')">
						<span class="icon-plus icon-white"></span>&nbsp;新增&nbsp;
					</button>&nbsp;</li>
			</ul>
		</div>

		<div class="block-fluid table-sorting clearfix">
			<table cellpadding="0" cellspacing="0" width="100%" class="table" id="dataTable">
				<thead>
					<tr>
						<th width="40px">序号</th>
						<th id="name" sort="" clsss="sorting" role="columnheader">名称</th>
						<th id="price" sort="" clsss="sorting" role="columnheader">价格</th>
						<th id="owner" sort="" clsss="sorting" role="columnheader">物主</th>
						<th width="120px">操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="equipList" status="status">
						<tr>
							<td><s:property value="rowNumberStart + #status.index + 1" /></td>
							<td><span class="icon-user"></span> <s:property value="e_name" /></td>
							<td><s:property value="e_price" /></td>
							<td><s:property value="e_owner" /></td>
						    <td><span>
						    	<button class="btn btn-mini btn-primary" type="button" onclick="editIndex('Equip','<s:property value="id" />')">
										<span class="icon-pencil icon-white"></span>&nbsp;编辑&nbsp;</button>
								</span>
								<span>
								<button class="btn btn-mini btn-danger" type="button" onclick="del('Equip','<s:property value="id" />')">
										<span class="icon-remove icon-white"></span>&nbsp;删除&nbsp;</button>
								</span>
						    </td>	
						</tr>
					</s:iterator>
				</tbody>
			</table>

			<jsp:include page="/jsp/pagingfooter.jsp" flush="true">
				<jsp:param name="_action_name" value="StudentMgrListSearch.action" />
			</jsp:include>
		</div>
	</div>
</div>

