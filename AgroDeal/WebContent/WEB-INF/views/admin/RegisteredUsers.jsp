<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Users</title>
<style type="text/css">
	<%@include file= "../css/wrapper.css"%>
</style>
</head>
<body>
<div class="wrapper">
			<div class="seat-box">
				<h1>Registered Users: </h1>
				<hr class="underLine"/>
				<div class="product-grid">
					<c:forEach var="u" items="${requestScope.user_list}"></h1><h4 style="color: red;">${requestScope.removeStatus}</h4>
					<center>
						<div class="product">
						<h3><b>Name: </b>${u.name}</h3>
						<h3><b>Email: </b>${u.email}</h3>
						<h3><b>Mobile: </b>${u.mobile}</h3>
						<h3><b>Address: </b>${u.address}</h3>
						<h3>City: ${u.city}</h3>
						<a href="removeUser?uid=${u.id}"><button class="button button2">Delete User</button></a>
						</div>
					</center>
					</c:forEach>
				</div>
			</div>
</div>
</body>
</html>