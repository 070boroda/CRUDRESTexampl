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
    <h1>Choose day and group for show schedule</h1>
        <c:url var="chooseUrl" value="/schedulechoose" />
        <form:form modelAttribute="scheduleAttribute" method="POST" action="${chooseUrl}">
        
                <form:select path="group.id">
                  <form:option value="" label="--- Select ---"/>
                  <form:options items ="${grouplist}" itemLabel="groupName" itemValue="id"/>
                </form:select>
                
                <form:select path="day">
                  <form:option value="" label="--- Select ---"/>
                  <form:options items ="${daylist}" itemLabel="value" 
                  itemValue="value"/>
                </form:select>
        <input type="submit" value="Find"/>
        </form:form>
    </div>
</body>
</html>