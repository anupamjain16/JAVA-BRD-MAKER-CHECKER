<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="<c:url value="/resources/js/backdisable.js" />"></script>
<script src="<c:url value="/resources/js/backdisable.js" />"></script>
<title>Update</title>

</head>
<body style="text-align: center; background-image: url('https://i2.wp.com/bhubaneswarlive.com/wp-content/uploads/2016/11/Savin-NY-Website-Background-Web.jpg?fit=1920%2C1080&ssl=1');">
	
	

	

<nav class="navbar navbar-default" style="background-color:#D7CECE; font-size: 30px; font-family: sans-serif;">
		<div id="menu" class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand"> </a>
			</div>
			<ul class="nav navbar-nav">

				<li><a href="menu">Home</a></li>
				<li><a href="update">Update</a></li>
				 <li><a href="viewsingle">Search</a></li> 
				<li><a href="delete">Delete</a></li>
				<li><a href="logout">Logout</a></li>

			</ul>
		</div>
	</nav>

<form:form action="updatecustomer" modelAttribute="Customer" >
	 	<br>
		<br>
	 Code <form:input path="customerCode" required="required" />
		<form:errors path="customerCode" class="error" />
	 	<br>
		<br>
		
	<button type="submit">Submit</button>
	</form:form>
</body>
</html>