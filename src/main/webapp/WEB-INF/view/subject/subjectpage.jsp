<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subject Page</title>
</head>
<c:url var="addUrl" value="/subjectadd" />
<body>
	<div align="center">
		<table border="1px">
			<tr>
				<th>Id</th>
				<th>Subject</th>
			</tr>
			<c:forEach var="subject" items="${subjectslist}">
				<tr>
					<c:url var="editUrl" value="/subjectedit?id=${subject.id}" />
					<c:url var="deleteUrl" value="/subjectdelete?id=${subject.id}" />
					<td><c:out value="${subject.id}"></c:out>
					<td><c:out value="${subject.subjectName}"></c:out>
					<td><a href="${editUrl}">Edit</a></td>
					<td><a href="${deleteUrl}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<p><a href="${addUrl}">Add new Subject</a></p> 
		<p><a href="<%="index.jsp"%>">Go
			to start page</a></p>
	</div>
</body>
</html>
