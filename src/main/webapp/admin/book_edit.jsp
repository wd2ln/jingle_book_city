<%--
  Created by IntelliJ IDEA.
  User: vili
  Date: 2019/8/29
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>商品编辑</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
<div class="container-fluid">

    <jsp:include page="/admin/header.jsp"></jsp:include>

    <br><br>
    <form class="form-horizontal" action="book_update" method="post" enctype="multipart/form-data">
        <input type="text" name="bId" value="${g.bId }"/>
        <input type="hidden" name="bCover" value="${g.bCover }"/>
        <input type="hidden" name="bImage1" value="${g.bImage1 }"/>
        <input type="hidden" name="bimage2" value="${g.bImage2 }"/>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">名称</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bName" value="${g.bName}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">ISBN编号</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bIsbn"  value="${g.bIsbn}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">作者</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bAuthor"  value="${g.bAuthor}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">出版社</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bPublisher"  value="${g.bPublisher}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">封面图片</label>
            <div class="col-sm-6"><img src="../${g.bCover }" width="100" height="100"/>
                <input type="file" name="bCover"  id="input_file" required="required">推荐尺寸: 500 * 500
            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">详情图片1</label>
            <div class="col-sm-6"><img src="../${g.bImage1 }" width="100" height="100"/>
                <input type="file" name="bImage1"  id="input_file" required="required">推荐尺寸: 500 * 500
            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">详情图片2</label>
            <div class="col-sm-6"><img src="../${g.bImage2 }" width="100" height="100"/>
                <input type="file" name="bImage2"  id="input_file" required="required">推荐尺寸: 500 * 500
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">价格</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bPrice" value="${g.bPrice}">
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
<%--                <select class="form-control" id="select_topic" name="btId">--%>

<%--                    <c:forEach items="${bookTypes }" var="t">--%>
<%--                        <option <c:if test="${t.btId==g.btId }">selected="selected"</c:if> value="${t.btId }">${t.btName }</option>--%>
<%--                    </c:forEach>--%>

<%--                </select>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">库存</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bStock" value="${g.bStock}">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">介绍</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="bMark" value="${g.bMark}">
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
