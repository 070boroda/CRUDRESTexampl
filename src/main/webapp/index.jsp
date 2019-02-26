<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>University</title>

</head>
<body>

      <div align="center">
      <h2>Simple Login Web Application using JSP/Servlet</h2>
      
        <c:url value="/showallstudents" var="student" />
        <c:url value="/showallgroups" var="group" />
		<c:url value="/showallteachers" var="teacher" />
      
     
        <a href="${student}">Student</a><br>
        <a href="${group}">Group</a><br>
        <a href="">Subjects</a><br>
        <a href="${teacher}">Teachers</a><br>
        <a href="">Schedule</a><br>
     
      <a href="<%= request.getRequestURI() %>">Try Again</a>
	</div>
</body>
</html>
