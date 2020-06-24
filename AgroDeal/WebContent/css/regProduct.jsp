<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="header">
		<h2>Sale</h2>
		
  <sf:form method="post" modelAttribute="product">
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
		<button type="submit"  value="regProduct">Add Product</button>
		</div>
	</sf:form>
</div>
</body>
</html>


<div class="header">
		<h2>Sale</h2>
		
  <form method="post" action="product-upload.php" enctype="multipart/form-data">
  	<div class="input-group">
		<label>Product Name</label><br>
  	  <input type="text" name="prod_name">
  	</div>
  	<div class="input-group">
		<label>Product Price</label><br>
  	  <input type="text" name="prod_price">
  	</div>
  	<div class="input-group">
		<label>Product Description</label><br>
  	  <input type="text" name="prod_desc">
  	</div>
		<div class="input-group">
		<label>City</label><br>
  	  <input type="text" name="city">
  	</div>
		<div class="input-group">
		<label>Upload Image:</label><br><br>
  	  <input type="file" name="prod_image">
  	</div>
		<?php
        if($uploadOk==1) {
					echo "Product Added Succeffuly";
				}

		?>
		<div class="input-group">
  	<button type="submit" class="btn" name="reg_user">Add Product</button>
		</div>
</div>