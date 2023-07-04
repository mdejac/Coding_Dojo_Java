<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Student Roster</title>
</head>
<body class="p-5">
<h2>Add a Dorm</h2>
	<form:form class="border border-dark p-5" action="/dorms/new" method="post" modelAttribute="dorm">
		<div class="mb-3">
			<form:label path="name" class="form-label" >Name : </form:label>
			<form:errors path="name" class="text-danger"/>
			<form:input path="name" class="form-control" type="text" />		
		</div>	
		
		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="Add Dorm" />
			<a href="/dorms" class="btn btn-warning">Cancel</a>
		</div>		
	</form:form>
</body>
</html>