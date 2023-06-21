<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js" defer></script>
	<title>Date</title>
</head>
<body>
	<h1><c:out value="${date}"/></h1>
	<div id="message-data" data-message="This is the Date template"></div>
</body>
</html>