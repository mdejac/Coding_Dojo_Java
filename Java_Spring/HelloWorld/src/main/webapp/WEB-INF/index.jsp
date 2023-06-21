<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Two plus two is : </h2>
	<p><c:out value="${2+2}"/></p>
	
	<h2>Fruits of the day : </h2>
	<p><c:out value="${fruit1}"/></p>
	<p><c:out value="${fruit2}"/></p>
	
</body>
</html>