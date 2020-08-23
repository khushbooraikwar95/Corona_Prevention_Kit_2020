<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Prevention Kit List</title>
</head>
<body>
	<jsp:include page="AdminUserLogin.jsp" />
	
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
					<th>Actions</th>
				</tr>
				<c:forEach items="${productMaster }" var="pm">
					<tr>
						<td>${pm.id }</td>
						<td>${pm.productDescription }</td>
						<td>${pm.productName }</td>
						<td>${pm.cost }</td>
						<td>
							<a href="deleteProd?id=${pm.id }">DELETE</a>
							<span>|</span>
							<a href="editProd?id=${pm.id }">EDIT</a>
						</td>
					</tr> 
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${msg != null }">
		<p><strong>${msg }</strong></p>
	</c:if>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>