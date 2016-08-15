<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="rowCount!=0">

	<div class="dataTables_info" id="tSortable_info">
		当前显示
		<s:property value="rowNumberStart + 1" />
		到
		<s:property value="rowNumberEnd" />
		条，共
		<s:property value="rowCount" />
		条记录
	</div>
	<div class="dataTables_paginate paging_full_numbers" id="tSortable_paginate">
		<s:if test="pageNumber > 1">
			<a tabindex="0" class="first paginate_button" id="tSortable_first" href="javascript:showPageForm('1')">首页</a>
			<a tabindex="0" class="previous paginate_button" id="tSortable_previous" href="javascript:showPageForm('${pageNumber - 1}')">上一页</a>
		</s:if>
		<s:else>
			<a tabindex="0" class="first paginate_button paginate_button_disabled" id="tSortable_first" href="#">首页</a>
			<a tabindex="0" class="previous paginate_button paginate_button_disabled" id="tSortable_previous" href="#">上一页</a>
		</s:else>
		<span> <a tabindex="0" class="paginate_active" href="#"><s:property value="pageNumber" /></a>
		</span>
		<s:if test="pageNumber < pageCount">
			<a tabindex="0" class="next paginate_button" id="tSortable_next" href="javascript:showPageForm('${pageNumber + 1}')">下一页</a>
			<a tabindex="0" class="last paginate_button" id="tSortable_last" href="javascript:showPageForm('${pageCount}')">尾页</a>
		</s:if>
		<s:else>
			<a tabindex="0" class="next paginate_button paginate_button_disabled" id="tSortable_next" href="#">下一页</a>
			<a tabindex="0" class="last paginate_button paginate_button_disabled" id="tSortable_last" href="#">尾页</a>
		</s:else>

	</div>
</s:if>

<s:else>
	<div class="dataTables_info" id="tSortable_info">无符合条件的数据</div>
</s:else>

<form action="<%=request.getParameter("_action_name")%>" id="pageForm">
	<input name="pageNumber" type="hidden" id="pageNO">
</form>