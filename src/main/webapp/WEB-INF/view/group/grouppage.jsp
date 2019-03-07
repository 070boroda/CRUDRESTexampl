<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Group Page</title>
</head>
<c:url var="addUrl" value="/groupadd"/>
<body>
<div align="center">
    <table border="1px">
        <tr>
            <th>Id</th>
            <th>number of group</th>
        </tr>
        <c:forEach var="group" items="${groupslist}">
            <tr>
                <c:url var="editUrl" value="/groupedit?id=${group.id}"/>
                <c:url var="deleteUrl" value="/groupdelete?id=${group.id}"/>
                <td><c:out value="${group.id}"></c:out>
                <td><c:out value="${group.groupName}"></c:out>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="${addUrl}">Add new Group</a></p>
    <p><a href="<%="index.jsp"%>">Go
        to start page</a></p>
</div>
</body>
</html>
