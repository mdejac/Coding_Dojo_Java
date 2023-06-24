<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<title>Omikuji</title>
</head>
<body>
	<h1>Send an Omikuji</h1>
	<form class="border border-dark p-5" action="/omikuji/submit" method="post">
		<div class="mb-3">
			<label class="form-label" for="number">Pick any number from 5 to 25</label>
			<input class="form-control" type="number" id="number" name="number" min="5" max="25" required/>		
		</div>
		
		<div class="mb-3">
			<label class="form-label" for="city">Enter the name of any city.</label>
			<input class="form-control" type="text" id="city" name="city" required/>
		</div>

		<div class="mb-3">
			<label class="form-label" for="name">Enter the name of and real person.</label>
			<input class="form-control" type="text" id="name" name="name" required/>
		</div>		

		<div class="mb-3">
			<label class="form-label" for="hobby">Enter professional endeavor of hobby.</label>
			<input class="form-control" type="text" id="hobby" name="hobby" required/>
		</div>		

		<div class="mb-3">
			<label class="form-label" for="thing">Enter any type of living thing.</label>
			<input class="form-control" type="text" id="thing" name="thing" required/>	
		</div>		
		
		<div class="mb-3">
			<label class="form-label" for="message">Say something nice to someone:</label>
			<textarea class="form-control" name="message" id="message" rows="10" required></textarea>
		</div>

		<div class="mb-3">
			<p>Send and show a friend</p>
			<input class="btn btn-primary" type="submit" value="Send" />
		</div>		
	</form>
</body>
</html>