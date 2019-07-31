<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Registration</h1>
	<form action="addEmployee" method="POST">
		<input type="text" name="id"> 
		<input type="text" name="firstName">
		<input type="text" name="lastName"> 
		<input type="text" name="email">
		<input type="submit" value="save">
	</form>
</body>
</html>