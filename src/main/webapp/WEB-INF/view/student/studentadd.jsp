<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Student</title>
</head>
<body>
<h1>Please add NEW STUDENT</h1>
<c:url var="saveUrl" value="/studentadd"/>
<form:form modelAttribute="attributeStudent" method="POST"
           action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="firstName">First Name:</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="secondName">Last Name</form:label></td>
            <td><form:input path="secondName"/></td>
        </tr>
        <tr>
            <td><form:select path="group.id">
                <form:option value="" label="--- Select ---"/>
                <form:options items="${grouplist}" itemLabel="groupName" itemValue="id"/>
            </form:select></td>
        </tr>
    </table>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
