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
	<h1>Test</h1>
	<div id="displayWindow">
		<table>
			<tr>
				<th>Title</th>
				<th>Language</th>
				<th>Pages</th>
				<th>Description</th>
			</tr>
			<c:forEach var="book" items="${allBooks}">
			<tr>						
				<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
				<td><c:out value="${book.language}"/></td>
				<td><c:out value="${book.numberOfPages}"/></td>
				<td><c:out value="${book.description}"/></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>