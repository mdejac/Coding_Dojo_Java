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
	<h2>All Classes</h2>
	<a href="/dorms">Home</a>
    	<table class="table table-striped table-bordered text-center mt-3">
      		<thead>
        		<tr>
					<th>Class</th>
   		     	</tr>
      		</thead>
      		<tbody class="align-middle">
				<c:forEach var="oneClass" items="${allClasses}">
					<tr>						
						<td><a href="/classes/${oneClass.id}/view"><c:out value="${oneClass.name}"/></a></td>
					</tr>
				</c:forEach>
      		</tbody>
    	</table>
	</div>

</body>
</html>