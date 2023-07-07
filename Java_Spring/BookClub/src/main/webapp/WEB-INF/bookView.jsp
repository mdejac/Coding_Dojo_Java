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
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
	<title>Book Club</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center mt-3 mb-5 rounded header">
			<h1>Book Club</h1>
			<a href="/books">Back to Shelves</a>		
		</div>
		<div class="row justify-content-center">
			<div class="col-md-9">
				<div class="card">
					<div class="card-header">
						<h2 class="fst-italic card-title"><c:out value="${book.title}"/></h2>				
						<h5 class="card-subtitle">by <c:out value="${book.author}"/>, read by 
							<c:if test="${book.postedBy.id == userId}">you.</c:if>
							<c:if test="${book.postedBy.id != userId}"><c:out value="${book.postedBy.firstName}"/> <c:out value="${book.postedBy.lastName}"/></c:if>
						</h5>
					</div>
					<div class="card-body">
						<h6 class="card-title">Here are
							<c:if test="${book.postedBy.id == userId}">your </c:if>
							<c:if test="${book.postedBy.id != userId}"><c:out value="${book.postedBy.firstName}"/>'s </c:if>
						thoughts : </h6>
						<hr />
						<p><c:out value="${book.description}"/></p>
						<hr/>
					</div>
					<div class="card-footer">
						<c:if test="${book.postedBy.id == userId}"> 
							<div class="text-end">
								<a class="btn btn-success" href="/books/${book.id}/edit">Edit</a>
								<a class="btn btn-warning" href="/books/${book.id}/delete">Delete</a>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>