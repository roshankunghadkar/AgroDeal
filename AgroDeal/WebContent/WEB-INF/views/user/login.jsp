<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Log In</title>

<style type="text/css">
	<%@include file= "../css/login.css"%>
</style>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
</head>
<body background="agro.jpg">
	<%@include file="../header.jsp" %>
  	<div class="header">
  		<h2>Customer Login</h2>
  		<h4 style="color: red;">${requestScope.mesg}</h4>
		<form method="post" modelAttribute="user">
			<div class="input-group">
				<i class="far fa-user"></i>
				<input type="text" placeholder="Username" name="em" required>
			</div>
			<div class="input-group">
				<i class="fas fa-key"></i>
				<input type="password" placeholder="Password" name="pass" required>
			</div>
			<div class="input-group">
				<button type="submit" class="btn" value="Login">Login</button>
			</div>
			<div class="last">
				<p>
					<center><a href="register">Don't Have an Account?</a></center>
				</p>
				<p>
					<center><a href="../admin/login">Admin Login</a></center>
				</p>
			</div>
		</form>
	</div>
</body>
</html>