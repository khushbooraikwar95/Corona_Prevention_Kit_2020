<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit-Add New Product(Admin)</title>
</head>
<body>
<jsp:include page="AdminUserLogin.jsp"/>
<hr/>

<!-- <form action="newproduct" method="post">
		<div>
			<div><button>Add new</button></div>
		</div>
</form> -->

<h3>${isNew?'Add new product':'Edit product' }</h3>
<form action="${isNew?'insertproduct':'saveproduct' }" method="post">
		<div>
			<label>Product Id</label>
			<input type="number" name="id" value="${productMaster.id}" required ${isNew?'':'readonly' }/>
		</div>
		<br/>	
		<div>
			<label>Product Name</label>
			<input type="text" name="productName" value="${productMaster.productName }" required />
		</div>	
		<br/>
		<div>
			<label>Product Description</label>
			<input type="text" name="productDescription" value="${productMaster.productDescription }" required />
		</div>
		<br/>	
		<div>
			<label>Product Cost</label>
			<input type="text" name="cost" value="${productMaster.cost }" required />
		</div>	
			<br/>
		
		<button>SAVE</button>		
	</form>


<hr/>	
	<jsp:include page="footer.jsp"/>
</body>
</html>