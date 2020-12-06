<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User REGISTRATION FORM</title>
<script src="<c:url value="/resources/js/backdisable.js" />"></script>

<style>
.error {
	color: red;
}
</style>


<a href="logout" style="text-align: right; font-size: 30px ;font-weight: 60px">LOGOUT</a>
<h1 style="font-size: 30px;text-decoration: underline;">User Form</h1>
</head>
<body style="text-align: center; background-image: url('https://i2.wp.com/bhubaneswarlive.com/wp-content/uploads/2016/11/Savin-NY-Website-Background-Web.jpg?fit=1920%2C1080&ssl=1');
background-color:#FAFAD2 ;width: 30%; float: left; border: 2px solid black;">

<form:form action="processform" modelAttribute="User">
	 	
	 	<br>
		<br>
	 	
	 	User Name:	<form:input path="userName" />
	 	<form:errors path="userName" class="error" />
		
		<br>
		<br>
		<br>
		<br>
		
		Password:<form:input path="password" />
		<form:errors path="password" class="error" />

		<br>
		<br>
		<br>
		<br>
		
		
 		Profile: <form:input path="profile" />
				<form:errors path="profile" class="error"/> 


<br>
		<br>
		
		<button type="submit">Submit</button>
	
		<br>
		<br>
		

	</form:form>



</body>
</html>