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

<script type="text/javascript" src="JavaScript/JS-UserOrders-JSP.js"></script>





</head>
<body>




<form action="UsersInfoController" method="get">

		<input type="submit" name="openUserInfo" value="Back TO Info"
			style="color: white; padding: 8px 16px; text-align: center;; font-size: 12px; background-color: black; top: 0; right: 0;">
	</form>



 <h3 style="align-items: center;
  justify-content: center; display: flex;" >Your Orders </h3>
 
 
<form action="UsersOrdesrListController" method="get">


						
	
<!-- 		ID: <input type="text" name="userIdForGetOrder" id="userIdForGetOrder"  > -->
						

		<div id="userOrdersDiv" >
		
		
		
		
		
		
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

				<c:forEach items="${userOrderProductsList}" var="product">
					<tr>
						<td>${product.productId}</td>
						<td>${product.productName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productDescription}</td>

					</tr>


				</c:forEach>


			</tbody>

		</table>
		
		</div>
		
		
		
		<br>
		
	
		
		
	
	
	
	<h3>Order Details</h3>
	
	
	
	<table border="1" id="userOrdersTable" class="display">
			<thead>
				<tr>
					<th>Order ID</th>
					<th>Product ID</th>
					<th>Quantity</th>
					<th>Total </th>
					<th>Date </th>
					

				</tr>
			</thead>


			<tbody>

				<c:forEach items="${userOrderInfoList}" var="order">
					<tr>
						<td>${order.id}</td>
						<td>${order.productid}</td>
						<td>${order.quantity}</td>
						<td>${order.total}</td>
						<td>${order.date}</td>
						

					</tr>


				</c:forEach>


			</tbody>

		</table>
	
	
		
		

	</form>






























<!-- <form action="UsersOrdesrListController" method="get"> -->


						
	
<!--  		ID: <input type="text" name="userIdForGetOrder" id="userIdForGetOrder"  >  -->
						

<!-- 		<div id="userOrdersDiv" > -->
		
		
		
		
<!-- 		</table> -->
		
<!-- 		<table border="1" id="userOrdersTable" class="display"> -->
<!-- 			<thead> -->
<!-- 				<tr> -->
<!-- 					<th>Order ID</th> -->
					
					
					
<!-- 				</tr> -->
<!-- 			</thead> -->


<!-- 			<tbody> -->
<%-- 				<c:forEach items="${productsIDsList}" var="x"> --%>
<!-- 					<tr> -->
<%-- 						<td>${x}</td> --%>
						
						
						
<!-- 					</tr> -->


<%-- 				</c:forEach> --%>

<!-- 			</tbody> -->

<!-- 		</table> -->
		
<!-- 		</div> -->

<!-- 	</form> -->








</body>
</html>