<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.situ.mall.pojo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
     <script type="text/javascript">
	function goPage(pageIndex) {
		$('#pageIndex').val(pageIndex);
		$('#searchForm').submit();
	}
	$(function(){
	       $("#gender option[value='${searchCondition.gender}']").prop("selected", true);
	    });
	function delProduct(id) {
		var idDel = confirm("您确认要删除吗?");
		location.href="${pageContext.request.contextPath}/product/deletById.action?id="+id;
	}
	function selectAlls() {
		$("input[name=ids]").prop("checked", $("#selectAll").is(":checked"));
	}
	function deleteAll(){
		var isDel = confirm("您确认要删除吗？");
		if (isDel) {
			//要删除
			$("#mainForm").attr("action", "${pageContext.request.contextPath}/student/deleteAll.action");
			$("#mainForm").submit();
		}
	}
	</script>
</head>
<body>
	<%@include file="../common/head.jsp" %>
	<%@include file="../common/header.jsp"%>
	<div class="container">
	<div class="row">
		        <div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/product/pageList.action" class="list-group-item active">商品管理</a>
		                <a href="${pageContext.request.contextPath}/product/getAddPage.action" class="list-group-item">添加商品</a>
		                 
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                    <a href="${pageContext.request.contextPath}/student/pageList.action">商品列表</a>
		                </li>
		                <li>
		                	<a href="${pageContext.request.contextPath}/product/getAddPage.action">添加商品</a>
		                </li>
		            </ul>
			<a href="javascript:deleteAll()"><input style="width:165px"  type="submit" value="批量删除" class="btn btn-primary btn-lg"/></a>
		   <form id="mainForm" action="" method="post">
		    <table class="table align-center table table-striped table-bordered table-hover table-condensed " >
		    <tr>
		    <td>
		    <input type="checkbox" id="selectAll" onClick="selectAlls();" ></input>
		    </td>
			<td class="active">id</td>
			<td class="success" >产品名</td>
			<td class="warning">副标题</td>
			<td class="danger">价格</td>
			<td>数量</td>
			<td class="warning">状态</td>
			
			<td class="success">创建时间</td>
			<td class="warning">更新时间</td>
			<td class="active">删除</td>
			<td>修改</td>	
		</tr>
        <c:forEach items="${list}" var="stu">
				<tr class="warning">
				    <td>
					<input type="checkbox"  name="ids" value="${stu.getId()}"></input>
					</td>
					<td>${stu.getId()}</td>
					<td>${stu.getName()}</td>
					<td>${stu.getSubtitle()}</td>
					<td>${stu.getPrice()}</td>
					<td>${stu.getStock()}</td>
					<td>
					 <c:if test="${stu.status == 1}">在售</c:if>
					 <c:if test="${stu.status == 2}">下架</c:if>
					</td>
					<td>
					<fmt:formatDate value='${stu.getCreateTime()}' pattern='yyyy-MM-dd'/>
					</td>
					<td>
					<fmt:formatDate value='${stu.getUpdateTime()}' pattern='yyyy-MM-dd'/>
					</td>
					<td ><a href="javascript:delProduct('${stu.id }')"><input type="button" value="删除" class="btn btn-danger"/></a></td>
					<td><a  href="${pageContext.request.contextPath}/product/update.action?id=${stu.getId()}"><input type="button" value="修改" class="btn btn-info"/></a></td>
			      </tr>
		</c:forEach>
	</table>
	</form>

</body>
</html>