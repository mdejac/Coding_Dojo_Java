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
	<title>Relationships</title>
</head>
<body class="p-5">
<h2>Add a License!</h2>
	<form:form class="border border-dark p-5" action="/licenses/create" method="post" modelAttribute="license">
		<div class="mb-3">
			<form:label path="person" class="form-label" >Person : </form:label>
			<form:errors path="person" class="text-danger"/>
			<form:select path="person" class="form-select">
				<form:option value ="" disabled="true" selected="true" hidden="true">Select a Person...</form:option>
	        	<c:forEach var="onePerson" items="${allPersons}">
	        		<<c:if test="${onePerson.license == null }">
		            	<form:option value="${onePerson.id}" path="person">
		                	<c:out value="${onePerson.firstName}"/>
		                	<c:out value="${onePerson.lastName}"/>
		            	</form:option>	        		
	        		</c:if>
	        	</c:forEach>
	    	</form:select>
		</div>
		<div class="mb-3">
			<form:label path="state" class="form-label" >State : </form:label>
			<form:errors path="state" class="text-danger"/>
			<form:input path="state" class="form-control" type="text" />		
		</div>
		
		<div class="mb-3">
			<form:label path="expirationDate" class="form-label">Exp Date: </form:label>
			<form:errors path="expirationDate" class="text-danger"/>
			<form:input path="expirationDate" class="form-control" type="date"/>
		</div>

		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="Create" />
			<a href="/" class="btn btn-warning">Cancel</a>
		</div>		
	</form:form>
</body>
</html>