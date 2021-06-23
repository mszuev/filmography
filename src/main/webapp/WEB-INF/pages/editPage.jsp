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
    <c:if test="${empty obj.inventory_number}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty obj.inventory_number}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty obj.inventory_number}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty obj.inventory_number}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty obj.inventory_number}">
        <input type="hidden" name="id" value="${obj.id}">
    </c:if>

    <label for="inventory_number">Inventory Number</label>
    <input type="text" name="inventory_number" id="inventory_number" value="${obj.inventory_number}">

    <label for="serial">Serial</label>
    <input type="text" name="serial" id="serial" value="${obj.serial}">

    <label for="description">Description</label>
    <input type="text" name="description" id="description" value="${obj.description}">

    <c:if test="${empty obj.inventory_number}">
        <input type="submit" value="Add new object">
    </c:if>
    <c:if test="${!empty obj.inventory_number}">
        <input type="submit" value="Edit object">
    </c:if>
</form>
</body>
</html>