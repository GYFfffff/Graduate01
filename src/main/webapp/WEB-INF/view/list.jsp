<%--
  Created by IntelliJ IDEA.
  User: GYF
  Date: 2017/1/14
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh" class="no-js">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>3D折纸面板展开页面特效</title>
    <link href='https://fonts.googleapis.com/css?family=Vollkorn|Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" type="text/css" href="/css/default.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- Resource style -->
    <link rel="stylesheet" href="/css/menu/pgwmenu.css">
    <link rel="stylesheet" href="/css/my.css">

    <script src="/js/jquery-3.1.0.min.js"></script>
    <script src="/js/modernizr.js"></script> <!-- Modernizr -->
    <script src="/js/main.js"></script> <!-- Resource jQuery -->
    <%--<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>--%>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/menu/pgwmenu.min.js"></script>
    <script src="/js/list.js"></script>
    <script src="/js/invitation.js"></script>
    <script type="text/javascript" src="/js/menu/menu.js"></script>
</head>
<body>
<header class="htmleaf-header">
    <h1>需求广场 <span>Hello Word.</span>
    </h1>
</header>

<ul class="pgwMenu">
    <li><a class="selected" href="#">登陆</a></li>
    <li><a href="#">个人空间</a></li>
    <%--<li><a href="javascript:;" id="screenLi">筛选</a></li>--%>
    <li class="screenCss">
        <ul>
            <li><a href="javascript:;" class="screenLi">筛选</a></li>
            <li class="hiddenScreen">
                <ul class="screenItem" hidden>
                    <li class="screenType"><a href="javascript:;" id="IOS">IOS</a></li>
                    <li class="screenType"><a href="javascript:;" id="AD">AD</a></li>
                    <li class="screenType"><a href="javascript:;" id="WINDOWS">WINDOWS</a></li>
                    <li class="screenType"><a href="javascript:;" id="Linux">Linux</a></li>
                </ul>
            </li>
        </ul>
    </li>

    <li class="screenCss">
        <ul>
            <li><a href="javascript:;" class="screenLi">排序</a></li>
            <li class="hiddenScreen">
                <ul class="screenItem" hidden>
                    <li class="screenType"><a href="javascript:;" id="">最新</a></li>
                    <li class="screenType"><a href="javascript:;" id="">最多关注</a></li>
                    <li class="screenType"><a href="javascript:;" id="">最多评论</a></li>
                </ul>
            </li>
        </ul>
    </li>    <li><a href="javascript:">关于</a></li>
    <li><a href="javascript:">关于</a></li>
    <li><a href="javascript:">关于</a></li>

</ul>

<main class="cd-main">
    <s:hidden id="currentPage" name="#pr.currentPage"/>
    <ul class="cd-gallery">
        <s:iterator value="#pr.dataList">
            <li class="cd-item">
                <s:a namespace="/" action="invitation_getItemById">
                    <s:param name="invitation.id" value="id"/>
                    <div>
                        <h2><s:property value="user.userName"/></h2>
                        <p><s:property value="content"/></p>
                        <b>View More</b>
                    </div>
                </s:a>
            </li>
        </s:iterator>
        <li class="cd-item" id="listMode" hidden>
            <a href="">
                <div>
                    <h2></h2>
                    <p></p>
                    <b>View More</b>
                </div>
            </a>
        </li>
        <%--标签成对出现显示结果才正常....--%>
        <li class="cd-item" hidden>
            <a href="">
                <div>
                    <h2></h2>
                    <p></p>
                    <b>View More</b>
                </div>
            </a>
        </li>
    </ul> <!-- .cd-gallery -->
</main> <!-- .cd-main -->

<div id='lodding' class='related' style='font-size: 40px; font-family: 微软雅黑' hidden>
    <h4>数据加载中....</h4>
</div>
<div class="related" style="font-size: 40px; font-family: 微软雅黑">
    <br/><br/>
    <h1>这里是页脚<br/>你可以在上一部分继续添加 Title Section</h1>
    <br/><br/>
</div>

<div class="cd-folding-panel">

    <div class="fold-left"></div> <!-- this is the left fold -->

    <div class="fold-right"></div> <!-- this is the right fold -->

    <div class="cd-fold-content">
        <!-- content will be loaded using javascript -->
    </div>

    <a class="cd-close" href="#0"></a>
</div> <!-- .cd-folding-panel -->


</body>
</html>
