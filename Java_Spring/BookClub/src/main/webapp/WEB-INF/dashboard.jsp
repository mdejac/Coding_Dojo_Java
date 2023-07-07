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
	    <div class="d-flex justify-content-between align-items-center mt-5 rounded header">
			<h1>Welcome, <c:out value="${user.userName}"/></h1>
			<a href="/users/logout">Logout</a>		
		</div>
		
		<div class="container p-2">
		
			<div class="d-flex justify-content-between align-items-center mt-4">
			    <p class="fs-5">Books from everyone's shelves :</p>
				<a href="/books/new">Add a book to my shelf</a>		
			</div>
		    
		    
	    	<table class="table table-striped table-bordered">
	      		<thead>
	        		<tr>
						<th>Title</th>
						<th>Author Name</th>
						<th>Posted By</th>
	   		     	</tr>
	      		</thead>
	      		<tbody class="align-middle table-group-divider">
					<c:forEach var="book" items="${allBooks}">
						<tr>						
							<td><a href="/books/${book.id}/view"><c:out value="${book.title}"/></a></td>
							<td><c:out value="${book.author}"/></td>
							<td><c:out value="${book.postedBy.firstName}"/> <c:out value="${book.postedBy.lastName}"/></td>
						</tr>
					</c:forEach>
	      		</tbody>
	    	</table>
		</div>
	</div>

</body>
</html>