<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
<%@ include file="home.jsp" %>
<center>
<h2>Student Details</h2>
<table border="3">

        <tr>
        <th>Roll_no</th>
        <th>Student_Name</th>
        <th>Student_Email</th>
        <th>Student_Contact</th>
        <th>Student_Per</th>
         <th>Student_Class</th>
        <th>Update</th>
        <th>Delete</th>
        </tr>
        
    <c:forEach  var="a" items="${m}">
    <tr>
    	<td>${a.getRno()}</td>
    	<td>${a.getName()}</td>
    	<td>${a.getEmail()}</td>
    	<td>${a.getContact()}</td>
    	<td>${a.getPer()}</td>
    	<td>${a.getStd()}</td>
    	<td><a href='up?rno=${a.getRno()}&name=${a.getName()}&email=${a.getEmail()}&contact=${a.getContact()}&per=${a.getPer()}&std=${a.getStd()}'>Update</a></td>
    	<td><a href='deleteStd?rno=${a.getRno()}'>Delete</a></td>
    </tr>
    
    </c:forEach>
</table>
</center>
</body>
</html>