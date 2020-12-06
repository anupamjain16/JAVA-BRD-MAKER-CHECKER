<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script src="<c:url value="/resources/js/refresh.js" />"></script>
<script src="<c:url value="/resources/js/backdisable.js" />"></script>


<title>All customer</title>
</head>

<body style="background-color: aqua;">

	<div id = "refresh" style="float: right;">
	<table border=1 style="font-size: 20px;">
		<thead>
			<tr>
				<th>Customer Code</th>
				<th>Customer Name</th>
				<th>Email Address</th>
				<th>Contact Number</th>
				<th>Address</th>
				<th>Pincode</th>
				<th>State</th>
				<!-- <th>Registration Date</th> -->
				<th>Created By</th>
					
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${customer}" var="customer">
				<tr>

					<td><c:out value="${customer.customerCode}" /></td>
					<td><c:out value="${customer.customerName}" /></td>

					<td><c:out value="${customer.emailAddress}" /></td>
					<td><c:out value="${customer.contactNumber}" /></td>
					<td><c:out value="${customer.customerAddress}" /></td>
					<td><c:out value="${customer.customerPinCode}" /></td>
					<td><c:out value="${customer.state}" /></td>

					<%-- <td><c:out value="${customer.registrationDate}" /></td> --%>
					<td><c:out value="${customer.createdBy}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>