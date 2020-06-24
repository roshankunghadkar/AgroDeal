<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<style type="text/css">
	<%@include file= "../css/wrapper.css"%>
</style>
</head>
<body>
<%@include file="../header.jsp" %>
<div class="wrapper">
			<div class="seat-box">
				<h1>User Profile: </h1>
				<hr class="underLine"/>
				<div class="product-grid">
				<center>
								<b>User Name: </b>${sessionScope.user_details.name}<br/>
								<b>Email: </b>${sessionScope.user_details.email}<br/>
								<b>Mobile: </b>${sessionScope.user_details.mobile}<br/>
								<b>Address: </b>${sessionScope.user_details.address}<br/>
								<b>City: </b>${sessionScope.user_details.city}<br/>
								<a href="logout"><button class="button button1">Logout</button></a>
				</center>
				</div>
				</div>
			</div>
</div>
</body>
</html>