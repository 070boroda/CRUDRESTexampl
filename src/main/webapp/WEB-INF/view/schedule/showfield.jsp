<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Schedule</title>
</head>
<c:url var="addUrl" value="/fieldadd" />
<body>
    <div align="center">
            <h1>Schedule
                <c:out value="${scheduleAttribute.day}"></c:out>
            group:
                <c:out value="${scheduleAttribute.group.groupName}"></c:out>
            </h1>
        <table border="1px">
            <tr>
                <th>id</th>
                <th>number lesson</th>
                <th>subject</th>
            </tr>
            <c:forEach var="field" items="${fieldlist}">
                <tr>
                    <c:url var="editUrl" value="/fieldedit?id=${field.id}" />
                    <c:url var="deleteUrl" value="/fielddelete?id=${field.id}" />
                    <td><c:out value="${field.id}"></c:out></td>
                    <td><c:out value="${field.numberLesson}"></c:out></td>
                    <td><c:out value="${field.subject.subjectName}"></c:out></td>
                    <td><a href="${editUrl}">Edit</a></td>
                    <td><a href="${deleteUrl}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="${addUrl}">Add new field</a> <a href="<%="index.jsp"%>">Go
            to start page</a>
    </div>
</html>