<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${book.title}"/></h1>
	<p>Description : <c:out value="${book.description}"/></p>
	<p>Language : <c:out value="${book.language}"/></p>
	<p>Number of Pages : <c:out value="${book.numberOfPages}"/></p>
	<a href="/books">Home</a>
</body>
</html>