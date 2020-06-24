<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${sessionScope.cart_details.prodName}</title>
</head>
<body>
<h2>Bargain Cart</h2><br/>
<form>
<table border=1>
<tr>
	<th>Product</th>
	<th>Price</th>
	<th>Quantity (in kg)</th>
	<th>Expected Price</th>
</tr>
<tr>
	<td>${sessionScope.cart_details.prodName}</td>
	<td>Rs. ${sessionScope.cart_details.prodPrice}</td>
	<td><input type="number" name="qty"></td>
	<td><textarea  name="remark" rows="3" cols="30"></textarea></td>
</tr>
</table>
<br/>
<br/>
<br/>
<br/>


<table border=1>
<tr>
	<th>Requestor Information</th><th></th>
</tr>
<tr>
	<td>Name:<td><input type="text" name="name" placeholder="Name"/></td>
</tr>
<tr>
	<td>Email:<td><input type="email" name="email" placeholder="Email"/></td>
</tr>
<tr>	
	<td>Phone Number:<td><input type="text" name="phone" placeholder="Phone"/></td>
</tr>
<tr>	
	<td>Address:<td><textarea  name="address" rows="3" cols="30" placeholder ="Address"></textarea></td>
</tr>
<tr>
	<td><td><button type="button">Send Request</button>
</tr>
</table>

</form>
</body>
</html>