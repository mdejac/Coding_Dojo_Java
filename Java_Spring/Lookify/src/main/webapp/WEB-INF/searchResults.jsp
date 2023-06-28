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
	<title>Lookify</title>
</head>
<body>
	<div class="container">
	<div class="d-flex justify-content-around align-items-center">
	    <h2 class="mb-3 mt-3">All songs by <c:if test="${!isFound}">Artists containing :</c:if> ${artistName}</h2>
		<a href="/songs/dashboard">Dashboard</a>	
	</div>
    	<table class="table table-striped table-bordered">
      		<thead>
        		<tr>
					<th>Title</th>
					<th>Rating</th>
					<th class="text-center">Actions</th>
   		     	</tr>
      		</thead>
      		<tbody class="align-middle">
				<c:forEach var="song" items="${allSongs}">
					<tr>						
						<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
						<td><c:out value="${song.rating}"/></td>
						<td> 
							<div class="d-flex justify-content-center align-items-center">
								<a href="/songs/edit/${song.id}" class="me-3">Edit</a> |
								<form action="/songs/delete/${song.id}" method="post" class="d-inline">
		    						<input type="hidden" name="_method" value="delete" />
			    					<input type="submit" class="btn btn-link" value="Delete">
		    					</form>
							
							</div>
							
	    				</td>
					</tr>
				</c:forEach>
      		</tbody>
    	</table>
	</div>
</body>
</html>