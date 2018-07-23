<%@ page import="pl.aguzovsk.servlets.ValidateService" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: aguzovsk
  Date: 23.07.18
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/create/created.jsp" method='post'>
    <label for='name'>Name: </label>
    <input type='text' id='name' name='name'>
    <label for='login'>Login: </label>
    <input type='text' id='login' name='login'>
    <label for='email'>Email: </label>
    <input type='text' id='email' name='email'>
    <input type='submit'>
</form>

</body>
</html>
