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
	$(function () {
		$.ajax({
			url:"${pageContext.request.contextPath}/category/parenCategoryList.action",
			dataType:"json",
			success:function (data,textStatus,ajax) {
			
				var html = "<option>-- 请选择 --</option>"
				for (var i = 0; i < data.length; i++) {
					
					html += "<option value='"+data[i].id+"'>" + data[i].name + "</option>";
				}
				$("#ParentCategory").html(html);
			}
		});
	});
	
	function selectCategory (Obj) {
		var parentId = $(Obj).val();
		$("#Category option:gt(0)").remove();
		$.ajax({
			url:"${pageContext.request.contextPath}/category/categoryList.action",
			dataTypr:"json",
			data:"parentId="+parentId,
			success:function (data,textStatus,ajax) {
				var html = "<option>-- 请选择 --</option>";
				for (var i =0; i < data.length; i++) {
					html += "<option value='"+data[i].id+"'>" + data[i].name + "</option>";
				}
				$("#Category").html(html);
			}
		});
	}
</script>
</head>
<body>
	
	
	<div class="container">
		<div class="row">
			<div class="col-md-2">
		            <div class="list-group">
		                <a href="${pageContext.request.contextPath}/product/findPageBeanList.action" class="list-group-item ">商品管理</a>
		                <a href="${pageContext.request.contextPath}/product/getAddPage.action" class="list-group-item active">添加商品</a>
		                 
		            </div>
		        </div>
		        <div class="col-md-10">
		            <ul class="nav nav-tabs">
		                <li >
		                    <a href="${pageContext.request.contextPath}/product/findPageBeanList.action">商品列表</a>
		                </li>
		                <li class="active">
		                	<a href="${pageContext.request.contextPath}/product/getAddPage.action">添加商品</a>
		                </li>
		            </ul>
				</head>
				    <div>
		            <form id="form-add" class="form_border"  action="/Java1707Mall/product/AddProductService.action" enctype="multipart/form-data" method="post">
	                    
	                    <div class="input-group input-group-sm">
 						 <span class="input-group-addon" id="sizing-addon3">分类</span>
 						 <select  class="form-control" id="ParentCategory" onchange="selectCategory(this)">
 						 	<option value="">-- 请选择 --</option>
 						 </select>
 						 <select  class="form-control" id="Category" name="categoryId">
 						 	<option value="">-- 请选择 --</option>
 						 </select>
					    </div>
	                    
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
	                     <div  class="form-group">
					  		<label >产品主图</label>
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