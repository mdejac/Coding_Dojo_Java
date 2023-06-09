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
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<title>Lookify</title>
</head>
<body>
<h2>Add a song!</h2>
	<form:form class="border border-dark p-5" action="/songs/create" method="post" modelAttribute="song">
		<div class="mb-3">
			<form:label path="title" class="form-label" >Title : </form:label>
			<form:errors path="title" class="text-danger"/>
			<form:input path="title" class="form-control" type="text" />		
		</div>
		
		<div class="mb-3">
			<form:label path="artist" class="form-label">Artist: </form:label>
			<form:errors path="artist" class="text-danger"/>
			<form:input path="artist" class="form-control" type="text"/>
		</div>

		<div class="mb-3">
			<form:label path="rating" class="form-label">Rating : </form:label>
			<form:errors path="rating" class="text-danger"/>
			<form:input path="rating" class="form-control" type="number"/>
		</div>		
		
		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="Add song" />
			<a href="/songs/dashboard" class="btn btn-warning">Dashboard</a>
		</div>		
	</form:form>
</body>
</html>