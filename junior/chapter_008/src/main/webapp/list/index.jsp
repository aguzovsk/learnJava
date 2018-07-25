<%@ page import="pl.aguzovsk.servlets.User" %>
<%@ page import="pl.aguzovsk.servlets.DbStore" %><%--
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
    <% for (User user : DbStore.getInstance().findAll()) { %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getLogin()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getCreationTime()%></td>
        <td><form action="<%=request.getContextPath()%>/edit/index.jsp" method="get">
            <button type='submit' name='id' value="<%=user.getId()%>">Edit</button></form></td>
        <td><form action="<%=request.getContextPath()%>/delete" method="post">
            <button type='submit' name='userid' value="<%=user.getId()%>">Delete</button></form></td>
    </tr>
    <% } %>
</table>

</body>
</html>
