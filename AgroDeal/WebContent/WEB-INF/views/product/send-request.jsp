<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${sessionScope.prod_details.prodName}</title>
</head>
<body>
<h2>Send Request</h2><br/>

Product Name: ${sessionScope.prod_details.prodName}<br/>
Price: ${sessionScope.prod_details.prodPrice}<br/>
<form method="post" modelAttribute="request">
  	<input  type="hidden" value="${sessionScope.user_details.id}" name="rid" readonly>
  	<input  type="hidden" value="${sessionScope.prod_details.id}" name="pid" readonly>
	Quantity (in kg): <input type="number" name="quanity" placeholder="Quantity"><br/>
	Address:<textarea  name="address" rows="3" cols="30" placeholder ="Address"></textarea><br/>
	PinCode:<input type="text" name="pincode" placeholder="Pincode"><br/>
	Mobile:<input type="text" name="mobile" placeholder="Mobile Number"><br/>
	<button type="submit">Send request</button>
</form>
</body>
</html>