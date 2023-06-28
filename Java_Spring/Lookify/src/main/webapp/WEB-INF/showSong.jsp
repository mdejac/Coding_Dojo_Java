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
	<title>Lookify</title>
</head>
<body>
	<div class="container my-4">

        <h1>Song Details</h1>

	    <div class="card my-4">
    	    <div class="card-body">
    	    
    	     	<div class="form-group">
            	    <label for="title" class="d-inline">Title:</label>
                	<p class="form-control-static d-inline" id="title"><c:out value="${song.title}"/></p>
            	</div>
        
        	    <div class="form-group">
            	    <label for="artist" class="d-inline">Artist:</label>
                	<p class="form-control-static d-inline" id="artist"><c:out value="${song.artist}"/></p>
            	</div>

            	<div class="form-group">
                	<label for="rating" class="d-inline">Rating:</label>
                	<p class="form-control-static d-inline" id="rating"><c:out value="${song.rating}"/></p>
            	</div>
            	
        	</div>
    	</div>
    	<div class="mb-9">
	    	<a href="/songs/edit/${song.id}" class="btn btn-primary">Edit song</a>
	    	<form action="/songs/delete/${song.id}" method="post" class="d-inline">
	    		<input type="hidden" name="_method" value="delete" />
		    	<input type="submit" class="btn btn-danger" value="Delete"/>
	    	</form>
	    	<a href="/songs/dashboard" class="btn btn-warning">Dashboard</a>
    	</div>
 	</div>
</body>
</html>