<%--
  Created by IntelliJ IDEA.
  User: vili
  Date: 2019/8/28
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>订单列表</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="header.jsp"></jsp:include>

    <br>
    <ul role="tablist" class="nav nav-tabs">
        <li <c:if test="${oStatus==1 }">class="active"</c:if> role="presentation"><a href="order_list?pageNumber=1&oStatus=1">全部订单</a></li>
        <li <c:if test="${oStatus==5 }">class="active"</c:if> role="presentation"><a href="order_list?pageNumber=1&oStatus=5">未付款</a></li>
        <li <c:if test="${oStatus==2 }">class="active"</c:if> role="presentation"><a href="order_list?pageNumber=1&oStatus=2">已付款</a></li>
        <li <c:if test="${oStatus==3 }">class="active"</c:if> role="presentation"><a href="order_list?pageNumber=1&oStatus=3">配送中</a></li>
        <li <c:if test="${oStatus==4 }">class="active"</c:if> role="presentation"><a href="order_list?pageNumber=1&oStatus=4">已完成</a></li>
    </ul>

    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="5%">ID</th>
            <th width="5%">总价</th>
            <th width="15%">商品详情</th>
            <th width="20%">收货信息</th>
            <th width="10%">订单状态</th>
            <th width="10%">支付方式</th>
            <th width="10%">下单用户</th>
            <th width="10%">下单时间</th>
            <th width="10%">操作</th>
        </tr>

        <c:forEach items="${p.list }" var="order">

            <tr>
                <td><p>${order.oId }</p></td>
              <td><p>${order.oTotal }</p></td>
                <td>
                    <c:forEach items="${order.itemList }" var="item">
                        <p>${item.book.bName }(${item.oiPrice }) x ${item.oiAmount}</p>
                    </c:forEach>
                </td>
                <td>
                    <p>${order.oRealname }</p>
                    <p>${order.oPhone }</p>
                    <p>${order.oAddress }</p>
                </td>
                <td>
                    <p>
                        <c:if test="${order.oStatus==2 }"><span style="color:red;">已付款</span></c:if>
                        <c:if test="${order.oStatus==3 }"><span style="color:green;">已发货</span></c:if>
                        <c:if test="${order.oStatus==4 }"><span style="color:black;">已完成</span></c:if>

                    </p>
                </td>
                <td>
                    <p>

                        <c:if test="${order.oPaytype==1 }">微信</c:if>
                        <c:if test="${order.oPaytype==2 }">支付宝</c:if>
                        <c:if test="${order.oPaytype==3 }">货到付款</c:if>

                    </p>
                </td>
                <td><p>${order.oRealname }</p></td>
                <td><p>${order.oDatetime }</p></td>
                <td>
                    <c:if test="${order.oStatus==2 }">
                        <a class="btn btn-success" href="order_status_change?oId=${order.oId}&oStatus=3">发货</a>
                    </c:if>
                    <c:if test="${order.oStatus==3 }">
                        <a class="btn btn-warning" href="order_status_change?oId=${order.oId}&oStatus=4">完成</a>
                    </c:if>
                    <a class="btn btn-danger" href="order_delete?oId=${order.oId}&oStatus=${oStatus}">删除</a>
                </td>
            </tr>
        </c:forEach>


    </table>

    <br>
    <jsp:include page="/page.jsp">
        <jsp:param value="/admin/order_list" name="url"/>
        <jsp:param value="&oStatus=${oStatus}" name="param"/>
    </jsp:include>
    <br>
</div>
</body>
</html>