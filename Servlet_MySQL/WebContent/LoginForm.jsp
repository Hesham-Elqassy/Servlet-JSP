<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>


<link rel="stylesheet" type="text/css" href="CSS/Css-Style-LoginForm.css" />

</head>
<body>

	<div id="container">
	
		<h3>${message}</h3>
		<form action="LoginController" method="post">
			<table>

				<label for="username">Username:</label>
				<input type="text" name="loginUserName" value="" id="username">

				<label for="password">Password:</label>
				<input type="password" name="loginPassword" value="" id="password">

				<div id="lower">

					<input type="submit" name="action" value="Login">

				</div>

			</table>

		</form>

	</div>


</body>
</html>