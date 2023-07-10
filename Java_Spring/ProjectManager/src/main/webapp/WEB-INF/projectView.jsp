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
			<div class="col-7">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">Project Details</h3>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<p>Project :</p>							
							</div>
							<div class="col">
								<c:out value="${project.title}"/>
							</div>
						</div>
						<div class="row">
							<div class="col-3">
								<p>Due Date :</p>							
							</div>
							<div class="col">
								<fmt:formatDate value="${project.dueDate}" pattern="MM/dd/YYYY"/>
							</div>
						</div>
						<div class="row">
							<div class="col-3">
								<p>Details :</p>							
							</div>
							<div class="col">
								<c:out value="${project.description}"/>
							</div>
						</div>
					</div>
					<div class="card-footer">
						<div class="row">
							<a href="/projects/${project.id}/tasks">See Tasks</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-5">
				<div class="card">
					<div class="card-header text-center">
						<h3 class="card-title">Team Members</h3>
					</div>
					<div class="card-body">
						<ul class="list-group">
							<c:forEach var="member" items="${project.teamMembers}">
								<li class="list-group-item"> 
									<c:out value="${member.firstName}"/>
									<c:out value="${member.lastName}"/>
									<c:if test="${member.id.equals(project.creator.id)}">
										- Team Lead
									</c:if>
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