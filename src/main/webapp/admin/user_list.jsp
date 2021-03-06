<%--
  Created by IntelliJ IDEA.
  User: vili
  Date: 2019/8/28
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>客户列表</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">






    <jsp:include page="header.jsp"></jsp:include>

    <div class="text-right"><a class="btn btn-warning" href="user_add.jsp">添加客户</a></div>
    <c:if test="${!empty msg }">
        <div class="alert alert-success">${msg }</div>
    </c:if>
    <c:if test="${!empty failMsg }">
        <div class="alert alert-danger">${failMsg }</div>
    </c:if>
    <br>
    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="5%">ID</th>
            <th width="10%">用户名</th>
            <th width="10%">收件人</th>
            <th width="10%">电话</th>
            <th width="10%">地址</th>
            <th width="12%">操作</th>
        </tr>


        <c:forEach items="${p.list }" var="u">
            <tr>
                <td><p>${u.uId }</p></td>
                <td><p>${u.uName }</p></td>
                <td><p>${u.uRealname }</p></td>
                <td><p>${u.uPhone }</p></td>
                <td><p>${u.uAddress }</p></td>
                <td>
                    <a class="btn btn-info" href="/admin/user_reset.jsp?uId=${u.uId }&uName=${u.uName }&uRealname=${u.uRealname }">重置密码</a>
                    <a class="btn btn-primary" href="/admin/user_edit_show?uId=${u.uId }">修改</a>
                    <a class="btn btn-danger" href="/admin/user_delete?uId=${u.uId }">删除</a>
                </td>
            </tr>
        </c:forEach>


    </table>

    <br>
    <jsp:include page="/page.jsp">
        <jsp:param value="user_list" name="url"/>
    </jsp:include>
    <br>
</div>
</body>
</html>