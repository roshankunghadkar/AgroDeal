<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${sessionScope.product_details.prodName}</title>

<style type="text/css">
	<%@include file= "../css/wrapper.css"%>
</style>
</head>
<body>

<div class="wrapper">
			<div class="seat-box">
				<h1>Products Details: </h1>
				<hr class="underLine"/>
				<div class="product-grid">
				<center>
								<b>Product Name: </b>${sessionScope.product_details.prodName}<br/>
								<b>Description: </b>${sessionScope.product_details.prodDesc}<br/>
								<b>Product Price: </b>${sessionScope.product_details.prodPrice}<br/>
								<b>Seller Name: </b>${sessionScope.product_details.seller.name}<br/>
								<b>Seller Mobile: </b>${sessionScope.product_details.seller.mobile}<br/>
								<b>City: </b>${sessionScope.product_details.city}<br/>
								<a href="../request/send-request?pid=${sessionScope.product_details.id}&rid=${sessionScope.user_details.id}"><button type="submit" class="button button1">Send Request for Product</button></a>
				</center>
				</div>
				</div>
			</div>
</div>
</body>
</html>