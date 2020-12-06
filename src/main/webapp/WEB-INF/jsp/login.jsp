<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<link href="<c:out value="/css/login.css"/>" rel="stylsheet" />
<script src="<c:url value="/resources/js/backdisable.js" />"></script>

</head>
<body onload='document.loginForm.username.focus();'
	style="text-align: center; background-image: url('https://i2.wp.com/bhubaneswarlive.com/wp-content/uploads/2016/11/Savin-NY-Website-Background-Web.jpg?fit=1920%2C1080&ssl=1');">



	<div id="login-box"
		style="width: 300px; padding: 20px; margin: 100px auto; background: #fff; -webkit-border-radius: 2px; -moz-border-radius: 2px; border: 1px solid #000; color: black; border-style: dotted;">

		<h2>Login</h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>

		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='j_spring_security_check' />" method='POST'>

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='j_username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='j_password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>

</body>
</html>
