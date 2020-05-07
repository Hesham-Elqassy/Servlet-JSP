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

<script type="text/javascript" src="JavaScript/JS-UserInfo-JSP.js"></script>



</head>
<body>



<form action="ProductController" method="get">

		<input type="submit" name="openUserInfo" value="Products"
			style="color: white; padding: 8px 16px; text-align: center;; font-size: 12px; background-color: black; top: 0; right: 0;">
	</form>

<h3 style="align-items: center;
  justify-content: center; display: flex;" >Your Info</h3>
<form action="UsersInfoController" method="get">

		
		<table border="1" id="usersInfoTable" class="display">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Password</th>
					
					<th>Actions</th>
				</tr>
			</thead>



			<tbody>
				<c:forEach items="${userInfoList}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						
						<td>

							
							<button type="button" onclick="showUserInfoDiv()"
								style="background: #33B8FF" style="font:bold">Update</button>
								
							|
							
							<a style="color: red"
							href="${pageContext.request.contextPath}/UsersOrdesrListController?action=showUserOrders&userID=${user.id}">My Orders</a>
							
							
<!-- 							<button type="button" name="action" onclick="showUserOrdersInfoDiv()"  -->
<!-- 								style="background: #33B8FF" style="font:bold">ShowOrders</button>	 -->
								</td>



					</tr>


				</c:forEach>

			</tbody>

		</table>

	</form>




	<form action="UsersInfoController" method="get">
		<div id="myUserInfoDiv" style="display: none;" border="1">

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
					<td><input  type="submit" name="action"
						id="saveBTN" style="display: none;" value="Save"></td>
				</tr>

				


			</table>
		</div>
	</form>













<br></br>
<br></br>
<br><br>









</body>
</html>