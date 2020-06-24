<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Log In</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<style type="text/css">
	<%@include file= "../css/login.css"%>
</style>
</head>
<body>
  	<div class="header">
  		<h2>Admin Login</h2>
  		<h4 style="color: red;">${requestScope.mesg}</h4>
		<form method="post" modelAttribute="admin">
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
		</form>
	</div>
</body>
</html>