<%@ page import="pl.aguzovsk.servlets.User" %>
<%@ page import="pl.aguzovsk.servlets.ValidateService" %><%--
  Created by IntelliJ IDEA.
  User: aguzovsk
  Date: 23.07.18
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    <div style="display: none;"><% int id =Integer.parseInt(request.getParameter("id"));%>
    <% User user = ValidateService.getInstance().findById(id); %></div>
    <form action="<%=request.getContextPath()%>/edit/edited.jsp" method='post'>
        <label for='name'>Name: </label>
        <input type='text' id='name' name='name' value='<%=user.getName()%>'>
        <label for='login'>Login: </label>
        <input type='text' id='login' name='login' value='<%=user.getLogin()%>'>
        <label for='email'>Email: </label>
        <input type='text' id='email' name='email' value='<%=user.getEmail()%>'>
        <input type='hidden' name='userid' value='<%=user.getId()%>'>
        <input type='submit'>
    </form>
</body>
</html>
