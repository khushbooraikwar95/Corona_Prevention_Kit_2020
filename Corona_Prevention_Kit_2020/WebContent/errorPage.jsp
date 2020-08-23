<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Prevention Kit-Error</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
	<div>
		<h3>We regret the inconvenience, Please report it to the Admin, if problem persists.</h3>
		<c:if test="${errMsg != null }">
		<p><strong>${errMsg }</strong>
	</c:if>
	</div>
<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>