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

<script type="text/javascript" src="JavaScript/JS-UserDashBord-JSP.js"></script>





</head>
<body>



	<form action="UsersInfoController" method="get">

		<input type="submit" name="openUserInfo" value="Your-Info"
			style="color: white; padding: 8px 16px; text-align: center;; font-size: 12px; background-color: black; top: 0; right: 0;">
	</form>



<h3 style="align-items: center;
  justify-content: center; display: flex;" >All Products</h3>


	<form action="ProductController" method="get">


		<table border="1" id="usersDashBordTable" class="display">

			<thead>
				<tr>
					<th>ID</th>
					<th>Product Image</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Description</th>
					<th>Product rate</th>
					<th>Product comment</th>

				</tr>
			</thead>


			<tbody>

				<c:forEach items="${productsList}" var="product">
					<tr>
						<td>${product.productId}</td>
						<td>${product.image}</td>
						<td>${product.productName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productDescription}</td>
						<td>${product.rate}</td>
						<td>${product.comment}</td>
						<td>
						<a style="color: red"
							href="${pageContext.request.contextPath}/ProductController?action=AddtoCart&pid=${product.productId}&pname=${product.productName}&pprice=${product.productPrice}">Add To Cart</a>
						    |
						    <button type="button" onclick="showRateDiv()"
								style="background: #33B8FF" style="font:bold">Add Comment</button></td>
						
						
						</td>

					</tr>


				</c:forEach>


			</tbody>
		</table>
		
		
		
		

	</form>










<form action="ProductController" method="get">
		<div id="productRateDiv" style="display: none;" border="1">

			<table>
			
			    <tr>
					
					<td><input type="text" name="productID" id="productID" style="display: none"></td>
				</tr>  
				<tr id="IdInput">
					<td>Name</td>
					<td><input type="text" name="productName" id="productName" readonly></td>
				</tr>
				<tr>
					<td>Rate (1 to 5)</td>
					<td><input type="text" name="productRate" id="productRate"></td>
				</tr>
				<tr>
					<td>Comment :</td>
					<td><input type="text" name="productComment" id="productComment"></td>
				</tr>
				
				<tr>
					<td><input  type="submit" name="action"
						id="saveBTN" value="Add"></td>
				</tr>

				


			</table>
		</div>
	</form>











<form action="UserShoppingCartController" method="get">

		<input type="submit" name="openUserShoppingCart" value="ShowCart"
			style="color: white; padding: 8px 16px; text-align: center;; font-size: 12px; background-color: black; top: 0; right: 0;">
	

</form>










</body>
</html>