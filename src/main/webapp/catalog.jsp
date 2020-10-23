<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: rakhad
  Date: 10/18/20
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <title>Catalog</title>
</head>
<body>
<div class="container">
    <div style="display: flex; justify-content: space-between; align-items: baseline">
        <div>
            <form class="form mt-5" action="catalogs" method="post">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary mb-2">Search by name A-Z</button>
                </div>
            </form>
        </div>
        <div style="display: flex">
            <a href="cart" class="btn btn-link">Go to cart</a>
            <form action="logout" method="post">
                <button type="submit" class="btn btn-danger">Log out</button>
            </form>
        </div>
    </div>

    <div class="list-group mt-1">
        <c:forEach var="catalog" items="${catalogs}">
            <a href="products?catalog=${catalog.name}" class="list-group-item list-group-item-action">${catalog.name}</a>
        </c:forEach>
    </div>
</div>
</body>
</html>
