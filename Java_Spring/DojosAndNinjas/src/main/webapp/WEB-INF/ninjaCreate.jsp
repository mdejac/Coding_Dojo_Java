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
	<title>Dojos and Ninjas</title>
</head>
<body class="p-5">
<h2>Add a ninja!</h2>
	<form:form class="border border-dark p-5" action="/ninjas/create" method="post" modelAttribute="ninja">
		<div class="mb-3">
			<form:label path="location" class="form-label" >Dojo : </form:label>
			<form:errors path="location" class="text-danger"/>
			<form:select path="location" class="form-select">
				<form:option value ="" disabled="true" selected="true" hidden="true">Select a location...</form:option>
	        	<c:forEach var="oneDojo" items="${allDojos}">
	        	  	<form:option value="${oneDojo.id}" path="location">
		               	<c:out value="${oneDojo.name}"/>
		         	</form:option>	        		
	        	</c:forEach>
	    	</form:select>
		</div>
		
		<div class="mb-3">
			<form:label path="firstName" class="form-label" >First Name : </form:label>
			<form:errors path="firstName" class="text-danger"/>
			<form:input path="firstName" class="form-control" type="text" />		
		</div>
		
		<div class="mb-3">
			<form:label path="lastName" class="form-label">Last Name: </form:label>
			<form:errors path="lastName" class="text-danger"/>
			<form:input path="lastName" class="form-control" type="text"/>
		</div>

		<div class="mb-3">
			<form:label path="age" class="form-label">Age : </form:label>
			<form:errors path="age" class="text-danger"/>
			<form:input path="age" class="form-control" type="number"/>
		</div>		
		
		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="Add ninja" />
			<a href="/" class="btn btn-warning">Cancel</a>
		</div>		
	</form:form>
</body>
</html>