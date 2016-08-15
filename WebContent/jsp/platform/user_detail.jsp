<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row-fluid">
	<div class="span12">
		<div class="row-form clearfix">
			<div class="row-form clearfix">
				<div class="span1">用户名</div>
				<div class="span4">
					<s:property value="user.username" />
				</div>
				<div class="span1">昵称</div>
                <div class="span4">
                    <s:property value="user.nickname" />
                </div>
				
			</div>
			<div class="row-form clearfix">
			    <div class="span1">角色</div>
                <div class="span4">
                    <s:property value="user.role_name" />
                </div>
                <div class="span1">帐户状态</div>
                <div class="span4">
                    <s:property value="user.user_state_name" />
                </div>
            </div>

			<div class="row-form clearfix">
				<div class="span1">性别</div>
				<div class="span4">
					<s:property value="user.gender_name" />
				</div>
				<div class="span1">生日</div>
                <div class="span4">
                    <s:date name="user.birthday" format="yyyy-MM-dd" />
                </div>
			</div>

            <div class="row-form clearfix">
                <div class="span1">座机</div>
                <div class="span4">
                    <s:property value="user.telephone" />
                </div>
                <div class="span1">手机</div>
                <div class="span4">
                    <s:property value="user.mobile" />
                </div>
            </div>
            
			<div class="row-form clearfix">
				<div class="span1">电子邮箱</div>
				<div class="span4">
					<s:property value="user.email" />
				</div>
				<div class="span1">QQ</div>
                <div class="span4">
                    <s:property value="user.qq" />
                </div>
				
			</div>
			
			<div class="row-form clearfix">
				<div class="span1">住址</div>
				<div class="span4">
					<s:property value="user.address" />
				</div>
				<div class="span1">邮政编码</div>
				<div class="span4">
					<s:property value="user.post_code" />
				</div>
			</div>
			
			<div class="row-form clearfix">
                <div class="span1">LOGO图片</div>
                <div class="span1">
                    <a href="<%=request.getContextPath()%>${user.logo_path}" target="_blank"> <img id="listImage" src="<%=request.getContextPath()%>${user.logo_path}" />
                    </a>
                </div>
            </div>
		</div>
	</div>
</div>

