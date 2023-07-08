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
			<h1>Category View Page</h1>
			<a href="/">Home</a>		
		</div>
		
		<div class="container border border-dark mb-5">
			<p class="text-center p-3 border-bottom border-dark fs-4"><c:out value="${category.name}"/></p>
			<div>
				<p>Products : </p>
				<c:forEach var="product" items="${category.products}">
					<p><a href="/products/${product.id}/view"><c:out value="${product.name}"/></a></p>
				</c:forEach>
			</div>
		</div>
		
		<div class="row justify-content-center">
			<div class="col-md-9">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">Add Product</h3>
					</div>
					
					<div class="card-body">
						<form action="/categories/${category.id}/product" method="post">
							<div class="mb-3">
								<select name="productId" class="form-select">
									<option value ="" disabled selected hidden="true">Select a Product...</option>
						        	<c:forEach var="product" items="${allProducts}">
						        	  	<option value="${product.id}">
						       	        	<c:out value="${product.name}"/>
							         	</option>	        		
						        	</c:forEach>
						    	</select>							
							</div>
					
							<div class="mb-3 text-end">
								<input class="btn btn-primary" type="submit" value="Add Product" />
							</div>		
						</form>		
							
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>