<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Student</title>
<link href="<c:url value="/resources/CSS/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/JS/VALIDATION.js" />"></script>
</head>
<body>
<%@ include file="home.jsp" %>
<div class="form-div">
<center class="center">
<h2>Enter Student Id</h2>
<form action="viewid" method="POST">
<input type="text" id="rno" name="rno" value="" placeholder="Enter Student Id" onkeyup="validateSearchId(this.value)"><br>
<span id="Id"></span>
<br>
<input type="submit" name="s" value="Search Student" />
</form>
</center>
</div>
<br><br>
<div class="center">
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