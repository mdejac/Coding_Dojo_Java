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
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
	<title>DojoOverflow</title>
</head>
<body>
<div class="container">
		<div class="mt-3 mb-5 rounded header">
			<h1>Dojo Overflow </h1>		
		</div>
	    <h2 class="mb-3 mt-3">Questions Dashboard</h2>
    	<table class="table table-striped table-bordered">
      		<thead>
        		<tr>
					<th>Question</th>
					<th>Tags</th>
   		     	</tr>
      		</thead>
      		<tbody class="align-middle">
				<c:forEach var="question" items="${allQuestions}">
					<tr>						
						<td><a href="/questions/${question.id}/view"><c:out value="${question.text}"/></a></td>
						<td>
							<c:set var="tagList" value="" />
							<c:forEach var="tag" items="${question.tags}" varStatus="loop">
							  <c:set var="tagList" value="${tagList}${tag.subject}" />
							  <c:if test="${!loop.last}">
							  	<c:set var="tagList" value="${tagList}${', '}" />
							  </c:if>
							</c:forEach>
							<c:out value="${tagList}" />
						</td>
					</tr>
				</c:forEach>
      		</tbody>
    	</table>
    	<div class="text-end">
	    	<a href="/questions/new" >New Question</a>    	
    	</div>
	</div>
</body>
</html>