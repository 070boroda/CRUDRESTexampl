<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Group</title>
</head>
<body>
<h1>Please add NEW GROUP</h1>
<c:url var="saveUrl" value="/groupadd"/>
<form:form modelAttribute="groupAttribute" method="POST"
		   action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="groupName">Number of Group:</form:label></td>
			<td><form:input path="groupName"/></td>
		</tr>
	</table>
	<input type="submit" value="Save"/>
</form:form>
</body>
</html>
