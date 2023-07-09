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
	<title>Insert title here</title>
</head>
<body>
	<div class="container">	
		<div class="d-flex justify-content-between align-items-center mt-3 mb-5 rounded header">
			<h1>Dojo Overflow</h1>
			<a href="/">Dashboard</a>		
		</div>
		
		<div>
			<h2><c:out value="${question.text}"/></h2>
			<div class="d-flex mt-4">
				<h3>Tags : </h3>
				<c:forEach var="tag" items="${question.tags}">
					<p class="btn btn-primary ms-2"><c:out value="${tag.subject}"/></p>
				</c:forEach>
			</div>
		</div>
		
		<div class="d-flex justify-content-between mt-5">
			
			<div class=col-6">
				<h4>Answers :</h4>
				<ul>
					<c:forEach var="answer" items="${question.answers}">
						<li><c:out value="${answer.text}"/></li>
					</c:forEach>				
				</ul>
			</div>
					
			<div class="col-6 d-flex justify-content-end">
				<div class="col-md-9">
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">Add your answer :</h3>
						</div>
						
						<div class="card-body">
							<form:form class="border border-dark rounded p-5" action="/questions/${question.id}/view" method="post" modelAttribute="answer">
								
								<div class="mb-3">
									<form:label path="text" class="form-label">Answer :</form:label>
									<form:errors path="text" class="text-danger"/>
									<form:textarea path="text" class="form-control" rows="10" ></form:textarea>
								</div>
						
								<div class="mb-3 text-end">
									<input class="btn btn-primary" type="submit" value="Submit" />
								</div>		
							</form:form>			
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>