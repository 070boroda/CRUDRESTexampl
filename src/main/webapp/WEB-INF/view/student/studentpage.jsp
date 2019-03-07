<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<c:url var="addUrl" value="/studentadd"/>
<body>
<div align="center">
    <table border="1px">
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Second Name</th>
            <th>Number Group</th>
        </tr>
        <c:forEach var="student" items="${studentslist}">
            <tr>
                <c:url var="editUrl" value="/studentedit?id=${student.id}"/>
                <c:url var="deleteUrl" value="/studentdelete?id=${student.id}"/>
                <td><c:out value="${student.id}"></c:out></td>
                <td><c:out value="${student.firstName}"></c:out></td>
                <td><c:out value="${student.secondName}"></c:out></td>
                <td><c:out value="${student.group.groupName}"></c:out></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="${addUrl}">Add new student</a> <a href="<%="index.jsp"%>">Go
    to start page</a>
</div>
</body>
</html>
