<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style type="text/css">
	<%@include file= "../css/register.css"%>
</style>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
</head>
<body>
<div class="header">
		<h2>Register</h2>
		
  <sf:form method="post" modelAttribute="user">
  	<div class="input-group">
		<i class="far fa-user"></i>
  		<sf:input type="text" placeholder="Full Name" path="name"/>
  		<sf:errors path="name" />
  	</div>
  	<div class="input-group">
		<i class="fas fa-at"></i>
  		<sf:input type="email" placeholder="Email Id" path="email"/>
  		<sf:errors path="email" />
  	</div>
  	<div class="input-group">
		<i class="fas fa-key"></i>
  		<sf:input type="password" placeholder="Password" path="password"/>
  		<sf:errors path="password" />
  	</div>
	<div class="input-group">
		<i class="fas fa-mobile-alt"></i>
  		<sf:input type="text" placeholder="Mobile Number" path="mobile"/>
  		<sf:errors path="mobile" />
  	</div>
  	<div class="input-group">
		<i class="fas fa-city"></i>
  		<sf:input type="text" placeholder="Address" path="address" />
  		<sf:errors path="address" />
  	</div>
	<div class="input-group">
		<i class="fas fa-city"></i>
  		<sf:input type="text" placeholder="City" path="city" />
  		<sf:errors path="city" />
  	</div>
  	<div class="input-group">
		<i class="fas fa-home"></i>
  		<sf:input type="text" placeholder="State" path="state"/>
  	</div>
  	<div class="input-group">
		<i class="fas fa-city"></i>
  		<sf:input type="text" placeholder="Pincode" path="pincode"/>
  		<sf:errors path="pincode" />
  	</div>
  	<div class="input-group">
  		<button type="submit" class="btn" name="reg_user" value="Register">Register</button>
	</div>
	<div class="last">
  		<p>
  			<center><a href="login">Already a Member?</a><center>
		</p>
	</div>
</sf:form>
</div>

</body>
</html>