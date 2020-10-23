

<%--
  Created by IntelliJ IDEA.
  User: rakhad
  Date: 10/18/20
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body>
<%
    if (request.getAttribute("products") == null)
        out.print("<p class='display-4 text-center mt-5' >No items</p>");
%>
<div class="container">
    <p class="display-4 text-center mt-5">Shopping cart</p>
    <div class="list-group mt-5">

        <c:forEach var="product" items="${products}">
            <form action="delete" method="post">
                <input type="hidden" name="item" value="${product.id}">
                <button type="submit" class="list-group-item d-flex justify-content-between align-items-center list-group-item-action">${product.name}
                    <span class="badge badge-primary badge-pill">${product.price} тг</span>
                </button>
            </form>
        </c:forEach>
    </div>
    <div>
        <p>Total price: <b><%=request.getAttribute("total")%> тг</b></p>
        <form action="finish" method="post">
            <button type="submit" class="btn btn-success">Confirm</button>
        </form>
        <form action="clearCookie" method="post">
            <button type="submit" class="btn btn-danger">Clear Cart</button>
        </form>
    </div>
</div>

</body>
</html>
