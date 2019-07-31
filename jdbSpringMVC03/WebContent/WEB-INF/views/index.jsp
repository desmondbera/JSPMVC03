<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Welcome to the Index Page</h1>
	<hr>
	<a href="addEmployee">Add Employee</a>
	<a href="registerEmployee">Register Employee</a>
	<a href="showEmployees">All Employees</a>
	
	${sEmployee.id }
	${sEmployee.firstName}
</body>
</html>