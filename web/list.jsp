<%--
  Created by IntelliJ IDEA.
  User: Marko
  Date: 6/14/2018
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List of users</title>
</head>
<body>

<h1>List of users</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <c:forEach items="${list}" var="record">

        <tr>
            <td>${record.id }</td>
            <td>${record.username }</td>
            <td>${record.email }</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
