<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit List</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<nav>
<a href="homepage">Go to Home Page</a>
</nav>


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
			<br/>
			
			<p>
			<strong>Total Amount : </strong>
			<span>${totalAmt }</span>
			</p>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${msg != null }">
		<p><strong>${msg }</strong></p>
	</c:if>
	
	<nav>
	<a href="placeorder">Place Order</a>
	</nav>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>