<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<title>Add a book</title>
</head>
<body>
	<h1>Add A Book!</h1>
	<form class="border border-dark p-5" action="/books/submit" method="post">
		<div class="mb-3">
			<label class="form-label" for="title">Title : </label>
			<input class="form-control" type="text" id="title" name="title" required/>		
		</div>
		
		<div class="mb-3">
			<label class="form-label" for="language">Language : </label>
			<input class="form-control" type="text" id="language" name="language" required/>
		</div>

		<div class="mb-3">
			<label class="form-label" for="numberOfPages">Number of Pages : </label>
			<input class="form-control" type="number" id="number" name="numberOfPages" required/>
		</div>		
		
		<div class="mb-3">
			<label class="form-label" for="description">Description:</label>
			<textarea class="form-control" name="description" id="description" rows="10" required></textarea>
		</div>

		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="Add Book" />
			<a href="/books" class="btn btn-secondary">Cancel</a>
		</div>		
	</form>
</body>
</html>