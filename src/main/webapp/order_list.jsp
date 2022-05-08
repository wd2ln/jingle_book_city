<%--
  Created by IntelliJ IDEA.
  User: vili
  Date: 2019/8/27
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>我的订单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
</head>
<body>







<!--header-->
<jsp:include page="header.jsp">
    <jsp:param name="flag" value="5"></jsp:param>
</jsp:include>
<!--//header-->


<!--cart-items-->
<div class="cart-items">
    <div class="container">



        <h2>我的订单</h2>

        <table class="table table-bordered table-hover">

            <tr>
                <th width="10%">ID</th>
                <th width="10%">总价</th>
                <th width="20%">商品详情</th>
                <th width="30%">收货信息</th>
                <th width="10%">订单状态</th>
                <th width="10%">支付方式</th>
                <th width="10%">下单时间</th>
            </tr>

            <c:forEach items="${orderList }" var="order">

                <tr>
                    <td><p>${order.oId }</p></td>
                    <td><p>${order.oTotal }</p></td>
                    <td>
                        <c:forEach items="${order.itemList }" var="item">
                            <p>${item.book.bName }(${item.oiPrice }) x ${item.oiAmount }</p>
                        </c:forEach>

                    </td>
                    <td>
                        <p>${order.oRealname }</p>
                        <p>${order.oPhone }</p>
                        <p>${order.oAddress }</p>
                    </td>
                    <td>
                        <p>
                            <c:if test="${order.oStatus==1 }"><span style="color:red;">未付款</span></c:if>
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
                    <td><p>${order.oDatetime }</p></td>
                </tr>

            </c:forEach>



        </table>




    </div>
</div>
<!--//cart-items-->






<!--footer-->
<jsp:include page="footer.jsp"></jsp:include>
<!--//footer-->


</body>
</html>
