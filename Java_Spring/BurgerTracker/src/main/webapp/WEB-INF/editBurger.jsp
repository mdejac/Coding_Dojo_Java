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
	<title>Burger Tracker</title>
</head>
<body>
<h2>Edit Burger : <c:out value="${burgerName}"/></h2>
	<form:form class="border border-dark p-5" action="/burgers/edit/${burger.id}" method="post" modelAttribute="burger">
		<input type="hidden" name="_method" value="put"/>
		<div class="mb-3">
			<form:label path="name" class="form-label" for="name">Burger Name : </form:label>
			<form:errors path="name" class="text-danger"/>
			<form:input path="name" class="form-control" type="text" id="name" required="true"/>		
		</div>
		
		<div class="mb-3">
			<form:label path="restaurantName" class="form-label" for="restaurantName">Restaurant Name : </form:label>
			<form:errors path="restaurantName" class="text-danger"/>
			<form:input path="restaurantName" class="form-control" type="text" id="restaurantName" required="true"/>
		</div>

		<div class="mb-3">
			<form:label path="rating" class="form-label" for="rating">Rating : </form:label>
			<form:errors path="rating" class="text-danger"/>
			<form:input path="rating" class="form-control" type="number" id="rating" required="true"/>
		</div>		
		
		<div class="mb-3">
			<form:label path="notes" class="form-label" for="notes">Description:</form:label>
			<form:errors path="notes" class="text-danger"/>
			<form:textarea path="notes" class="form-control" id="notes" rows="10" required="true"></form:textarea>
		</div>

		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="Submit Edit" />
			<a href="/burgers" class="btn btn-warning">Home</a>
		</div>		
	</form:form>
</body>
</html>