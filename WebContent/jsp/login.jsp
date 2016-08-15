<%@page import="cn.yumutech.vo.platform.User"%>
<%@page import="cn.yumutech.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    User user = (User) session.getAttribute(Constants.SESSION_USER);
			if (user != null) {
%>
<script type="text/javascript">
	window.location = "LoginSearch.action";
</script>
<%
    }
%>

<script type="text/javascript">
    document.onkeydown = function() {
        if (window.event && window.event.keyCode == 13) {
            window.event.returnValue = false;
        }
    };
</script>

<html>
<head>
<title>实验室综合管理平台</title>
<style type="text/css">
body {
	color: white;
}

input.button {
	padding: 2px 8px 0px;
	margin: 2px 2px;
	border: 1px solid #2D5082;
	background: url(img/button_bg.gif) repeat-x;
}

#header-div {
	background: #278296;
	border-bottom: 1px solid #DDEEF2;
}

#logo-div {
	height: 58px;
}

#submenu-div {
	height: 58px;
}
</style>
<link rel="icon" type="image/ico" href="favicon.ico" />
</head>

<body style="background: #278296;font-size:12px;">
	<div id="header-div">
		<h1 style="margin-top: 50px; margin-bottm: 15px; color: #DDEEF2; font-size: 24pt; line-height: 100%; align: center">
			<center>禹慕科技综合管理平台</center>
		</h1>
	</div>

	<table width="600" align="center" style="margin-top: 80px">
		<tbody>
			<tr>
				<td width="275" valign="top" style="line-height: 180%">
				<font size="5"><b><font color="#996633">用</font><font color="#bb8855">户</font><font color="#ddaa77">登</font><font color="#ffcc99">录</font></b></font><br>
				<br> <font color="#ffffff" style="font-size:12px;">·请在右侧输入您的用户名和密码！</font><br>
				<br> <font color="#DDEEF2" style="font-size:12px;"> 项目名称：禹慕科技综合管理平台<br> 版权单位：四川禹慕科技有限公司<br> 开发单位：四川禹慕科技有限公司<br>
				</font></td>
				<td width="50"><img src="img/login_line.gif"></td>
				<td width="275" valign="top"><br/><br/>
					<form method="post" name="login" action="LoginSearch.action">
						<font color="red"></font>
						<table width="275" align="center">
							<tbody>
								<tr height="30">
									<td widht="50"  style="font-size:12px;">用户名：</td>
									<td><input type="text" id="username" name="user.username" tabindex="1"><br></td>
								</tr>
								<tr height="30">
									<td  style="font-size:12px;">密 码：</td>
									<td><input type="password" id="password" name="user.password" tabindex="2"><br></td>
								</tr>

								<tr height="30">
									<td></td>
									<td  style="font-size:12px;"><input class="button" type="submit" name="loginsubmit" value="进入平台" tabindex="7"></td>
								</tr>
								
							</tbody>
						</table>
					</form>
				</td>
			</tr>
		</tbody>
	</table>

</body>
</html>
