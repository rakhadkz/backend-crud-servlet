<%--
  Created by IntelliJ IDEA.
  User: rakhad
  Date: 10/20/20
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Congrats</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body>
    <%
        String created_at = "";
        String visit_time = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("session_created_at"))
                created_at = cookie.getValue();
            if (cookie.getName().equals("visit"))
                visit_time = cookie.getValue();

        }
    %>
<div class="container pt-5 text-center">
    <p class="display-4 mt-5">Congrats, Payment was successful!</p>
    <small class="text-muted">Your session was created: <%=created_at%> </small><br>
    <small class="text-muted">Your visit number: <%=visit_time%> </small><br>
    <a href="catalogs" class="btn btn-link">Return</a>
</div>
</body>
</html>
