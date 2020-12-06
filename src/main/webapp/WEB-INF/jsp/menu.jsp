<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page import="java.io.*, java.util.*"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="<c:url value="/resources/js/javascript.js" />"></script>
<script src="<c:url value="/resources/js/backdisable.js" />"></script>

<title>REGISTRATION FORM</title>
<link href="<c:out value="/resources/css/menu.css"/>" rel="stylsheet" />
</head>


<body
	style="text-align: center; background-image: url('https://i2.wp.com/bhubaneswarlive.com/wp-content/uploads/2016/11/Savin-NY-Website-Background-Web.jpg?fit=1920%2C1080&ssl=1');">
	<nav class="navbar navbar-default"
		style="background-color: #D7CECE; font-size: 30px; font-family: sans-serif;">
		<div id="menu" class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand"> </a>
			</div>
			<ul class="nav navbar-nav">

				<li><a href="menu" ACCESSKEY="H">Home</a></li>
				<li><a href="update" ACCESSKEY="U">Update</a></li>
				<li><a href="viewsingle" ACCESSKEY="S">Search</a></li>
				<li><a href="delete" ACCESSKEY="D">Delete</a></li>
				<li><a href="logout" ACCESSKEY="L">Logout</a></li>

			</ul>
		</div>
	</nav>

	<h1 style="text-align: centre; color: #6E6B6B">HELLO USER</h1>
	<h1 style="text-align: left; padding-left: 20px"></h1>

	<div id="refresh" style="float: right">
		<iframe width="950" height="600" name="Left"
			src="/finalbrdmaven/viewall"></iframe>
	</div>

	<div id="form"
		style="background-color: #FAFAD2; width: 30%; float: left; border: 2px solid black; margin-left: 30px; margin-top: 30px; text-align: centre;">

		<h3>Customer Form</h3>
		<hr>
		<form:form action="customerprocessform" modelAttribute="Customer"
			name="userForm">
	
	Code*:<form:input path="customerCode" name="customerCode" placeholder="Enter Your Code"  />
			<form:errors path="customerCode" cssclass="error" />
			<div id="codemsg"></div>

			<br>
			<br>
	 	
	Name*:<form:input path="customerName" name="customerName" placeholder="Enter Your Name"  />
			<form:errors path="customerName" cssClass="error" />
			<div id="namemsg"></div>
			<br>
			<br>
		
	Email*:<form:input path="emailAddress" name="emailAddress" placeholder="Enter Email" />
			<form:errors path="emailAddress" cssclass="error" />
			<div id="emailmsg"></div>

			<br>
			<br>
		
	Contact No* :	<form:input path="contactNumber" name="contactNumber" placeholder="Enter contact Number" />
			<form:errors path="contactNumber" cssclass="error" />
			<div id="contactnumbermsg"></div>
			<br>
			<br>
		
	Address* :<form:input path="customerAddress" name="customerAddress" placeholder="Enter Address "/>
			<form:errors path="customerAddress" cssclass="error" />
			<div id="addressmsg"></div>
			<br>
			<br>
 		
 	Pincode*:<form:input path="customerPinCode" name="customerPinCode" placeholder="Enter PinCode " />
			<form:errors path="customerPinCode" cssclass="error" />
			<div id="pincodemsg"></div>
			<br>
			<br>
 	
 	<!--------------------  List of States------------ -->
 	
 	State :<form:select path="State">
				<form:option value="" label="--SELECT--" />
				<form:options items="${numArray}" />
		</form:select>
			<form:errors path="State" class="error" />

			<button type="submit" onclick="return validation()">Submit</button>
		</form:form>
	</div>


</body>
</html>
