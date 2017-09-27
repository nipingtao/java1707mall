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
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<title></title>
</head>
<body>
	<%@include file="../common/head.jsp"%>
	<%@include file="../common/header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a
						href="${pageContext.request.contextPath}/student/pageList.action"
						class="list-group-item active">学生管理</a> <a
						href="${pageContext.request.contextPath}/student/getAddPage.action"
						class="list-group-item">添加学生</a>

				</div>
			</div>
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li class="active"><a
						href="${pageContext.request.contextPath}/student/pageList.action">学生列表</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath}/student/getAddPage.action">添加学生</a>
					</li>
				</ul>
				</head>
				    <div>
		            <form class="form_border"  action="/Java1707Ssm/student/AddStudentService.action" method="post">
	                    <div class="form-group">
	                        <label>产品名</label>
	                        <input type="text" id="name" name="name"  class="form-control" placeholder="产品名">
	                        <span id="nameInfo" > </span>
	                    </div>
	                    
	                    <div class="form-group">
	                        <label>副标题</label>
	                        <input type="text" name="subtitle"  class="form-control" placeholder="副标题">
	                    </div>
	                    <div class="form-group">
	                        <label >价格</label>
	                        <input type="text" name="price" class="form-control" placeholder="请输入产品价格">
	                    </div>
	                    <div class="form-group">
	                        <label >数量</label>
	                        <input type="text" name="stock"  class="form-control" placeholder="请输入产品数量">
	                    </div>
	                    <div class="form-group">
	                        <label >状态</label>
	                        <input type="text" name="status" class="form-control" placeholder="状态">
	                    </div>
	                    <div class="form-group">
	                        <label>创建时间</label>
	                        <input type="text" name="createTime" class="form-control" placeholder="创建时间">
	                    </div>
	                    <div class="form-group">
	                        <label>更新时间</label>
	                        <input type="text" name="updateTime" class="form-control" placeholder="更新时间">
	                    </div>
	                    
	                    <input class="btn btn-success btn-lg" type="submit" value="添加"/>
                	</form>
		            <!-- 学生添加表单  end -->
		            
		        </div>
				
				
				

</body>
</html>