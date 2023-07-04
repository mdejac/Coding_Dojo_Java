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
<body class="p-5">
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
		    <h2 class="mb-3 mt-3"><c:out value="${dojo.name}"/> Location Ninjas</h2>
			<a href="/">Home</a>
		</div>
    	<table class="table table-striped table-bordered">
      		<thead>
        		<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
   		     	</tr>
      		</thead>
      		<tbody class="align-middle">
				<c:forEach var="ninja" items="${dojo.ninjas}">
					<tr>						
						<td><c:out value="${ninja.firstName}"/></td>
						<td><c:out value="${ninja.lastName}"/></td>
						<td><c:out value="${ninja.age}"/></td>
					</tr>
				</c:forEach>
      		</tbody>
    	</table>
	</div>
</body>
</html>