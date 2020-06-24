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
				<h1>Products Requests </h1>
				<hr class="underLine"/>
				<div class="product-grid">
					<c:forEach var="r" items="${sessionScope.RequestList}">
					<center>
						<div id="box" class="product">
								<h3><b>Product Details:</h3></b>
								<b>Product: </b>${r.product.prodName}<br/>
								<b>Price: </b>${r.product.prodPrice}<br/>
								<h3><b>Customer Details:</b></h3>
								<b>Name: </b>${r.sender.name}<br/>
								<b>Mobile: </b>${r.sender.mobile}<br/>
								<b>Address:</b><span id="align">${r.sender.address}<br/>
										${r.sender.city}<br/>
										${r.sender.state}<br/>
										${r.sender.pincode}<br/></span>
										<a href="../order/setorder?pid=${r.product.id}&bid=${r.sender.id}&sid=${sessionScope.user_details.id}&rid=${r.requestId}"><button class="button button1">Accept Request</button></a><br/><br/>
										<a href="../user/reject-request?rid=${r.requestId}"><button class="button button2">Reject Request</button></a>
						</div>
					</center>
					</c:forEach>

				</div>
			</div>
		</div>
</body>
</html>