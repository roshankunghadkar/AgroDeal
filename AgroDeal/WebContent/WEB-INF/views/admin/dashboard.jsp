<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>

<style type="text/css">
	<%@include file= "../css/wrapper.css"%>
</style>
<style>
#logout{
	font-size:25px;
}
a{
	text-decoration:none;
}
</style>
</head>
<body>

<div class="wrapper">
			<div class="seat-box">
				<h1>Admin Dashboard: </h1><h4 style="color: red;">${requestScope.status}</h4><div id="logout"><a href="logout">Logout</a></div>
				<hr class="underLine"/>
				<div class="product-grid">
					<center>
						<br/>
						<br/>
						<br/>
						<br/>
						<a href="pendingProducts"><button class="button button1">Pending Products</button></a>
						<a href="activeProducts"><button class="button button1">Active Products</button></a>
						<a href="listOfUsers"><button class="button button1">Registered Users</button></a>
					</center>
				</div>
			</div>
</div>
</body>
</html>