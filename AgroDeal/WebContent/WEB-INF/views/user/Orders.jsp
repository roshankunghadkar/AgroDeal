<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Requests</title>
<style type="text/css">
	<%@include file= "../css/wrapper.css"%>
</style>

</head>
<body>	
		<div class="wrapper">
			<div class="seat-box">
				<h1>My Orders </h1>
				<hr class="underLine"/>
				<div class="product-grid">
					<c:forEach var="r" items="${sessionScope.Order_Details}">
					<center>
						<div id="box" class="product">
								<h3><b>Order Details:</h3></b>
								<b>Product: </b>${r.buyingProducts.prodName}<br/>
								<b>Price: </b>${r.buyingProducts.prodPrice}<br/>
								<h3><b>Customer Details:</b></h3>
								<b>Name: </b>${r.buyer.name}<br/>
								<b>Mobile: </b>${r.buyer.mobile}<br/>
								<b>Address:</b><span id="align">${r.buyer.address}<br/>
										${r.buyer.city}<br/>
										${r.buyer.state}<br/>
										${r.buyer.pincode}<br/></span>
						</div>
					</center>
					</c:forEach>

				</div>
			</div>
		</div>
</body>
</html>