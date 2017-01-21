<%--
  Created by IntelliJ IDEA.
  User: GYF
  Date: 2017/1/16
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

<%--    <link rel="stylesheet" href="/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="/css/style.css"> <!-- Resource style -->--%>
    <link rel="stylesheet" href="/css/my.css">
    <link href="/css/bootstrap.min.css"  rel="stylesheet">
    <script src="/js/modernizr.js"></script> <!-- Modernizr -->
    <script src="/js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script src="/js/main.js"></script> <!-- Resource jQuery -->
    <script src="/js/invitation.js"></script>

    <title>3D Folding Panel</title>
</head>
<body>
<div class="cd-fold-content">
    <h2><s:property value="#invitation.user.userName"/> </h2>
    <div>
        <em><s:date name="#invitation.createDate" format="yyyy-MM-dd hh:mm:ss"/></em>
        <em style="float:right"><s:property value="#invitation.type.name"/></em>
    </div>
    <p>
        <s:property value="#invitation.content"/>
    </p>

    <div class="p-min">
        <p>
            <a href="#">
                评论(<s:property value="#invitation.comments.size"/>)
            </a>
            &nbsp;&nbsp;
            <a href="#">
                关注(<s:property value="#invitation.attentionUsers.size"/>)
            </a>
        </p>
    </div>
    <div style="width: 80%; margin: auto ">
        <s:form namespace="/" action="commentAction_save">
        <textarea class="form-control" rows="3"></textarea>
        </s:form>
    </div>
    <hr/>
    <s:iterator value="#invitation.comments">
        <div>
            <h4><s:property value="user.userName"/></h4>
            <h6><s:date name="createTime" format="yyyy-MM-dd hh:mm:ss"/> <s:property value="type"/> </h6>
            <br/>

            <s:if test="reComment.id != null">
                @<s:property value="reComment.user.userName"/>:
            </s:if>
            <s:property value="context"/>
            <br/><br/>
            <s:a namespace="/" action="#">
                回复
            </s:a>
            <br/><br/>
        </div>
    </s:iterator>

</div>
</body>
</html>
