<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row-fluid">
	<div class="span12">
		<div class="row-form clearfix">
			<div class="row-form clearfix">
				<div class="span2">名称</div>
				<div class="span4">
					<s:property value="demo.name" />
				</div>
			</div>
			
			<div class="row-form clearfix">
                <div class="span2">备注</div>
                <div class="span4">
                    <s:property value="demo.remark" />
                </div>
            </div>
            
            
            
		</div>
	</div>
</div>

