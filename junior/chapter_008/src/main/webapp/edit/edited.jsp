<%@ page import="pl.aguzovsk.servlets.ValidateService" %><%--
  Created by IntelliJ IDEA.
  User: aguzovsk
  Date: 23.07.18
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edited</title>
</head>
<body>
<%  int id = Integer.parseInt(request.getParameter("userid"));
    String name = request.getParameter("name");
    String login= request.getParameter("login");
    String email= request.getParameter("email"); %>
<%=ValidateService.getInstance().update(id, name, login, email) ? "user updated" : "error occurred"%>
</body>
</html>
