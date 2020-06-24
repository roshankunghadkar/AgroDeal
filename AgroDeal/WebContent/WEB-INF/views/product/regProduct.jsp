<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<style type="text/css">
	<%@include file= "../css/register.css"%>
</style>
</head>
<body>
<div class="header">
		<h2>Sale</h2>
	
  <sf:form method="post" modelAttribute="product">
  <div>
  	<input  type="hidden" value="${sessionScope.user_details.id}" name="id" readonly>
  </div>
  	<div class="input-group">
		<label>Product Name</label><br>
  	  <sf:input  path="prodName"/>
  	</div>
  	<div class="input-group">
		<label>Product Price</label><br>
  	  <sf:input  path="prodPrice"/>
  	</div>
  	<div class="input-group">
		<label>Product Description</label><br>
  	  <sf:input  path="prodDesc"/>
  	</div>
		<div class="input-group">
		<label>City</label><br>
  	  <sf:input path="city"/>
  	</div>
		<div class="input-group">
		<label>Upload Image:</label><br><br>
  	  <sf:input type="file" path="prodImg"/>
  	</div>
	<div class="input-group">
  		<button type="submit" class="btn" name="reg_product" value="Register">Add Product</button>
	</div>
	</sf:form>
</div>
</body>
</html>