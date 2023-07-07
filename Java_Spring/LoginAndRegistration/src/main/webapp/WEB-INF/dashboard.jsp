<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Dashboard</title>
</head>
<body>
	<div class="container">	
		<div class="d-flex justify-content-between align-items-center">
			<h1>Welcome <c:out value="${user.userName}"/></h1>
			<a href="/users/logout">Logout</a>		
		</div>
		
		<div>
			<p><c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></p>
			<p><c:out value="${user.email}"/></p>
		</div>
	</div>
	
</body>
</html>