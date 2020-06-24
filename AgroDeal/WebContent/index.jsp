<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="https://use.fontawesome.com/releases/v5.8.1/css/all.css" />" rel="stylesheet">
<style type="text/css">
	<%@include file= "../css/style.css"%>
</style>
</head>
<body>
<table height=100 width="100%" bgcolor="#065535">
		<tr>
			<div style="top:7%; left:5%;position:absolute;color:#00FF00;"><b>${sessionScope.user_details.name}</b></div>
			<div style="position: absolute; top: 7%; left:19%; transform: translate(-50%,-50%); background: #2f3640; 
							height: 25px; border-radius: 40px; padding: 10px;">
					<a href="/"  style=" color: #00ff00; float: right; width: 25px; height: 25px; border-radius: 50%; background: 
					#2f3640; display: flex; justify-content: center; align-items: center;">
							<i class="fas fa-tractor"></i>
					</a>
			</div>
			<div style="position: absolute; top: 7%; left:27%; transform: translate(-50%,-50%); background: #2f3640; 
							height: 25px; border-radius: 40px; padding: 10px;">
					<a href="user/profile"  style=" color: #00ff00; float: right; width: 25px; height: 25px; border-radius: 50%; background: 
					#2f3640; display: flex; justify-content: center; align-items: center;">     
					<i class="far fa-user-circle"></i>
			</a>
			</div>
			<div style="position: absolute; top: 7%; left:35%; transform: translate(-50%,-50%); background: #2f3640; 
							height: 25px; border-radius: 40px; padding: 10px;">
					<a href="product/regProduct"  style=" color: #00ff00; float: right; width: 25px; height: 25px; border-radius: 50%; background: 
					#2f3640; display: flex; justify-content: center; align-items: center;">
							<i class="fas fa-camera"></i>
					</a>
			</div>
			
			<div class="search-box" style="position: absolute; top: 7%; left:50%; transform: translate(-50%,-50%); background: #2f3640; 
							height: 25px; border-radius: 40px; padding: 10px;">
			<form action="#" method="get">
				<input class="search-txt" type=text name="search" placeholder="Search Your Product">
				
				<button class="search-btn" type="submit" name="submit" style="border:none;">
					<i class="fas fa-search"></i>
				</button>

			</form>
			</div>
			<div style="position: absolute; top: 7%; left:64.5%; transform: translate(-50%,-50%); background: #2f3640; 
							height: 25px; border-radius: 40px; padding: 10px;">
					<a href="user/activeAds?uid=${sessionScope.user_details.id}"  style=" color: #00ff00; float: right; width: 25px; height: 25px; border-radius: 50%; background: 
					#2f3640; display: flex; justify-content: center; align-items: center;">     
					<i class="fab fa-buysellads"></i>
			</a>
			</div>
			
			<div style="position: absolute; top: 7%; left:73%; transform: translate(-50%,-50%); background: #2f3640; 
							height: 25px; border-radius: 40px; padding: 10px;">
					<a href="order/getorders?id=${sessionScope.user_details.id}"  style=" color: #00ff00; float: right; width: 25px; height: 25px; border-radius: 50%; background: 
					#2f3640; display: flex; justify-content: center; align-items: center;">     
							<i class="fas fa-history"></i>
					</a>
			</div>
			<div style="position: absolute; top: 7%; left:80.5%; transform: translate(-50%,-50%); background: #2f3640; 
							height: 25px; border-radius: 40px; padding: 10px;">
					<a href="user/product-requests?id=${sessionScope.user_details.id}" class="notification" style=" color: #00ff00; float: right; width: 25px; height: 25px; border-radius: 50%; background: 
					#2f3640; display: flex; justify-content: center; align-items: center;">     
					<i class="fas fa-comments-dollar"></i>
					<span class="badge">2</span>
					</a>
			</div>
			<% if( session.isNew() ) { %>
    				<div style="position: absolute; top: 7%; left:87%; transform: translate(-50%,-50%); background: #2f3640; 
							height: 25px; border-radius: 40px; padding: 10px;">
					<a href="user/login"  style=" color: #00ff00; float: right; width: 25px; height: 25px; border-radius: 50%; background: 
					#2f3640; display: flex; justify-content: center; align-items: center;">     
					<i class="fas fa-sign-in-alt"></i>
					</a>
			</div>
			<% } else { %>
    				<div style="position: absolute; top: 7%; left:87%; transform: translate(-50%,-50%); background: #2f3640; 
							height: 25px; border-radius: 40px; padding: 10px;">
					<a href="user/logout"  style=" color: #00ff00; float: right; width: 25px; height: 25px; border-radius: 50%; background: 
					#2f3640; display: flex; justify-content: center; align-items: center;">     
					<i class="fas fa-sign-in-alt"></i>
					</a>
			</div>
			<% } %>
			
		</tr>
		<tr><b>
			<div style= "left:17.6%;position:absolute;top:76px; color:#00FF00;">Home</div>
			<div style= "left:25.4%;position:absolute;top:76px; color:#00FF00;">Profile</div>
			<div style= "left:32.5%;position:absolute;top:76px; color:#00FF00;">Sell Product</div>
			<div style= "left:62.8%;position:absolute;top:76px; color:#00FF00;">My Ads</div>
			<div style= "left:70.6%;position:absolute;top:76px; color:#00FF00;">My Orders</div>
			<div style= "left:78.6%;position:absolute;top:79px; color:#00FF00;">Requests</div>
			
			<% if( session.isNew() ) { %>
    				<div style= "left:85.5%;position:absolute;top:79px; color:#00FF00;">Login</div>
			<% } else { %>
    				<div style= "left:85.5%;position:absolute;top:79px; color:#00FF00;">Logout</div>
			<% } %>
			
			
			</b>

		</tr>
</div>
</table>
	
		<%
			String connectionURL = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "Roshan", "Roshan79");
			statement = connection.createStatement();
			String QueryString = "SELECT * from productss where status=1";
			rs = statement.executeQuery(QueryString);
		%>
		
	
		<div class="wrapper">
			<div class="seat-box">
				<h1>Products Nearby You : </h1><h4 style="color: red;">${requestScope.status}</h4>
				<hr class="underLine"/>
				<div class="product-grid">
					<%
							while (rs.next()) {
					%>
					<center>
						<div class="product">
						<h3><%=rs.getString(5)%></h3><br>
						<%=rs.getInt(6)%> Rs.<br>
						<h3>City: <%=rs.getString(2)%></h3><br>
						<a href="product/details?id=<%=rs.getInt(1)%>"><button class="button button1">Show Details</button></a>
						</div>
					</center>
					<% } %>

				</div>
			</div>
</div>	
			<%
	// close all the connections.
	rs.close();
	statement.close();
	connection.close();
	} 
	catch (Exception ex) 
	{
	%>
	</font>
	<font size="+3" color="red"></b>
	<%
		out.println("Unable to connect to database.");
	%>
	
</body>
</html>