<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
	<title>Project Manager</title>
</head>
<body>
	<div class="container">	
		<div class="d-flex justify-content-between align-items-center mt-3 mb-5 rounded header">
			<h1>Project Manager</h1>
			<a href="/dashboard">Dashboard</a>		
		</div>
		<div class="row">
			<div class="col-md-7">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title"><c:out value="${project.title}"/></h3>
						<p>Team Lead : <c:out value="${project.creator.firstName}"/> <c:out value="${project.creator.lastName}"/></p>
					</div>
					<c:forEach var="teamMember" items="${project.teamMembers}">
  						<c:if test="${teamMember.id == userId}">
							<div class="card-body">
								<form:form class="border border-dark rounded p-5" action="/projects/${project.id}/tasks" method="post" modelAttribute="task">
									
									<div class="mb-3">
										<form:label path="description" class="form-label">Add a task ticket for this team :</form:label>
										<form:errors path="description" class="text-danger"/>
										<form:textarea path="description" class="form-control" rows="10" required="true"></form:textarea>
									</div>
							
									<div class="mb-3 text-end">
										<input class="btn btn-primary" type="submit" value="Submit" />
									</div>		
								</form:form>			
							</div>
					  </c:if>
					</c:forEach>
				</div>
			</div>
			<div class="col">
				<div class="card">
					<div class="card-header">
						<h3>Current Tasks</h3>
					</div>
					<div class="card-body">
						<ul class="list-group d-flex flex-column-reverse">
							<c:forEach var="task" items="${project.tasks}">
								<li class="list-group">
									<p class="fw-bold">Added by <c:out value="${task.createdBy.firstName}"/> at <fmt:formatDate value="${task.createdAt}" pattern="H:mma MMM.d.YYYY"/></p>
									<p><c:out value="${task.description}"/></p>
								</li>
							</c:forEach>						
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>