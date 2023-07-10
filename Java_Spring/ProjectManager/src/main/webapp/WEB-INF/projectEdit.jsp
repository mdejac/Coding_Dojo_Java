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
		<div class="row justify-content-center">
			<div class="col-md-9">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">Edit a Project</h3>
					</div>
					
					<div class="card-body">
						<form:form class="border border-dark rounded p-5" action="/projects/${project.id}/edit" method="put" modelAttribute="project">
							<div class="mb-3">
								<form:label path="title" class="form-label">Title : </form:label>
								<form:errors path="title" class="text-danger"/>
								<form:input path="title" class="form-control" type="text" required="true"/>		
							</div>
							
							<div class="mb-3">
								<form:label path="dueDate" class="form-label" >Due Date : </form:label>
								<form:errors path="dueDate" class="text-danger"/>
								<form:input path="dueDate" class="form-control" type="date" required="true"/>
							</div>	
							
							<div class="mb-3">
								<form:label path="description" class="form-label">Details :</form:label>
								<form:errors path="description" class="text-danger"/>
								<form:textarea path="description" class="form-control" rows="10" required="true"></form:textarea>
							</div>
					
							<div class="mb-3 text-end">
								<a class="btn btn-warning" href="/dashboard">Cancel</a>
								<input class="btn btn-success" type="submit" value="Submit" />
							</div>		
						</form:form>			
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>