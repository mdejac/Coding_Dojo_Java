<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<title>Insert title here</title>
</head>
<body>
	<h1>Fruit Store</h1>
	<div id="displayWindow">
		<table>
			<tr>
				<th>Item</th>
				<th>Price</th>
			</tr>
			<c:forEach var="item" items="${items}">
			<tr>						
				<td <c:if test="${item.name.startsWith('G')}">style="color:orange;"</c:if>><c:out value="${item.name}"/></td>
				<td><fmt:formatNumber value="${item.price}" type="currency"/></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>