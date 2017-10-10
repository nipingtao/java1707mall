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
<%@include file="../common/header.jsp"%>
<link rel="stylesheet"
	href="${ctx}/resources/thirdlib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${ctx}/resources/thirdlib/jquery/jquery.form.js"></script>
<link href="${ctx}/resources/thirdlib/kindeditor/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="${ctx}/resources/thirdlib/kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/resources/thirdlib/kindeditor/lang/zh_CN.js"></script>
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
		                <a href="${pageContext.request.contextPath}/gg/findPageBeanList.action" class="list-group-item ">商品管理</a>
		                <a href="${pageContext.request.contextPath}/gg/getAddPage.action" class="list-group-item active">添加商品</a>
		                 
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li >
		                    <a href="${pageContext.request.contextPath}/gg/findPageBeanList.action">商品列表</a>
		                </li>
		                <li class="active">
		                	<a href="${pageContext.request.contextPath}/gg/getAddPage.action">添加商品</a>
		                </li>
		            </ul>
				</head>
				    <div>
		            <form id="form-add" class="form_border"  action="/Java1707Mall/gg/AddGgService.action" enctype="multipart/form-data" method="post">
	                    
	                     <div  class="form-group">
					  		<label >广告图片</label>
						  	<img alt="" id="imgId" src="" width="100" height="100">
						  	<input type="hidden" id="mainImage" name="mainImage"/>
						  	<input type="file" name="pictureFile" onchange="uploadPic();"/>
				         </div> 
		                    <input class="btn btn-success btn-lg" type="submit" value="添加"/>
	                	</form>
		            <!-- 学生添加表单  end -->
		        </div>
	
</body>
</html>
</script>