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
		                <a href="${pageContext.request.contextPath}/product/findPageBeanList.action" class="list-group-item active">商品管理</a>
		                <a href="${pageContext.request.contextPath}/product/getAddPage.action" class="list-group-item">添加商品</a>
		                 
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li class="active">
		                    <a href="${pageContext.request.contextPath}/product/findPageBeanList.action">商品列表</a>
		                </li>
		                <li>
		                	<a href="${pageContext.request.contextPath}/product/getAddPage.action">添加商品</a>
		                </li>
		            </ul>
				</head>
		<form action="/Java1707Mall/product/updateProduct.action" method="post">
		&nbsp;&nbsp;ID： &nbsp;<input type="text" name="id" readonly="readonly" value="${product.getId()}" class="form-control"/><br>
		分类ID：<input type="text" name="categoryId"  value="${product.getCategoryId()}" class="form-control"/><br>
		产品名：<input type="text" name="name"  value="${product.getName()}" class="form-control"/><br>
		副标题：<input type="text" name="subtitle" value="${product.getSubtitle()}" class="form-control"/><br>
		价格：<input type="text" name="price" value="${product.getPrice()}" class="form-control"/><br>
                      数量：<input type="text" name="stock" value="${product.getStock()}" class="form-control"/><br>
		状态：
		 <select name="status" class="form-control" ">
			<option value="">状态</option>
			<option value="1">上架</option>
			<option value="2">下架</option>
		</select>
		创建时间：<input type="text" name="createTime" value="${product.getCreateTime()}"  class="form-control"/><br>
		更新时间：<input type="text" name="updateTime" value="${product.getUpdateTime()}" class="form-control"/><br>
		       <input  type="submit" value="修改" class="btn btn-primary btn-lg"/>
	</form>
				</body>
</html>