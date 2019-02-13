<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Added New Student</title>
</head>
<body>
	<h1>New student was create</h1>
	<c:url var="listUrl" value="/showallstudents" />
	<p>
		You have added new student
		<%= new java.util.Date() %></p>
	<a href="${listUrl}">Main List</a>
</body>
</html>