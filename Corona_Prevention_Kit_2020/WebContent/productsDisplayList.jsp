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

<h3>
Welcome ${visitorprof.userName}
</h3>

<nav>
<a href="homepage">Go to Home Page</a>
</nav>
<hr/>
<h3>Choose your required items</h3>
	<c:choose>
		<c:when test="${productMaster == null || productMaster.isEmpty() }">
			<p>No products Avialable</p>
		</c:when>
		<c:otherwise>
			<table border="1" cellspacing="5px" cellpadding="5px">
				<tr>
					<th>ID#</th>
					<th>Description</th>
					<th>Name</th>
					<th>Cost</th>
					<th>Required Quantity</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${productMaster }" var="pm" varStatus="products">
					<tr>
						<td>${pm.id }</td>
						<td>${pm.productDescription }</td>
						<td>${pm.productName }</td>
						<td>${pm.cost }</td>
						<td><input type="number" id="${products.index+1 }" name="reqQuantity" value="${pm.reqQuantity}"></input> </td>
						<td>
						<a href='' onclick="this.href='additem?id=${pm.id}&reqQuantity='+document.getElementById('${products.index+1 }').value">Add To Cart</a>
						</td>
					</tr> 
				</c:forEach>
			</table>
			<br/>
			<br/>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${msg != null }">
		<p><strong>${msg }</strong></p>
	</c:if>
	
	<nav>
	<c:if test="${selectedProductsList != null }">
	<a href="showcart">Show cart</a>
	</c:if>
	</nav>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>