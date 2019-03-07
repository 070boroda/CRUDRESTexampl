<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Subject</title>
</head>
<body>
<h1>Please add NEW Subject</h1>
<c:url var="saveUrl" value="/subjectadd"/>
<form:form modelAttribute="subjectAttribute" method="POST"
           action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="subjectName">Subject:</form:label></td>
            <td><form:input path="subjectName"/></td>
        </tr>
    </table>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
