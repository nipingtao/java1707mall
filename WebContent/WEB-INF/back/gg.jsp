<%@page import="com.situ.mall.vo.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.situ.mall.pojo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@include file="../common/head.jsp"%>
<%@include file="../common/header.jsp"%>
<link rel="stylesheet"
	href="${ctx}/resources/thirdlib/bootstrap/css/bootstrap.css" />
<script type="text/javascript">
	function goPage(pageIndex) {
		$('#pageIndex').val(pageIndex);
		$('#searchForm').submit();
	}
	$(function() {
		$("#status #option[value='${searchCondition.status}']").prop(
				"selected", true);
	});
	function delGg(id) {
		var idDel = confirm("您确认要删除吗?");
		location.href = "${pageContext.request.contextPath}/gg/deletById.action?id="
				+ id;
	}
	function selectAlls() {
		$("input[name=ids]").prop("checked", $("#selectAll").is(":checked"));
	}
	function deleteAll() {
		var isDel = confirm("您确认要删除吗？");
		if (isDel) {
			//要删除
			$("#mainForm")
					.attr("action",
							"${pageContext.request.contextPath}/gg/deleteAll.action");
			$("#mainForm").submit();
		}
	}
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a
						href="${pageContext.request.contextPath}/gg/findPageBeanList.action"
						class="list-group-item active">广告管理</a> <a
						href="${pageContext.request.contextPath}/gg/getAddPage.action"
						class="list-group-item">添加广告</a>

				</div>
			</div>
	<div class="col-md-10">
		 <ul class="nav nav-tabs">
				<li class="active"><a
					href="${pageContext.request.contextPath}/gg/findPageBeanList.action">广告列表</a>
				</li>
				<li><a
					href="${pageContext.request.contextPath}/gg/getAddPage.action">添加广告</a>
				</li>
		 </ul>
				
				
				<%
					PageBean pageBean = (PageBean) request.getAttribute("pageBean");
					List<Gg> list = pageBean.getList();
				%>

				<a href="javascript:deleteAll()"><input style="width: 165px"
					type="submit" value="批量删除" class="btn btn-primary btn-lg" /></a>

	<form id="mainForm" action="" method="post">
		<table
			class="table align-center table table-striped table-bordered table-hover table-condensed ">
			<tr>
				<td><input type="checkbox" id="selectAll"
					onClick="selectAlls();"></input></td>
				<td class="active">id</td>
				
				<td>广告</td>
				
				<td class="active">删除</td>
				
			</tr>
			<c:forEach items="${pageBean.list}" var="stu">
				<tr class="warning">
					<td><input type="checkbox" name="ids" value="${stu.id}"></input>
					</td>
					<td>${stu.id}</td>
					
					<td><img alt="" src="/pic/${stu.mainImage}" width="80" height="60""></td>
					<td><a href="javascript:delGg('${stu.id }')"><input
							type="button" value="删除" class="btn btn-danger" /></a></td>
			</c:forEach>
		</table>
				</form>
				 <!-- 分页开始 -->
				<nav aria-label="Page navigation" class="pull-right">
				  <ul class="pagination">
				  	<!-- 上一页 开始-->
				  	<c:if test="${pageBean.pageIndex==1}">
				  		<li class="disabled">
					      <a href="javascript:void(0);" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
				    	</li>
				  	</c:if>
				  	<c:if test="${pageBean.pageIndex!=1}">
				  		<li>
					      <a href="${pageContext.request.contextPath}/gg/findPageBeanList.action?pageIndex=${pageBean.pageIndex-1}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
				    	</li>
				  	</c:if>
				    
				  	<!-- 上一页 结束-->
				  
				  	<c:forEach begin="1" end="${pageBean.totalPage}" var="page">
				  		<c:if test="${pageBean.pageIndex!=page}">
					        <li><a href="${pageContext.request.contextPath}/gg/findPageBeanList.action?pageIndex=${page}">${page}</a></li>
				  		</c:if>
				  		<!-- 遍历的时候page和pageIndex相等，高亮显示 -->
				  		<c:if test="${pageBean.pageIndex==page}">
					        <li class="active"><a href="${pageContext.request.contextPath}/gg/findPageBeanList.action?pageIndex=${page}">${page}</a></li>
				  		</c:if>
				  	</c:forEach>
				  	<c:if test="${pageBean.pageIndex==pageBean.totalPage}">
				  		<li class="disabled">
					      <a href="javascript:void(0);" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
				    	</li>
				  	</c:if>
				  	<c:if test="${pageBean.pageIndex!=pageBean.totalPage}">
				  		<li>
					      <a href="${pageContext.request.contextPath}/gg/findPageBeanList.action?pageIndex=${pageBean.pageIndex+1}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
				    	</li>
				  	</c:if>
		 		  </ul>
				</nav>
				<!-- 分页结束 --> 
				<%-- <!-- 分页开始 -->
				<nav aria-label="Page navigation" class="pull-right">
				<ul class="pagination">
					<!-- 上一页 开始-->
					<c:if test="${pageBean.pageIndex==1}">
						<li class="disabled"><a href="javascript:void(0);"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:if test="${pageBean.pageIndex!=1}">
						<li><a href="javascript:goPage('${pageBean.pageIndex-1}')"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<!-- 上一页 结束-->

					<c:forEach begin="1" end="${pageBean.totalPage}" var="page">
						<c:if test="${pageBean.pageIndex!=page}">
							<li><a href="javascript:goPage('${page}')">${page}</a></li>
						</c:if>
						<!-- 遍历的时候page和pageIndex相等，高亮显示 -->
						<c:if test="${pageBean.pageIndex==page}">
							<li class="active"><a href="javascript:goPage('${page}')">${page}</a></li>
						</c:if>
					</c:forEach>

					<!-- 下一页 开始-->
					<c:if test="${pageBean.pageIndex==pageBean.totalPage}">
						<li class="disabled"><a href="javascript:void(0);"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<c:if test="${pageBean.pageIndex!=pageBean.totalPage}">
						<li><a href="javascript:goPage('${pageBean.pageIndex+1}')"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<!-- 下一页 结束-->
				</ul>
				</nav>
				<!-- 分页结束 --></body> --%>
</html>