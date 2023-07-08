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
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
	<title>Products and Categories</title>
</head>
<body>
	<div class="container">	
		<div class="d-flex justify-content-between align-items-center mt-3 mb-5 rounded header">
			<h1>Add a Category Page</h1>
			<a href="/">Home</a>		
		</div>
		<div class="row justify-content-center">
			<div class="col-md-9">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">Add a Category</h3>
					</div>
					
					<div class="card-body">
						<form:form class="border border-dark rounded p-5" action="/categories/new" method="post" modelAttribute="category">
							<div class="mb-3">
								<form:label path="name" class="form-label">Name : </form:label>
								<form:errors path="name" class="text-danger"/>
								<form:input path="name" class="form-control" type="text" required="true"/>		
							</div>
					
							<div class="mb-3 text-end">
								<input class="btn btn-primary" type="submit" value="Add Category" />
							</div>		
						</form:form>			
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>