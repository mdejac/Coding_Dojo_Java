<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Current visit count</title>
</head>
<body>
	<p>You have visited localhost:8080 
		<c:choose>
			<c:when test="${visitCount==null}">
				0
			</c:when>
			<c:otherwise>
				<c:out value="${visitCount}"/>
			</c:otherwise>
		</c:choose>
	 times.</p>
	<a href="/">Test another visit.</a>
</body>
</html>