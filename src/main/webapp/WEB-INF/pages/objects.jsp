<%--
  Created by IntelliJ IDEA.
  User: mzuev
  Date: 24.05.2021
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Inventory</title>

    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>

</head>
<body>

<h2>Inventory objects</h2>
<table>
    <tr>
        <th>ID</th>
        <th>INVENTORY NUMBER</th>
        <th>SERIAL</th>
        <th>DESCRIPTION</th>

    </tr>
    <c:forEach var="object" items="${objectsList}">
        <tr>
            <td>${object.id}</td>
            <td>${object.inventory_number}</td>
            <td>${object.serial}</td>
            <td>${object.description}</td>
            <td>
                <a href="/edit/${object.id}">edit</a>
                <a href="/delete/${object.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new object</a>
</body>
</html>