<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Prevention Kit-Order Summary(user)</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<h3 style="text-align:center">Order summary</h3>

<nav>
<a href="homepage">Want to go Home Page?</a>
</nav>
<br/>
<table>
<tr>
<div><b>Visitor Name: </b><span style="color:blue">${visitorprof.userName}</span></div>
<div><b>Email: </b><span style="color:blue">${visitorprof.emailid}</span></div>
<div><b>Contact: </b><span style="color:blue">${visitorprof.contact}</span></div>
<br/>
<b>Delivery Address</b>
<address style="color:blue">${visitorprof.flatno}, ${visitorprof.street}, ${visitorprof.area}</address>
<address style="color:blue">${visitorprof.city} . ${visitorprof.state}</address>
<hr/>
</tr>
</table>


<%-- <h4>Delivery Address</h4>
<address>${visitorprof.flatno}, ${visitorprof.street}, ${visitorprof.area}</address>
<address>${visitorprof.city} . ${visitorprof.state}</address> --%>
<hr/>
<c:choose>
		<c:when test="${selectedProductsList == null || selectedProductsList.isEmpty() }">
			<p>No products were selected</p>
		</c:when>
		<c:otherwise>
		<h3>Products added to cart by you!!</h3>
		<hr/>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>Description</th>
					<th>Name</th>
					<th>MRP</th>
					<th>Required Quantity</th>
					<th>Total Cost</th>
				</tr>
				<c:forEach items="${selectedProductsList }" var="pm" varStatus="products">
					<tr>
						<td>${pm.productDescription }</td>
						<td>${pm.productName }</td>
						<td>${pm.cost }</td>
						<td>${pm.reqQuantity }</td>
						<td>${pm.totalCost }</td>
					</tr> 
				</c:forEach>
			</table>
			<br/>
			<p>
			<strong>Total Amount : </strong>
			<span>${totalAmt }</span>
			</p>
		</c:otherwise>
	</c:choose>
<hr/>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>