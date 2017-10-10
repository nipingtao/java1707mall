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
	content="width=devi
	ce-width, initial-scale=1 , user-scalable=no">
<title></title>

<%@include file="../common/head.jsp"%>
<%@include file="../common/headerf.jsp"%>
<link rel="stylesheet"
	href="${ctx}/resources/thirdlib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="/Java1707Mall/resources/thirdlib/jquery/jquery.form.js"></script>
<script type="text/javascript">
	function uploadPic(){
		//定义参数
		var options = {
				url : "${ctx}/upload/uploadPic.action",
				dataType : "json",
				type : "post",
				success : function(data) {
					$("#imgId").attr("src", "/pic/" + data.fileName);
					$("#mainImage").val(data.fileName);
				}
		};
		
		 $("#form-add").ajaxSubmit(options);
	}
</script>
</head>
<body>
	
	
	<div class="container">
		<div class="row">
			<div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/category/findPageBeanList.action" class="list-group-item ">商品管理</a>
		                <a href="${pageContext.request.contextPath}/category/getAddPage.action" class="list-group-item active">添加商品</a>
		                 
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li >
		                    <a href="${pageContext.request.contextPath}/category/findPageBeanList.action">商品列表</a>
		                </li>
		                <li class="active">
		                	<a href="${pageContext.request.contextPath}/category/getAddPage.action">添加商品</a>
		                </li>
		            </ul>
				</head>
				    <div>
		            <form id="form-add" class="form_border"  action="/Java1707Mall/category/AddCategoryService.action" enctype="multipart/form-data" method="post">
	                    
	      
 						 <span class="form-group">分类</span>
 						 <select name="parentId" class="form-control">
 						 <option value="0">一级分类</option>
			         	<c:forEach items="${list}" var="category">
			              <option value="${category.id}" >${category.name}</option>
			         	</c:forEach>	
			         </select>
			 					
	                    <div class="form-group">
	                        <label>产品名</label>
	                        <input type="text" id="name" name="name"  class="form-control" placeholder="产品名">
	                        <span id="nameInfo" > </span>
	                    </div>
	                    
	                    <div class="form-group">
	                        <label >状态</label>
							  	   <select name="status" class="form-control">
							  	   <option value="">状态</option>
							  		<option value="1">上架</option>
							  		<option value="2">下架</option>
							  	</select>
				              </div>
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