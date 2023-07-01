<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Relationships</title>
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-between align-items-center">
	    <h2 class="mb-3 mt-3">Person Details</h2>
	    <a href="/">Home</a>
	</div>
   	<table class="table table-striped table-bordered">
   		<thead>
      		<tr>
				<th>Name</th>
				<th>License Number</th>
				<th>State</th>
				<th>Exp Date</th>
				<th class="text-center">Actions</th>
	     	</tr>
   		</thead>
   		<tbody class="align-middle">
			<tr>						
				<td><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></td>
				<td><c:out value="${person.license.number}"/></td>
				<td><c:out value="${person.license.state}"/></td>
				<td><fmt:formatDate pattern="MM.dd.yyyy" value="${person.license.expirationDate}"/></td>
				<td> 
					<div class="d-flex justify-content-center align-items-center">
						<a href="/REPLACE/edit/${person.license.id}" class="me-3">Edit</a> |
						<a href="/REPLACE/delete/${person.license.id}" class="me-3">Delete</a>		
					</div>
   				</td>
			</tr>
  		</tbody>
   	</table>
</div>

</body>
</html>