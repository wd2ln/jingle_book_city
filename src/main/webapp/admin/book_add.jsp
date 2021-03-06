<%--
  Created by IntelliJ IDEA.
  User: vili
  Date: 2019/8/29
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品添加</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
<div class="container-fluid">

    <jsp:include page="header.jsp"></jsp:include>

    <br><br>
    <form class="form-horizontal" action="book_add" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">名称</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bName"  required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">ISBN编号</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bIsbn"  required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">作者</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bAuthor"  required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">出版社</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bPublisher"  required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">封面图片</label>
            <div class="col-sm-6">
                <input type="file" name="bCover"  id="input_file" required="required">推荐尺寸: 500 * 500
            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">详情图片1</label>
            <div class="col-sm-6">
                <input type="file" name="bImage1"  id="input_file" required="required">推荐尺寸: 500 * 500
            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">详情图片2</label>
            <div class="col-sm-6">
                <input type="file" name="bImage2"  id="input_file" required="required">推荐尺寸: 500 * 500
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">价格</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bPrice" >
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">类别</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="btId" >
            </div>
        </div>
<%--        <div class="form-group">--%>
<%--            <label for="select_topic" class="col-sm-1 control-label">类目</label>--%>
<%--            <div class="col-sm-6">--%>
<%--                <select class="form-control" id="select_topic" name="btid">--%>

<%--                    <c:forEach items="${bookTypes }" var="t">--%>
<%--                        <option value="${t.btId }">${t.btName }</option>--%>
<%--                    </c:forEach>--%>


<%--                </select>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">库存</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bStock" >
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">介绍</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bMark" >
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="submit" class="btn btn-success">提交保存</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
