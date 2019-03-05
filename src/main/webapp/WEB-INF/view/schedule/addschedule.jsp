<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chose schedule</title>
</head>
<body>
    <div align="center">
    <h1>Add schedule</h1>
        <c:url var="chooseUrl" value="/scheduleadd?day=${scheduleAttribute.day}&group.id=${scheduleAttribute.group.id}"/>
        <form:form modelAttribute="scheduleAttribute" method="POST" action="${chooseUrl}">
        
                <td><form:label path="day">Day</form:label></td>
                <td><form:input path="day" disabled="true" /></td>
                
                <td><form:label path="group.id">Group</form:label></td>
                <td><form:input path="group.groupName" disabled="true" /></td>

                <td>Number lesson :</td>
                <form:select path="numberLesson">
                  <form:option value="" label="--- Select ---"/>
                  <form:option value="1" label="1"/>
                  <form:option value="2" label="2"/>
                  <form:option value="3" label="3"/>
                  <form:option value="4" label="4"/>
                  <form:option value="5" label="5"/>
                </form:select>
                
                <td>Subject :</td>
                <form:select path="subject.id">
                  <form:option value="" label="--- Select ---"/>
                  <form:options items ="${subjectlist}" itemLabel="subjectName" 
                  itemValue="id"/>
                </form:select>
        <input type="submit" value="Add"/>
        </form:form>
    </div>
</body>
</html>