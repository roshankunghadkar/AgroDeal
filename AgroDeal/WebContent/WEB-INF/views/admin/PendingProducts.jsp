<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending Products</title>

<style type="text/css">
	<%@include file= "../css/wrapper.css"%>
</style>

</head>
<body>

<div class="wrapper">
			<div class="seat-box">
				<h1>Pending Products: </h1><h4 style="color: red;">${requestScope.status}</h4>
				<hr class="underLine"/>
				<div class="product-grid">
					<c:forEach var="p" items="${requestScope.product_list}">
					<center>
						<div class="product">
						<h3><b>Product Name: </b>${p.prodName}</h3>
						<h3><b>Price: </b>  Rs. ${p.prodPrice}</h3>
						<h3><b>Seller Name: </b>${p.seller.name}</h3>
						<h3><b>Seller Mobile: </b>${p.seller.mobile}</h3>
						<h3><b>Seller Address: </b>${p.seller.address}</h3>
						<h3>City: ${p.city}</h3>
						<a href="update?id=${p.id}"><button class="button button1">Activate</button></a>
						<a href="delete?id=${p.id}"><button class="button button2">Delete</button></a>
						</div>
					</center>
					</c:forEach>
				</div>
			</div>
</div>
</body>
</html>