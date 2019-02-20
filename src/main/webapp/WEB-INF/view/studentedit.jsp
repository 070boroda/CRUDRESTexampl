<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Student</h1>
	<c:url var="urlSave" value="/studentedit?id=${studentAttribute.id}" />
	<form:form modelAtrribute="studentAttribute"
		commandName="studentAttribute" method="POST" action="${urlSave}">
		<table>
			<tr>
				<td><form:label path="id">id:</form:label></td>
				<td><form:input path="id" disabled="true" /></td>
			</tr>
			<tr>
				<td><form:label path="firstName">Last Name </form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="secondName">Second Name</form:label></td>
				<td><form:input path="secondName" /></td>
			</tr>
			 <tr>
                <td><form:label path="group.id">id:</form:label></td>
                <td><form:input path="group.id" disabled="true" /></td>
            </tr>
            <tr>
                <td><form:select path="group.id">
                <form:option value=""></form:option>
                <form:options items ="${grouplist}" itemLabel="groupName" itemValue="id"/>
                </form:select></td>               
            </tr>
		</table>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>
