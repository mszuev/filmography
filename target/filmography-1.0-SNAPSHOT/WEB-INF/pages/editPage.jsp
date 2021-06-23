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
    <c:if test="${empty obj.title}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty obj.title}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty obj.title}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty obj.title}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty obj.title}">
        <input type="hidden" name="id" value="${obj.id}">
    </c:if>
    <label for="title">Title</label>
    <input type="text" name="title" id="title" value="${obj.title}">
    <label for="year">Year</label>
    <input type="text" name="year" id="year" value="${obj.year}">
    <label for="genre">Genre</label>
    <input type="text" name="genre" id="genre" value="${obj.genre}">
    <label for="watched">Watched</label>
    <input type="text" name="watched" id="watched" value="${obj.watched}">
    <c:if test="${empty obj.title}">
        <input type="submit" value="Add new film">
    </c:if>
    <c:if test="${!empty obj.title}">
        <input type="submit" value="Edit film">
    </c:if>
</form>
</body>
</html>