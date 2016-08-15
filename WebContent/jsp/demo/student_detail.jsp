<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row-fluid">
	<div class="span12">
		<div class="row-form clearfix">
			<div class="row-form clearfix">
				<div class="span2">学生姓名</div>
				<div class="span4">
					<s:property value="student.name" />
				</div>
			</div>
			
			<div class="row-form clearfix">
                <div class="span2">学号</div>
                <div class="span4">
                    <s:property value="student.sn" />
                </div>
            </div>
            
            <div class="row-form clearfix">
                <div class="span2">性别</div>
                <div class="span4">
                    <s:property value="student.gender_name" />
                </div>
            </div>
            
            <div class="row-form clearfix">
                <div class="span2">年龄</div>
                <div class="span4">
                    <s:property value="student.age" />
                </div>
            </div>
            
		</div>
	</div>
</div>

