<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Place Order(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>

<nav>
<a href="homepage">Go to Home Page</a>
</nav>

<h3>
Enter Delivery Address
</h3>

<form action ="confirmorder" method="post">
		<div>
			<div><label for="flatno">Flat No: </label> 
			<input type="text" id="flatno" name="flatno" value="${visitorprof.flatno}" required> </div>
		</div>
		<div>
			<div><label for="street">Street </label>
			<input type="text" id="street" name="street" value="${visitorprof.street }" required> </div>
		</div>
		<div>
			<div><label for="area">Area </label> 
			<input type="text" id="area" name="area" value="${visitorprof.area }" required> </div>
		</div>
		<div>
			<div><label for="city">City </label> 
			<input type="text" id="city" name="city" value="${visitorprof.city }" required> </div>
		</div>
		<div>
			<div><label for="state">State </label>
			<input type="text" id="state" name="state" value="${visitorprof.state }" required> </div>
		</div>
		
		<button>Confirm Order</button>
	</form>
		

<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>