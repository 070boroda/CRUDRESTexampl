<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Group Edit</title>
</head>
<body>
	<h1>Edit Student</h1>
	<c:url var="urlSave" value="/groupedit?id=${groupAttribute.id}" />
	<form:form modelAtrribute="groupAttribute"
		commandName="groupAttribute" method="POST" action="${urlSave}">
		<table>
			<tr>
				<td><form:label path="id">id:</form:label></td>
				<td><form:input path="id" disabled="true" /></td>
			</tr>
			<tr>
				<td><form:label path="groupName">Group Name </form:label></td>
				<td><form:input path="groupName" /></td>
			</tr>
		</table>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>
