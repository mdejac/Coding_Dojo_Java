<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Student Roster</title>
</head>
<body class="p-5">
<div class="container">
	    <h2 class="mb-3 mt-3">Dorms</h2>
	    <div>
	    	<a href="/dorms/new" class="d-block">Add a new Dorm</a>
	    	<a href="/students/new">Add a new Student</a>
	    </div>
    	<table class="table table-striped table-bordered text-center mt-5">
      		<thead>
        		<tr>
					<th>Name</th>
					<th>Action</th>
   		     	</tr>
      		</thead>
      		<tbody class="align-middle">
				<c:forEach var="dorm" items="${allDorms}">
					<tr>						
						<td><c:out value="${dorm.name}"/></td>
						<td><a href="/dorms/view/${dorm.id}">See Students</a></td>
					</tr>
				</c:forEach>
      		</tbody>
    	</table>
	</div>

</body>
</html>