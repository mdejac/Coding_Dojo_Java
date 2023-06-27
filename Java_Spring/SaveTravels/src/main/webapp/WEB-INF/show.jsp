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
	<title>Save Travels</title>
</head>
<body>
	<div class="container my-4">

        <h1>Expense Details</h1>

	    <div class="card my-4">
    	    <div class="card-body">
    	    
    	     	<div class="form-group">
            	    <label for="name" class="d-inline">Expense Name:</label>
                	<p class="form-control-static d-inline" id="name"><c:out value="${expense.name}"/></p>
            	</div>
        
        	    <div class="form-group">
            	    <label for="vendor" class="d-inline">Vendor:</label>
                	<p class="form-control-static d-inline" id="vendor"><c:out value="${expense.vendor}"/></p>
            	</div>

            	<div class="form-group">
                	<label for="amount" class="d-inline">Amount:</label>
                	<p class="form-control-static d-inline" id="amount">$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${expense.amount}" /></p>
            	</div>

            	<div class="form-group">
                	<label for="description" class="d-inline">Description:</label>
                	<p class="form-control-static d-inline" id="description"><c:out value="${expense.description}"/></p>
            	</div>
        	</div>
    	</div>
    	<div class="mb-9">
	    	<a href="/expenses/edit/${expense.id}" class="btn btn-primary">Edit expense</a>
	    	<form action="/expenses/delete/${expense.id}" method="post" class="d-inline">
	    		<input type="hidden" name="_method" value="delete" />
		    	<input type="submit" class="btn btn-danger" value="Delete"/>
	    	</form>
	    	<a href="/expenses" class="btn btn-warning">Cancel</a>
    	</div>
 	</div>
</body>
</html>