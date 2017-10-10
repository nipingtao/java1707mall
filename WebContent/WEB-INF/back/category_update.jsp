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
	<%@include file="../common/headerf.jsp"%>
	<link rel="stylesheet"
	href="${ctx}/resources/thirdlib/bootstrap/css/bootstrap.css" />
	<div class="container">
		<div class="row">
			<div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/category/findPageBeanList.action" class="list-group-item active">商品管理</a>
		                <a href="${pageContext.request.contextPath}/category/getAddPage.action" class="list-group-item">添加商品</a>
		                 
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                    <a href="${pageContext.request.contextPath}/category/findPageBeanList.action">商品列表</a>
		                </li>
		                <li>
		                	<a href="${pageContext.request.contextPath}/category/getAddPage.action">添加商品</a>
		                </li>
		            </ul>
				</head>
		<form action="/Java1707Mall/category/updatecategory.action" method="post">
		&nbsp;&nbsp;ID： &nbsp;<input type="text" name="id" readonly="readonly" value="${category.getId()}" class="form-control"/><br>
		分类名称：
		<select name="parentId" class="form-control">
		    <option value="">一级分类不修改</option>
         	<c:forEach items="${list}" var="category">
              <option value="${category.id}" >${category.name}</option>
         	</c:forEach>	
         </select>
		
		产品名：<input type="text" name="name"  value="${category.getName()}" class="form-control"/><br>

		状态：
		 <select name="category" class="form-control" ">
			<option value="">状态</option>
			<option value="1">上架</option>
			<option value="2">下架</option>
		</select>
		创建时间：<input type="text" name="createTime" value="${category.getCreateTime()}"  class="form-control"/><br>
		更新时间：<input type="text" name="updateTime" value="${category.getUpdateTime()}" class="form-control"/><br>
		       <input  type="submit" value="修改" class="btn btn-primary btn-lg"/>
	</form>
				</body>
</html>