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
	<title>Show Book</title>
</head>
<body>
	<div class="container my-4">
    	<div class="row">

        	<div class="col-sm-12">
        		<h1><c:out value="${book.title}"/></h1>
        	</div>
    	</div>

	    <div class="card my-4">
    	    <div class="card-body">
        
        	    <div class="form-group">
            	    <label for="language" class="d-inline">Language:</label>
                	<p class="form-control-static d-inline" id="language"><c:out value="${book.language}"/></p>
            	</div>

            	<div class="form-group">
                	<label for="numberOfPages" class="d-inline">Number of pages:</label>
                	<p class="form-control-static d-inline" id="numberOfPages"><c:out value="${book.numberOfPages}"/></p>
            	</div>

            	<div class="form-group">
                	<label for="description" class="d-inline">Description:</label>
                	<p class="form-control-static d-inline" id="description"><c:out value="${book.description}"/></p>
            	</div>
        	</div>
    	</div>
    	<a href="/books">Home</a>
 	</div>
</body>
</html>