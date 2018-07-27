<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%--
  Created by IntelliJ IDEA.
  User: aguzovsk
  Date: 23.07.18
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="border: 1p solid black;" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th>User ID</th>
        <th>User name</th>
        <th>User login</th>
        <th>User email</th>
        <th>User creationTime</th>
    </tr>
    <c:forEach items="${users}"  var="user">
        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.creationTime}"></c:out></td>
            <td><form action="${pageContext.request.contextPath}/edit" method="get">
                <button type='submit' name='id' value="${user.id}">Edit</button></form></td>
            <td><form action="${pageContext.request.contextPath}/delete" method="post">
                <button type='submit' name='userid' value="${user.id}">Delete</button></form></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
