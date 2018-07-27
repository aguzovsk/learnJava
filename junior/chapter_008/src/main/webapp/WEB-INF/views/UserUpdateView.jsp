<%--
  Created by IntelliJ IDEA.
  User: aguzovsk
  Date: 26.07.18
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/edit" method='post'>
    <label for='name'>Name: </label>
    <input type='text' id='name' name='name' value='${user.name}'>
    <label for='login'>Login: </label>
    <input type='text' id='login' name='login' value='${user.login}'>
    <label for='email'>Email: </label>
    <input type='text' id='email' name='email' value='${user.email}'>
    <input type='hidden' name='userid' value='${user.id}'>
    <input type='submit'>
</form>
</body>
</html>
