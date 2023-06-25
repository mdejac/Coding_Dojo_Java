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
	<title>Books</title>
</head>
<body>
	<h1>All Books</h1>
	
	<div class="container">
		<div class="d-flex align-items-center justify-content-between">
	    	<h2 class="mb-3 mt-3">All Books</h2>
			<a href="/books/create">Add a book</a>		
		</div>
    	<table class="table table-striped">
      		<thead>
        		<tr>
					<th>Title</th>
					<th>Language</th>
					<th>Pages</th>
					<th>Description</th>
   		     	</tr>
      		</thead>
      		<tbody>
				<c:forEach var="book" items="${allBooks}">
					<tr>						
						<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
						<td><c:out value="${book.language}"/></td>
						<td><c:out value="${book.numberOfPages}"/></td>
						<td><c:out value="${book.description}"/></td>
					</tr>
				</c:forEach>
      		</tbody>
    	</table>
  </div>
</body>
</html>