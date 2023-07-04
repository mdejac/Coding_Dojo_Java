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
	<title>Student Roster</title>
</head>
<body class="p-5">
<h2>Add a Student</h2>
	<form:form class="border border-dark p-5" action="/students/new" method="post" modelAttribute="student">
		<div class="mb-3">
			<form:label path="name" class="form-label" >Name : </form:label>
			<form:errors path="name" class="text-danger"/>
			<form:input path="name" class="form-control" type="text" />		
		</div>
		
		<form:label path="dorm" class="form-label" >Dorm : </form:label>
		<form:errors path="dorm" class="text-danger"/>
		<form:select path="dorm" class="form-select">
			<form:option value ="null" disabled="true" selected="true" hidden="true">Select a Dorm...</form:option>
	       	<c:forEach var="oneDorm" items="${allDorms}">
	       	  	<form:option value="${oneDorm.id}" path="dorm">
		           	<c:out value="${oneDorm.name}"/>
		       	</form:option>	        		
	       	</c:forEach>
	    </form:select>	
		
		<div class="mb-3 mt-3">
			<input class="btn btn-primary" type="submit" value="Add Student" />
			<a href="/dorms" class="btn btn-warning">Cancel</a>
		</div>		
	</form:form>
</body>
</html>