

<%--
  Created by IntelliJ IDEA.
  User: rakhad
  Date: 10/18/20
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Database" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<form action="clearCookie" method="post">
    <button type="submit">Clear Cart</button>
</form>
<%
    //Database database = new Database();
    Database database = new Database();
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie: cookies){
        if (cookie.getName().toLowerCase().contains("session"))
            continue;
        out.print("<p>" + cookie.getName() + " " + cookie.getValue() + "</p>");
    }
%>
</body>
</html>
