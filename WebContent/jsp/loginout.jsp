<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>禹慕科技综合管理平台</title>

<script type="text/javascript">
	$(document).ready(function() {
		alert("请先登录!");
		window.location = "<%=request.getContextPath()%>/LoginRedirect";
	});
</script>

</head>
<body>
</body>
</html>