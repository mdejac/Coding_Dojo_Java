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
	<div class="text-center my-5">
		<h1>Top Ten</h1>
		<a href="/songs/dashboard">Dashboard</a>
	</div>
	<ol class="list-group list-group-numbered">
		<c:forEach var="song" items="${allSongs}">
  			<li class="list-group-item d-flex justify-content-between align-items-start">
    			<div class="ms-2 me-auto">
      				<div class="fw-bold"><c:out value="${song.title}"/></div>
      				by <c:out value="${song.artist}"/>
    			</div>
    			<span class="badge bg-primary rounded-pill"><c:out value="${song.rating}"/></span>
  			</li>
  		</c:forEach>
	</ol>
</body>
</html>