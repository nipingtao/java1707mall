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
					  		<label >广告主图</label>
						  	<img alt="" id="imgId" src="" width="100" height="100">
						  	<input type="hidden" id="mainImage" name="mainImage"/>
						  	<input type="file" name="pictureFile" onchange="uploadPic();"/>
				         </div> 
		                    <div class="form-group">
					  	<label>广告图片</label>
					  	 <a href="javascript:void(0)" class="picFileUpload" id="picFileUpload">上传图片</a>
		                 <input type="hidden" name="subImages" id="subImages"/>
		                 <div id="J_imageView"></div>
					  </div>
					  <div class="form-group">
		                    <input class="btn btn-success btn-lg" type="submit" value="添加"/>
	                	</form>
		            <!-- 学生添加表单  end -->
		        </div>
	
</body>
</html>

<script type="text/javascript">
var myKindEditor ;
KindEditor.ready(function(K) {
	var kingEditorParams = {
			//指定上传文件参数名称
			filePostName  : "pictureFile",
			//指定上传文件请求的url。
			uploadJson : "${ctx}/upload/pic.action",
			//上传类型，分别为image、flash、media、file
			dir : "image",
			afterBlur: function () { this.sync(); }

	}
	var editor = K.editor(kingEditorParams);
	//多图片上传
	K('#picFileUpload').click(function() {
		editor.loadPlugin('multiimage', function() {
			editor.plugin.multiImageDialog({
				clickFn : function(urlList) {
					console.log(urlList);
					var div = K('#J_imageView');
					var imgArray = [];
					div.html('');
					K.each(urlList, function(i, data) {
						imgArray.push(data.url);
						div.append('<img src="' + data.url + '" width="80" height="50">');
					});
					$("#subImages").val(imgArray.join(","));
					editor.hideDialog();
				}
			});
		});
	});
});
</script>