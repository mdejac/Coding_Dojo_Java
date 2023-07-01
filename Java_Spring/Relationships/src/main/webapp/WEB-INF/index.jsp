<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Insert title here</title>
</head>
<body class="p-5">
	<div class="container">
	    <h2 class="mb-3 mt-3">People List</h2>
    	<table class="table table-striped table-bordered">
      		<thead>
        		<tr>
					<th>Person</th>
					<th>Has License</th>
					<th class="text-center">Actions</th>
   		     	</tr>
      		</thead>
      		<tbody class="align-middle">
				<c:forEach var="person" items="${allPersons}">
					<tr>						
						<td><a href="/persons/view/${person.id}"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></a></td>
						<td>
							<c:if test="${person.license == null }">N</c:if>
							<c:if test="${person.license != null }">Y</c:if>
						</td>
						<td> 
							<a href="/persons/edit/${person.id}" class="me-3">Edit</a> |
							<a href="/persons/delete/${person.id}" class="me-3">Delete</a>
	    				</td>
					</tr>
				</c:forEach>
      		</tbody>
    	</table>
	</div>
	<div class="container">
		<a href="/persons/new" class="btn btn-primary">Add a Person</a>
		<a href="/licenses/new" class="btn btn-primary">Add a License</a>
	</div>
</body>
</html>