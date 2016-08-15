<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ include file="header.jsp"%>

<div class="header">

	<span
		style="width: 400px; line-height: 30px; color: #fff; font-size: 28px;">禹慕科技综合管理平台</span>
	<ul class="header_menu">
		<li class="list_icon"></li>
	</ul>
</div>

<div class="menu">

	<div class="breadLine">
		<div class="arrow"></div>
		<div class="adminControl active">你好,
			${sessionScope.User.nickname}(${sessionScope.User.username})</div>
	</div>


	<div class="admin">
		<div class="image">
			<img
				src="<%=request.getContextPath()%>${sessionScope.User.logo_path}"
				class="img-polaroid" />
		</div>
		<ul class="control">

			<li><span class="icon-cog"></span> <a href="#"
				onclick="redirectPage('UpdatePersionalInfoIndex.action')">修改个人信息</a></li>

			<li><span class="icon-share-alt"></span> <a href="#"
				onclick="loginOut();">安全退出</a></li>
		</ul>
	</div>


	<ul class="navigation">
		<li class="active"><a href="StartPage.action"> <span
				class="isw-grid"></span><span class="text">禹慕科技综合管理平台</span>
		</a></li>







		<li class="openable"><a href="#"> <span class="isw-settings"></span><span
				class="text">平台管理</span>
		</a>
			<ul>
				<li><a href="#"
					onclick="redirectPage('UserMgrListSearch.action')"> <span
						class="icon-user"></span><span class="text">用户管理</span>
				</a></li>
				<li><a href="#"
					onclick="redirectPage('RoleMgrListSearch.action')"> <span
						class="icon-flag"></span><span class="text">角色及权限管理</span>
				</a></li>
				<li><a href="#"
					onclick="redirectPage('DictionaryMgrListSearch.action')"> <span
						class="icon-book"></span><span class="text">数据字典</span>
				</a></li>

			</ul></li>
			
			<li class="openable"><a href="#"> <span class="isw-settings"></span><span
                class="text">DEMO演示</span>
        </a>
            <ul>
                <li><a href="#"
                    onclick="redirectPage('StudentMgrListSearch.action')"> <span
                        class="icon-user"></span><span class="text">学生管理</span>
                </a></li>
                <li><a href="#"
                    onclick="redirectPage('EquipMgrListSearch.action')"> <span
                        class="icon-user"></span><span class="text">设备管理</span>
                </a></li>
                <li><a href="#"
                    onclick="redirectPage('DemoMgrListSearch.action')"> <span
                        class="icon-user"></span><span class="text">DEMO管理</span>
                </a></li>
                

            </ul></li>



		<li class="openable"><a href="#"> <span class="isw-user"></span><span
				class="text">个人中心</span>
		</a>
			<ul>
				<li><a href="#"
					onclick="redirectPage('UpdatePersionalInfoIndex.action')"> <span
						class="icon-edit"></span><span class="text">修改个人信息</span>
				</a></li>
				<li><a href="#"
					onclick="redirectPage('UpdatePersonalPasswordIndex.action')"> <span
						class="icon-asterisk"></span><span class="text">修改密码</span>
				</a></li>
				<li><a href="#"
					onclick="redirectPage('CheckIndexForPC.action')"> <span
						class="icon-hand-up"></span><span class="text">我的签到</span>
				</a></li>

			</ul></li>


	</ul>

</div>

<div class="content">

	<div class="breadLine">

		<ul class="breadcrumb">
			<li><a href="#">您当前所在的位置：</a> <span class="divider"></span></li>
			<li class="active">首页</li>
		</ul>

	</div>

	<div class="workplace" id="workplace">

		<div class="row-fluid">
			<div class="span12">
				<div class="head clearfix">
					<div class="isw-graph"></div>
					<h1>欢迎使用禹慕科技综合管理平台</h1>
				</div>
				<div class="block-fluid table-sorting clearfix">
					<input type="text" id="date_y" style="display: none">
					<div class="span12" id="container"
						style="min-width: 700px; height: 400px">
						<div class="row-fluid">
							<div class="span12">

								<div class="row-fluid">
									<div class="span12">

										<div class="widgetButtons">

											<div class="bb yellow">
												<a href="#" class="tipb" title="快捷功能"
													><span
													class="ibw-plus"></span></a>

											</div>
											
										</div>

									</div>
								</div>

							</div>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>

