<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<jsp:include page="header.jsp"/>
<body>
<hr/>
	
	<c:if test="${loginsuccess != true}">
	<h2>Admin Login</h2>
	<c:if test="${msg != null }">
		<p><strong style="color: red;">${msg }</strong></p>
	</c:if>
	<form action="login" >
		<div>
			<div><label for="loginid">Enter login Id</label> </div>
			<div><input type="text" id="loginid" name="loginid" required /> </div>
		</div>
		<br/>
		<div>
			<div><label for="password">Enter password</label> </div>
			<div><input type="text" id="password" name="password" required /> </div>
		</div>
		<div>
		<br/>
			<div><input type="submit" value="Login"> </div>
		</div>
	</form>
	</c:if>
	
	<c:if test="${loginsuccess==true}">
	<h2>You are now an admin!</h2>
	<nav>
	<a href="listOfproductsAdmin">Product List</a>
	<span>|</span>
	<a href="addproduct">Add New Product</a>
	<span>|</span>
	<a href="logout">Logout</a>
	</nav>
	<c:if test="${msg != null }">
		<p><strong style="color: blue;">${msg }</strong></p>
	</c:if>
	</c:if>
</div>
<hr/>
</body>
</html>