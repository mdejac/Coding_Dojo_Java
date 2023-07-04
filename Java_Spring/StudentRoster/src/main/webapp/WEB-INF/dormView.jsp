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
	<h2><c:out value="${dorm.name}"/> Students</h2>
	<a href="/dorms">Home</a>
	
	<form action="/dorms/add/student/${dorm.id}" method="post">
	<div class="d-flex">
		<div class="mb-3 col-6 text-center border border-dark p-5">
			<div class="form-floating">
				<select id="student" name="studentId" class="form-select" required>
					<c:forEach var="oneStudent" items="${allStudents}">
						<c:if test="${oneStudent.dorm.id != dorm.id}">
					    	<option value="${oneStudent.id}">
								<c:out value="${oneStudent.name} "/>
								<c:if test="${oneStudent.dorm != null }">
									- (<c:out value="${oneStudent.dorm.name}"/>)
								</c:if>
						  	</option>	        		
						</c:if>
				    </c:forEach>
				</select>
				<label for="student">Student : </label>	
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
				<th>Student</th>
				<th class="text-center">Action</th>
   		     </tr>
      	</thead>
      	<tbody>
			<c:forEach var="student" items="${dorm.students}">
				<tr>						
					<td><c:out value="${student.name}"/></td>
					<td class="text-center"><a href="/dorms/remove/student/${student.id}">Remove</a></td>
				</tr>
			</c:forEach>
      	</tbody>
    </table>

</body>
</html>