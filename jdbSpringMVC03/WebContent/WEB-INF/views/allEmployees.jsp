<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employees</title>
</head>
<body>
	<h2>All Employees Page</h2>
	<div>Message: ${messageResult}</div>
	<c:forEach var="i" items="${empList}">
		<p>${i.getId()}</p>
		<p>${i.getFirstName()}</p>
		<p>${i.getEmail()}</p>

		<a href="${pageContext.request.contextPath}/updateEmployee/${i.id}">Update</a>
		<a href="${pageContext.request.contextPath}/removeEmployee/${i.id}">Delete</a>
		<hr>
	</c:forEach>
</body>
</html>