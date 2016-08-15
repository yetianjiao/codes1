<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="header.jsp"%>

<div class="errorPage">
	<p class="name">503</p>
	<p class="description">服务不可用</p>
	<p>
		<button class="btn btn-danger" onClick="document.location.href = 'LoginSearch.action';">转向首页</button>
		<button class="btn btn-warning" onClick="history.back();">返回上一页面</button>
	</p>
</div>

<%@ include file="footer.jsp"%>
