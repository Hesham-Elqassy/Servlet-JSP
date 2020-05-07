<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>




<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">


<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>


<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="JavaScript/JS-UserOrders-JSP.js"></script>




</head>
<body>
	<h3>${message}</h3>
	<h3
		style="align-items: center; justify-content: center; display: flex;">Your
		Cart</h3>
	<form action="UserShoppingCartController" method="get">
		<table border="1" id="userOrdersTable" class="display">
			<thead>
				<tr>
					<th>ID</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Description</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userCartList}" var="product">
					<tr>
						<td>${product.productId}</td>
						<td>${product.productName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productDescription}</td>
						
						
						
						<td><a style="color: red"
							href="${pageContext.request.contextPath}/UserShoppingCartController?action=DeleteProduct&pid=${product.productId}">Delete</a>

							|
							<button type="button" onclick="showProductsUpdateDiv()"
								style="background: #33B8FF" style="font:bold">Update</button></td>
						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	<form action="UserShoppingCartController" method="get" enctype="multipart/form-data">
		<div id="myProductsDiv" style="display: none;" border="1">

			<table>
				<tr id="pIdInput">
					<td>ID :</td>
					<td><input type="text" name="newProductId" id="editedid" readonly></td>
				</tr>
				<tr>
					<td>New Product Name :</td>
					<td><input type="text" name="newProductName" id="newProductName" readonly></td>
				</tr>
				<tr>
					<td>New Product Price :</td>
					<td><input type="text" name="newProductPrice" id="newProductPrice" readonly></td>
				</tr>
				<tr>
					<td>Product Quantity :</td>
					<td><input type="text" name="newProductQuantaty"
						id="newProductQuantaty"></td>
				</tr>
				
				
				
				<tr>
					<td><input onclick="hideProductDiv()" type="submit" name="action"
						id="psaveBTN" style="display: none;" value="Save-Product"></td>
				</tr>

				
			</table>
		</div>
	</form>
	
	
	
	
	
	
	
	
	


</body>
</html>