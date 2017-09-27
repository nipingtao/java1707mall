
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.situ.mall.pojo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
		<title></title>
        <script type="text/javascript">
	function goPage(pageIndex) {
		$('#pageIndex').val(pageIndex);
		$('#searchForm').submit();
	}
	$(function(){
	       $("#gender option[value='${searchCondition.gender}']").prop("selected", true);
	    });
	function delStudent(id) {
		var idDel = confirm("您确认要删除吗?");
		location.href="${pageContext.request.contextPath}/student/deletById.action?id="+id;
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
		                <a href="${pageContext.request.contextPath}/student/pageList.action" class="list-group-item active">学生管理</a>
		                <a href="${pageContext.request.contextPath}/student/getAddPage.action" class="list-group-item">添加学生</a>
		                 
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                    <a href="${pageContext.request.contextPath}/student/pageList.action">学生列表</a>
		                </li>
		                <li>
		                	<a href="${pageContext.request.contextPath}/student/getAddPage.action">添加学生</a>
		                </li>
		            </ul>
					 	        <a href="javascript:deleteAll()"><input style="width:165px"  type="submit" value="批量删除" class="btn btn-primary btn-lg"/></a>
					<form id="searchForm" action="${pageContext.request.contextPath}/student/searchByCondition.action" method="post" class="form-inline">
			<input type="hidden" name="pageIndex" id="pageIndex"/>
			姓名：<input type="text" name="name" value="${searchCondition.name }" class="form-control"/>
			年龄:<input type="text" name="age"  value="${searchCondition.age }" class="form-control"/>
			性别：<select id="gender" name="gender" class="form-control" >
					<option value="">不限</option>
					<option value="男">男</option>
					<option value="女">女</option>
			    </select>
			<input type="submit" value="搜索" class="btn btn-primary btn-lg"/>

		</form>
		   <form id="mainForm" action="" method="post">
		    <table class="table align-center table table-striped table-bordered table-hover table-condensed " >
		    <tr>
		    <td>
		    <input type="checkbox" id="selectAll" onClick="selectAlls();" ></input>
		    </td>
			<td class="active">id</td>
			<td class="success" >姓名</td>
			<td class="warning">年龄</td>
			<td class="danger">性别</td>
			<td>地址</td>
			<td class="success">出生日期</td>
			<td class="warning">班级</td>
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
					<td>${stu.getAge()}</td>
					<td>${stu.getGender()}</td>
					<td>${stu.getAddress()}</td>
					<td>${stu.getBirthday()}</td>
					<td ><a href="javascript:delStudent('${stu.id }')"><input type="button" value="删除" class="btn btn-danger"/></a></td>
					<td><a  href="${pageContext.request.contextPath}/student/update.action?id=${stu.getId()}"><input type="button" value="修改" class="btn btn-info"/></a></td>
			      </tr>
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
			      <a href="javascript:goPage('${pageBean.pageIndex-1}')" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
		    	</li>
		  	</c:if>
		  	<!-- 上一页 结束-->
		  
		  	<c:forEach begin="1" end="${pageBean.totalPage}" var="page">
		  		<c:if test="${pageBean.pageIndex!=page}">
			        <li>
			        	<%-- <a href="${pageContext.request.contextPath}/student?method=pageList&pageIndex=${page}">${page}</a> --%>
			        	<a href="javascript:goPage('${page}')">${page}</a>
			        </li>
		  		</c:if>
		  		<!-- 遍历的时候page和pageIndex相等，高亮显示 -->
		  		<c:if test="${pageBean.pageIndex==page}">
			        <li class="active"><a href="javascript:goPage('${page}')">${page}</a></li>
		  		</c:if>
		  	</c:forEach>
		  
		    <!-- 下一页 开始-->
		  	<c:if test="${pageBean.pageIndex==pageBean.totalPage}">
		  		<li class="disabled">
			      <a href="javascript:void(0);" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
		    	</li>
		  	</c:if>
		  	<c:if test="${pageBean.pageIndex!=pageBean.totalPage}">
		  		<li>
			      <a href="javascript:goPage('${pageBean.pageIndex+1}')" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
		    	</li>
		  	</c:if>
		  	<!-- 下一页 结束-->
 		  </ul>
		</nav>
		<!-- 分页结束 -->
		        </div>
		    </div>
		</div>
	</body>
</html>
