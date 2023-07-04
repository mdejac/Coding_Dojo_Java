<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Dojos and Ninjas</title>
</head>
<body>
<div class="container">
	    <h2 class="mb-3 mt-3">Dojos and Ninjas</h2>
	    <div class="container text-center">
			<a href="/dojos/new" class="btn btn-primary">Add A Dojo</a>
			<a href="/ninjas/new" class="btn btn-secondary">Add A Ninja</a>
		</div>
    	<table class="table table-striped table-bordered mt-5">
      		<thead>
        		<tr>
					<th>Name</th>
					<th class="text-center">Actions</th>
   		     	</tr>
      		</thead>
      		<tbody class="align-middle">
				<c:forEach var="dojo" items="${allDojos}">
					<tr>						
						<td><a href="/dojos/view/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
						<td> 
							<div class="d-flex justify-content-center align-items-center">
								<a href="/dojos/edit/${dojo.id}" class="me-3">Edit</a> |
								<form action="/dojos/delete/${dojo.id}" method="post" class="d-inline">
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