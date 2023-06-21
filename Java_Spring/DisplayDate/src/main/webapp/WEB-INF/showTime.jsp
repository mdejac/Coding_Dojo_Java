<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js" defer></script>
<title>Time</title>
</head>
<body>
	<h1><c:out value="${time}"/></h1>
	<div id="message-data" data-message="This is the time template"></div>
</body>
</html>