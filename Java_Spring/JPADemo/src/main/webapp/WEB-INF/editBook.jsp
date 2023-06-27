<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<meta charset="UTF-8">
	<title>Edit Book</title>
</head>
<body>
<h1>Edit <c:out value="${bookTitle}"/></h1>
	<form:form class="border border-dark p-5" action="/books/edit/${book.id}" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="put"/>
		<div class="mb-3">
			<form:label path="title" class="form-label" for="title">Title : </form:label>
			<form:errors path="title" class="text-danger"/>
			<form:input path="title" class="form-control" type="text" id="title" required="true"/>		
		</div>
		
		<div class="mb-3">
			<form:label path="language" class="form-label" for="language">Language : </form:label>
			<form:errors path="language" class="text-danger"/>
			<form:input path="language" class="form-control" type="text" id="language" required="true"/>
		</div>

		<div class="mb-3">
			<form:label path="numberOfPages" class="form-label" for="numberOfPages">Number of Pages : </form:label>
			<form:errors path="numberOfPages" class="text-danger"/>
			<form:input path="numberOfPages" class="form-control" type="number" id="numberOfPages" required="true"/>
		</div>		
		
		<div class="mb-3">
			<form:label path="description" class="form-label" for="description">Description:</form:label>
			<form:errors path="description" class="text-danger"/>
			<form:textarea path="description" class="form-control" id="description" rows="10" required="true"></form:textarea>
		</div>

		<div class="mb-9">
			<input class="btn btn-primary" type="submit" value="Edit Book" />
			<a href="/books/delete/${book.id}" class="btn btn-warning">Delete</a>
			<a href="/books" class="btn btn-secondary">Cancel</a>
		</div>		
	</form:form>
</body>
</html>