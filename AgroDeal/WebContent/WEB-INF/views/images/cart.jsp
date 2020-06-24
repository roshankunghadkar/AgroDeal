<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
<h2>My Cart</h2><br/>

Product Name: ${sessionScope.product_details.prodName}<br/>
Product Price: ${sessionScope.product_details.prodPrice}<br/>

</body>
</html>