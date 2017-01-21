<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
	<link href="/style/common_style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/js/jquery/jquery.js"></script>
	<script type="text/javascript" src="/js/comment/commonAll.js"></script>
	<script type="text/javascript" src="/js/plugins/artDialog/jquery.artDialog.js?skin=blue"></script>
	<script type="text/javascript" src="/js/view/${objName}/list.js"></script>
	<title>PSS-${classCnName}管理</title>
	<style>
		.alt td{ background:black !important;}
	</style>
</head>
<body>
<s:debug/>
<%--显示错误信息--%>
<s:include value="/WEB-INF/comment/comment_msg.jsp"/>
	<s:form id="searchForm" action="${objName}_" method="post">
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_bottom">
							<input type="button" value="新增" class="ui_input_btn01 btn_input" data-href="<s:url namespace="/" action="${objName}_input"/> " />
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							<th>${classCnName}ID</th>
							<#assign h = map />
							<#assign keys = h?keys/>
							<#list keys as key>
							<th>${classCnName}${h[key]}</th>
							</#list>
							<th></th>
						</tr>
						<tbody>
							<s:iterator value="#pageResult.dataList">
								<tr>
									<td><s:property value="id"/> </td>
									<#list keys as key>
									<td><s:property value="${key}"/> </td>
									</#list>
									<td>
										<s:a namespace="/" action="${objName}_input">编辑
											<s:param name="${objName}.id" value="id"/>
										</s:a>
										<s:url namespace="/" action="${objName}_delete" var="deleteURL">
											<s:param name="${objName}.id" value="id"/>
										</s:url>
										<a href="javascript:;" class="delete" data-href=<s:property value="#deleteURL"/> >删除</a>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<%--引入分页栏--%>
				<s:include value="/WEB-INF/comment/comment_page.jsp"/>
			</div>
		</div>
	</s:form>
</body>
</html>
