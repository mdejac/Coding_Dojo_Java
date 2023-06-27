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
	<title>Save Travels</title>
</head>
<body>
	<h1>Save Travels</h1>
	
	<div class="container">
	    <h2 class="mb-3 mt-3">All Expenses</h2>
    	<table class="table table-striped">
      		<thead>
        		<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
   		     	</tr>
      		</thead>
      		<tbody>
				<c:forEach var="expense" items="${allExpenses}">
					<tr>						
						<td><c:out value="${expense.name}"/></td>
						<td><c:out value="${expense.vendor}"/></td>
						<td>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${expense.amount}" /></td>
						<td class="d-flex justify-content-around align-items-center">
							<a href="/expenses/${expense.id}">View</a> | 
							<a href="/expenses/edit/${expense.id}">Edit</a> | 
							<form action="/expenses/delete/${expense.id}" method="post" class="d-inline">
		    					<input type="hidden" name="_method" value="delete" />
			    				<input type="submit" class="btn btn-link" value="Delete">
		    				</form>
							
	    				</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td>Total : </td>
					<td>$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${totalSpent}" /></td>
					<td></td>
				</tr>
      		</tbody>
    	</table>
	</div>
	<h2>Add an expense!</h2>
	<form:form class="border border-dark p-5" action="/expenses/create/submit" method="post" modelAttribute="expense">
		<div class="mb-3">
			<form:label path="name" class="form-label" for="name">Expense Name : </form:label>
			<form:errors path="name" class="text-danger"/>
			<form:input path="name" class="form-control" type="text" id="name" required="true"/>		
		</div>
		
		<div class="mb-3">
			<form:label path="vendor" class="form-label" for="vendor">Vendor: </form:label>
			<form:errors path="vendor" class="text-danger"/>
			<form:input path="vendor" class="form-control" type="text" id="vendor" required="true"/>
		</div>

		<div class="mb-3">
			<form:label path="amount" class="form-label" for="amount">Amount $: </form:label>
			<form:errors path="amount" class="text-danger"/>
			<form:input path="amount" class="form-control" type="number" step="0.01" id="amount" required="true"/>
		</div>		
		
		<div class="mb-3">
			<form:label path="description" class="form-label" for="description">Description:</form:label>
			<form:errors path="description" class="text-danger"/>
			<form:textarea path="description" class="form-control" id="description" rows="10" required="true"></form:textarea>
		</div>

		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="Add expense" />
			<a href="/expenses" class="btn btn-warning">Clear</a>
		</div>		
	</form:form>
</body>
</html>