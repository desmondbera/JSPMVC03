<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/index">Home</a>
	<h1>Employee Edit Form</h1>
	<form action="${pageContext.request.contextPath}/saveEmployee" method="post">
		id:<input type="text" name="id" value="${emp.id }"> 
		first name: <input type="text" name="firstName" value="${emp.firstName}">
		last name:<input type="text" name="lastName" value="${emp.lastName}"> 
		email: <input type="text" name="email" value="${emp.email}">
		<input type="submit" value="save">
	</form>
</body>
</html>