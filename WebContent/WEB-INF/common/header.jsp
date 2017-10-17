<%@ page language="java"
    pageEncoding="utf-8"%>
<!--导航-->
<nav class="navbar navbar-default">
    <div class="container">
        <!--小屏幕导航按钮和logo-->
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="index.html" class="navbar-brand">电商后台管理系统</a>
        </div>
        <!--小屏幕导航按钮和logo-->
        <!--导航-->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/product/findPageBeanList.action"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;商品管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/category/findPageBeanList.action"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;商品分类</a></li>
                <li><a href="${pageContext.request.contextPath}/gg/findPageBeanList.action"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;广告管理</a></li>
                <li><a href="${pageContext.request.contextPath}/shipping/findPageBeanList.action"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;收货地址管理</a></li>
                <li><a href="${pageContext.request.contextPath}/orderBack/findPageBeanList.action"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;收货地址管理</a></li>
                     
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style= "color:red " href="${pageContext.request.contextPath}/adminServlet?method=getOnLineList">
                                                                 欢迎您：${admin.name}
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li><a href="index.html"><span class="glyphicon glyphicon-screenshot"></span>&nbsp;&nbsp;前台首页</a></li>
                        <li><a href="index.html"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;个人主页</a></li>
                        <li><a href="index.html"><span class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;个人设置</a></li>
                        <li><a href="index.html"><span class="glyphicon glyphicon-credit-card"></span>&nbsp;&nbsp;账户中心</a></li>
                        <li><a href="index.html"><span class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;我的收藏</a></li>
                    </ul>
                </li>
                <li>
                <a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
            </ul>
        </div>
        <!--导航-->

    </div>
</nav>
<!--导航-->