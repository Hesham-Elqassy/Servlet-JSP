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

<script type="text/javascript" src="JavaScript/JS-Customer-DB-JSP.js"></script>




</head>


<body>

<%-- <c:set var="sessionVal" value='${sessionScope["adminName"]}' /> --%>
<%--    <c:if test="${sessionVal == null}"> --%>
      
<%--       <c:redirect url="/LoginForm.jsp"/> --%>
     
<%--     </c:if> --%>

	<h3>${message}</h3>

	<div id="msg"></div>


	<input type="button" name="action" value="ADD" onclick="showAddForm()"
		style="color: black; padding: 8px 16px; text-align: center;; font-size: 12px; background-color: #3DFD86;">
		
		<form action="LogoutController" method="post">
		
		<input type="submit" name="action" value="Logout"
			style="color: white; padding: 8px 16px; text-align: center;; font-size: 12px; background-color: black; position: absolute; top: 0; right: 0;">
		
		</form>
		
		
		<form action="AdminProductsController" method="get">
		
		<input type="submit" name="" value="Products"
			style="color: white; padding: 8px 16px; text-align: center;; font-size: 12px; background-color: gray; ">
		
		</form>
		
<h3 style="align-items: center;
  justify-content: center; display: flex;" >All Users</h3>

	<form action="AdminUsersController" method="get">

		
		<table border="1" id="utable" class="display">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Password</th>
					<th>Admin Status</th>
					<th>Actions</th>
				</tr>
			</thead>



			<tbody>
				<c:forEach items="${list}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.adminstatus}</td>
						<td><a style="color: red"
							href="${pageContext.request.contextPath}/AdminUsersController?action=delete&id=${user.id}">Delete</a>

							|
							<button type="button" onclick="showDiv()"
								style="background: #33B8FF" style="font:bold">Update</button></td>



					</tr>


				</c:forEach>

			</tbody>

		</table>

	</form>




	<form action="AdminUsersController" method="get">
		<div id="mydiv" style="display: none;" border="1">

			<table>
				<tr id="IdInput">
					<td>ID :</td>
					<td><input type="text" name="editedid" id="editedid" readonly></td>
				</tr>
				<tr>
					<td>New UserName :</td>
					<td><input type="text" name="newusername" id="newusername"></td>
				</tr>
				<tr>
					<td>New Password :</td>
					<td><input type="text" name="newpassword" id="newpassword"></td>
				</tr>
				<tr>
					<td>New Admin Status :</td>
					<td><input type="text" name="newadminstatus"
						id="newadminstatus"></td>
				</tr>
				<tr>
					<td><input  type="submit" name="action"
						id="saveBTN" style="display: none;" value="Save"></td>
				</tr>

				<tr>
					<td><input  type="submit" name="action"
						id="addBTN" style="display: none;" value="Add"></td>
				</tr>


			</table>
		</div>
	</form>








</body>

</html>