<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<title>Omikuji</title>
</head>
<body>
	<h1>Here's your Omikuji!</h1>
	<div id="omikuji">
		<p>In ${number} years, you will live in ${city} with ${name} as your room mate, ${hobby} for a living.  The next time you see a ${thing}, you will have good luck.  Also, ${message} </p>
	</div>
	<a href="/">Go Back</a>
</body>
</html>