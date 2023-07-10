<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Dorm Roster</title>
</head>
<body class="p-5">
	<h2><c:out value="${student.name}"/>'s classes</h2>
	<a href="/dorms">Home</a>
	
	<form action="/students/${student.id}/view" method="post">
	<div class="d-flex">
		<div class="mb-3 col-6 text-center border border-dark p-5">
			<div class="form-floating">
				<select id="class" name="classId" class="form-select" required>
					<c:forEach var="oneClass" items="${allClasses}">
					    <option value="${oneClass.id}">
							<c:out value="${oneClass.name} "/>
						 </option>	        		
				    </c:forEach>
				</select>
				<label for="class">Class : </label>	
			</div>
		</div>
		<div class="mb-3 col-6 text-center border border-dark p-5">
			<input class="btn btn-primary" type="submit" value="Add" />
		</div>
	</div>
	</form>
	    
    <table class="table table-striped table-bordered">
      	<thead>
        	<tr>
				<th>Class name</th>
				<th class="text-center">Action</th>
   		     </tr>
      	</thead>
      	<tbody>
			<c:forEach var="oneClass" items="${student.classes}">
				<tr>						
					<td><a href="/classes/${oneClass.id}/view"><c:out value="${oneClass.name}"/></a></td>
					<td class="text-center"><a href="/students/${student.id}/remove/${oneClass.id}">Drop</a></td>
				</tr>
			</c:forEach>
      	</tbody>
    </table>

</body>
</html>