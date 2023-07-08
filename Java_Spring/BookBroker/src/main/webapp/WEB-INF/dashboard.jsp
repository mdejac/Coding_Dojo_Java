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
	<title>Book Broker</title>
</head>
<body>
<div class="container">	    
	    <div class="d-flex justify-content-between align-items-center mt-5 rounded header">
			<h1>Welcome, <c:out value="${user.userName}"/></h1>
			<a href="/users/logout">Logout</a>		
		</div>
		
		<div class="container p-2">
		
			<div class="d-flex justify-content-between align-items-center mt-4">
			    <p class="fs-5">Available books to borrow :</p>
				<a href="/books/new">Add a book to borrow</a> 			
			</div>
		    
		    
	    	<table class="table table-striped table-bordered">
	      		<thead>
	        		<tr>
						<th>Title</th>
						<th>Author Name</th>
						<th>Posted By</th>
						<th class="text-center">Actions</th>
	   		     	</tr>
	      		</thead>
	      		<tbody class="align-middle table-group-divider">
					<c:forEach var="book" items="${allBooks}">
						<c:if test="${book.borrowedBy == null}">
							<tr>						
								<td><a href="/books/${book.id}/view"><c:out value="${book.title}"/></a></td>
								<td><c:out value="${book.author}"/></td>
								<td><c:out value="${book.postedBy.firstName}"/> <c:out value="${book.postedBy.lastName}"/></td>
								<td class="text-center">
									<c:choose>
										<c:when test="${userId == book.postedBy.id}">
											<a class="btn btn-link" href="/books/${book.id}/edit">Edit</a> | 
											<a class="btn btn-link" href="/books/${book.id}/delete">Delete</a>
										</c:when>
										<c:otherwise>
										 <form action="/books/${book.id}/borrow" method="post">
										 	<input type="hidden" name="_method" value="put">
											<input type="submit" class="btn btn-link" value="Borrow"/>										 
										 </form>
										 </c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:if>
					</c:forEach>
	      		</tbody>
	    	</table>
		</div>
		
		<div class="container p-2">
		
			<div class="d-flex justify-content-between align-items-center mt-4">
			    <p class="fs-5">Books I am borrowing :</p>	
			</div>
		    
		    
	    	<table class="table table-striped table-bordered">
	      		<thead>
	        		<tr>
						<th>Title</th>
						<th>Author Name</th>
						<th>Posted By</th>
						<th class="text-center">Actions</th>
	   		     	</tr>
	      		</thead>
	      		<tbody class="align-middle table-group-divider">
					<c:forEach var="book" items="${allBooks}">
						<c:if test="${book.borrowedBy.id == userId}">
						<tr>						
							<td><a href="/books/${book.id}/view"><c:out value="${book.title}"/></a></td>
							<td><c:out value="${book.author}"/></td>
							<td><c:out value="${book.postedBy.firstName}"/> <c:out value="${book.postedBy.lastName}"/></td>
							<td class="text-center">
								<form action="/books/${book.id}/return" method="post">
									<input type="hidden" name="_method" value="put">
									<input type="submit" class="btn btn-link" value="Return"/>										 
								</form>
							</td>
						</tr>
						</c:if>
					</c:forEach>
	      		</tbody>
	    	</table>
		</div>
		
		<div class="container p-2">
		
			<div class="d-flex justify-content-between align-items-center mt-4">
			    <p class="fs-5">Books you've posted :</p>	
			</div>
		    
		    <table class="table table-striped table-bordered">
	      		<thead>
	        		<tr>
						<th>Title</th>
						<th>Author Name</th>
						<th class="text-center">Actions</th>
	   		     	</tr>
	      		</thead>
	      		<tbody class="align-middle table-group-divider">
					<c:forEach var="book" items="${userBooks}">
						<tr>						
							<td><a href="/books/${book.id}/view"><c:out value="${book.title}"/></a></td>
							<td><c:out value="${book.author}"/></td>
							<td class="text-center">
								<c:choose>
									<c:when test="${book.borrowedBy != null}">
										<p class="fst-italic mb-0 p-1">Borrowed</p>
									</c:when>
									<c:otherwise>
										<a class="btn btn-link" href="/books/${book.id}/edit">Edit</a> | 
										<a class="btn btn-link" href="/books/${book.id}/delete">Delete</a>
									 </c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
	      		</tbody>
	    	</table>
		</div>
	</div>

</body>
</html>