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
	<title>Product Manager</title>
</head>
<body>
<div class="container">	    
	    <div class="d-flex justify-content-between align-items-center mt-5 rounded header">
			<h1>Welcome, <c:out value="${user.userName}"/></h1>
			<a href="/users/logout">Logout</a>		
		</div>
		
		<div class="container p-2">
		
			<div class="d-flex justify-content-between align-items-center mt-4">
			    <p class="fs-5">All posted projects :</p>
				<a href="/projects/new">Add a new project</a> 			
			</div>
		    
		    
	    	<table class="table table-striped table-bordered">
	      		<thead>
	        		<tr>
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
						<th class="text-center">Actions</th>
	   		     	</tr>
	      		</thead>
	      		<tbody class="align-middle table-group-divider">
					<c:forEach var="project" items="${allProjects}">
						<tr>						
							<td><a href="/projects/${project.id}/view"><c:out value="${project.title}"/></a></td>
							<td><c:out value="${project.creator.firstName}"/></td>
							<td><fmt:formatDate value="${project.dueDate}" pattern="MMM dd" /></td>
							<td class="text-center"><a href="/projects/${project.id}/join">Join team</a></td>
						</tr>
					</c:forEach>
	      		</tbody>
	    	</table>
		</div>
		
		<div class="container p-2">
		
			<div class="d-flex justify-content-between align-items-center mt-4">
			    <p class="fs-5">Your projects :</p>	
			</div>
		    
		    
	    	<table class="table table-striped table-bordered">
	      		<thead>
	        		<tr>
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
						<th class="text-center">Actions</th>
	   		     	</tr>
	      		</thead>
	      		<tbody class="align-middle table-group-divider">
					<c:forEach var="project" items="${user.joinedProjects}">
						<tr>						
							<td><a href="/projects/${project.id}/view"><c:out value="${project.title}"/></a></td>
							<td><c:out value="${project.creator.firstName}"/></td>
							<td><fmt:formatDate value="${project.dueDate}" pattern="MMM dd" /></td>
							<td class="text-center">
								<c:if test="${project.creator.id == userId}">
									<a href="/projects/${project.id}/edit">Edit</a>
								</c:if>
								<c:if test="${project.creator.id != userId}">
									<a href="/projects/${project.id}/leave">Leave team</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
	      		</tbody>
	    	</table>
		</div>
	</div>
</body>
</html>