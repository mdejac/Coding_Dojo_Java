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
	<title>Show Burger</title>
</head>
<body>
	<div class="container my-4">

        <h1><c:out value="${burger.name}"/></h1>

	    <div class="card my-4">
    	    <div class="card-body">
        
        	    <div class="form-group">
            	    <label for="restaurantName" class="d-inline">Restaurant Name:</label>
                	<p class="form-control-static d-inline" id="restaurantName"><c:out value="${burger.restaurantName}"/></p>
            	</div>

            	<div class="form-group">
                	<label for="rating" class="d-inline">Rating:</label>
                	<p class="form-control-static d-inline" id="rating"><c:out value="${burger.rating}"/></p>
            	</div>

            	<div class="form-group">
                	<label for="notes" class="d-inline">Notes:</label>
                	<p class="form-control-static d-inline" id="notes"><c:out value="${burger.notes}"/></p>
            	</div>
        	</div>
    	</div>
    	<div class="mb-9">
	    	<a href="/burgers/edit/${burger.id}" class="btn btn-primary">Edit Burger</a>
	    	<form action="/burgers/delete/${burger.id}" method="post" class="d-inline">
	    		<input type="hidden" name="_method" value="delete" />
		    	<input type="submit" class="btn btn-danger" value="Delete"/>
	    	</form>
	    	<a href="/burgers" class="btn btn-warning">Cancel</a>
    	</div>
 	</div>
</body>
</html>