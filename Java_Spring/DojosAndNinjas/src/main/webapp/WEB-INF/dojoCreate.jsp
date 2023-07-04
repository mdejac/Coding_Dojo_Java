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
	<title>Dojos and Ninjas</title>
</head>
<body class="p-5">
<h2>Add a Dojo</h2>
	<form:form class="border border-dark p-5" action="/dojos/create" method="post" modelAttribute="dojo">
		<div class="mb-3">
			<form:label path="name" class="form-label" >Dojo Name : </form:label>
			<form:errors path="name" class="text-danger"/>
			<form:input path="name" class="form-control" type="text" />		
		</div>	
		
		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="Add Dojo" />
			<a href="/" class="btn btn-warning">Cancel</a>
		</div>		
	</form:form>
</body>
</html>