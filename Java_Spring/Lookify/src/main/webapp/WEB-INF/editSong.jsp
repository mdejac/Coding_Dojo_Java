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
<h2>Edit <c:out value="${songTitle}"/></h2>
	<form:form class="border border-dark p-5" action="/songs/edit/${song.id}" method="post" modelAttribute="song">
		<input type="hidden" name="_method" value="put">
		<div class="mb-3">
			<form:label path="title" class="form-label" for="title">Title : </form:label>
			<form:errors path="title" class="text-danger"/>
			<form:input path="title" class="form-control" type="text" id="title"/>		
		</div>
		
		<div class="mb-3">
			<form:label path="artist" class="form-label" for="artist">Artist: </form:label>
			<form:errors path="artist" class="text-danger"/>
			<form:input path="artist" class="form-control" type="text" id="artist" />
		</div>

		<div class="mb-3">
			<form:label path="rating" class="form-label" for="rating">Rating : </form:label>
			<form:errors path="rating" class="text-danger"/>
			<form:input path="rating" class="form-control" type="number" step="0.01" id="rating" />
		</div>		
		
		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="Submit Edit" />
			<a href="/songs/dashboard" class="btn btn-warning">Dashboard</a>
		</div>		
	</form:form>
</body>
</html>