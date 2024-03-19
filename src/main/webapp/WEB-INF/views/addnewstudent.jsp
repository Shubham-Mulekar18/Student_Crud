<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
<link href="<c:url value="/resources/CSS/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/JS/VALIDATION.js" />"></script>
</head>
<body>
<%@ include file="home.jsp" %>
<div class="form-div">
<center class="center">
<h2>Enter Student Details</h2>
<br>
<form action="savestd" method="POST">
<input type="text" id="name" name="name" value="" placeholder="Enter Name" onkeyup="validateName(this.value)"><br>
<span id="s"></span>
<br><br>
<input type="text" id="email" name="email" value="" placeholder="Enter Email" onkeyup="emailValidate(this.value)"><br>
<span id="e"></span>
<br><br>
<input type="text" id="contact" name="contact" value="" placeholder="Enter Contact" onkeyup="validateContact(this.value)"><br>
<span id="c"></span>
<br><br>
<input type="text" name="Per" value="" placeholder="Percentage"/><br><br><br>
<input type="text" id="std" name="std" value="" placeholder="Enter Standard" onkeyup="validateStd(this.value)"><br>
<span id="stand"></span>
<br><br>
<input type="submit" name="s" value="Add New Student" />
</form>
<br>
<h3>${m}</h3>
</center>
</div>
</body>
</html>