<%@ page import="pl.aguzovsk.servlets.ValidateService" %><%--
  Created by IntelliJ IDEA.
  User: aguzovsk
  Date: 23.07.18
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=ValidateService.getInstance()
        .delete(
                Integer.parseInt(
                        request.getParameter("userid")
                )
        )%>
</body>
</html>
