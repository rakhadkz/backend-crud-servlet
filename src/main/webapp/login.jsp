<%--
  Created by IntelliJ IDEA.
  User: rakhad
  Date: 10/18/20
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <title>Login</title>
</head>
<body>
<div class="main">
    <p class="sign" align="center">Sign in</p>

    <form class="form1" method="post" action="login">
        <input class="un " name="login" type="text" align="center" placeholder="Login" required>
        <input class="pass" type="password" name="password" align="center" placeholder="Password" required>
        <input type="submit" class="submit" align="center" value="Sign in"/>
    </form>
</div>
</body>
</html>
