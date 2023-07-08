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
	<title>Products and Categories</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center header mb-5">Home Page</h1>
	
		<div class="d-flex flex-column">
			<a href="/products/new">New Product</a>
			<a href="/categories/new">New Category</a>
		</div>
		
		<hr />
		
		<div class="d-flex justify-content-between">
			<div class="container border border-dark">
				<p class="text-center p-3 border-bottom border-dark fs-4">Products</p>
				<div>
					<c:forEach var="product" items="${allProducts}">
						<p><a href="/products/${product.id}/view"><c:out value="${product.name}"/></a></p>
					</c:forEach>
				</div>
			</div>
			<div class="container border border-dark">
				<p class="text-center p-3 border-bottom border-dark fs-4">Categories</p>
				<div>
					<c:forEach var="category" items="${allCategories}">
						<p><a href="/categories/${category.id}/view"><c:out value="${category.name}"/></a></p>
					</c:forEach>
				</div>
			</div>
		
		</div>
	</div>
</body>
</html>