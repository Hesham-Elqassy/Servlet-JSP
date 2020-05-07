<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>



<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">


<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>


<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="JavaScript/JS-Proudcts-DB_JSP.js"></script>


</head>
<body>



<h3>${message}</h3>

	<div id="msg"></div>


	<input type="button" name="" value="ADD" onclick="showProductsAddForm()"
		style="color: black; padding: 8px 16px; text-align: center;; font-size: 12px; background-color: #3DFD86;">
		
		<form action="LogoutController" method="post">
		
		<input type="submit" name="action" value="Logout"
			style="color: white; padding: 8px 16px; text-align: center;; font-size: 12px; background-color: black; position: absolute; top: 0; right: 0;">
		
		</form>
		
		
		<form action="AdminUsersController" method="get">
		
		<input type="submit" name="" value="Users"
			style="color: white; padding: 8px 16px; text-align: center;; font-size: 12px; background-color: gray; ">
		
		</form>
		
		

<h3 style="align-items: center;
  justify-content: center; display: flex;" >All Products</h3>


	<form action="AdminProductsController" method="get">

		
		<table border="1" id="ptable" class="display">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Image</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Quantity </th>
					<th>Product Description</th>
					<th>Rate</th>
					<th>Actions</th>
				</tr>
			</thead>



			<tbody>
				<c:forEach items="${productsListForAdmin}" var="product">
					<tr>
						<td>${product.productId}</td>
						<td><img src="data:image/png;base64,${product.image}" width="60" height="100"/></td>
						<td>${product.productName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productQuantity}</td>
						<td>${product.productDescription}</td>
						<td>${product.rate}</td>
						
						<td><a style="color: red"
							href="${pageContext.request.contextPath}/AdminProductsController?action=DeleteProduct&pid=${product.productId}">Delete</a>

							|
							<button type="button" onclick="showProductsUpdateDiv()"
								style="background: #33B8FF" style="font:bold">Update</button>
							|
							<a style="color: green"
							href="${pageContext.request.contextPath}/AdminProductsController?action=ReviewOfProduct&pid=${product.productId}">Review</a>

                           </td>


					</tr>


				</c:forEach>

			</tbody>

		</table>

	</form>




	<form action="AdminProductsController" method="post" enctype="multipart/form-data">
		<div id="myProductsDiv" style="display: none;" border="1">

			<table>
				<tr id="pIdInput">
					<td>ID :</td>
					<td><input type="text" name="newProductId" id="editedid" readonly></td>
				</tr>
				<tr>
					<td>New Product Name :</td>
					<td><input type="text" name="newProductName" id="newProductName"></td>
				</tr>
				<tr>
					<td>New Product Price :</td>
					<td><input type="text" name="newProductPrice" id="newProductPrice"></td>
				</tr>
				<tr>
					<td>New Product Quantity :</td>
					<td><input type="text" name="newProductQuantaty"
						id="newProductQuantaty"></td>
				</tr>
				<tr>
					<td>New Product Description :</td>
					<td><input type="text" name="newProductDescription"
						id="newProductDescription"></td>
				</tr>
				
				<tr>
					<td>New Product Image :</td>
					<td><input type="file" name="newProductImage"
						id="newProductImage" required="required" enctype="multipart/form-data"></td>
				</tr>
				
				<tr>
					<td><input onclick="hideProductDiv()" type="submit" name="action"
						id="psaveBTN" style="display: none;" value="Save-Product"></td>
				</tr>

				<tr>
					<td><input onclick="hideProductDiv()" type="submit" name="action"
						id="paddBTN" style="display: none;" value="Add-Product"></td>
				</tr>


			</table>
		</div>
	</form>



</body>
</html>