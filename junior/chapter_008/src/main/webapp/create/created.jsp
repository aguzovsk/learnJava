<%@ page import="pl.aguzovsk.servlets.ValidateService" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: aguzovsk
  Date: 23.07.18
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%  String name = request.getParameter("name");
    String login= request.getParameter("login");
    String email= request.getParameter("email");
%>
<%= ValidateService.getInstance()
        .add(name, login, email, LocalDateTime.now()) ? "User created" : "error occured" %>
</body>
</html>
