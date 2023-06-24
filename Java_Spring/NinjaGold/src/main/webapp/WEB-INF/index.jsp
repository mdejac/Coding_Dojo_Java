<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<title>Ninja Gold</title>
</head>
<body>
<h1>Ninja Gold</h1>
    <div class="border_black" id="gameboard">
        <div class="flex_between">
	        <div class="flex">
    	       <p>Your Gold: </p>
 	    	   <p class="border_black gold_display">${gold}</p>
       		 </div>	
       		 
             <form action="/ninjaGold/processMoney" method="post">
             	<input type="hidden" name="area" value="reset">
                <input class="border_black button_shadow" type="submit" value="Reset Game!">
             </form>
        </div>

        <div class="flex_between" id="selection_area">
            <div class="border_black choice_boxes">
                <h2>Farm</h2>
                <p>(earns 10-20 gold)</p>
                <form action="/ninjaGold/processMoney" method="post">
                    <input type="hidden" name="area" value="farm">
                    <input class="border_black button_shadow" type="submit" value="Find Gold!">
                </form>
            </div>
            
            <div class="border_black choice_boxes">
                <h2>Cave</h2>
                <p>(earns 5-10 gold)</p>
                <form action="/ninjaGold/processMoney" method="post">
                    <input type="hidden" name="area" value="cave">
                    <input class="border_black button_shadow" type="submit" value="Find Gold!">
                </form>
            </div>
            
            <div class="border_black choice_boxes">
                <h2>House</h2>
                <p>(earns 2-5 gold)</p>
                <form action="/ninjaGold/processMoney" method="post">
                    <input type="hidden" name="area" value="house">
                    <input class="border_black button_shadow" type="submit" value="Find Gold!">
                </form>
            </div>
            
            <div class="border_black choice_boxes">
                <h2>Quest</h2>
                <p>(earns/takes 0-50 gold)</p>
                <form action="/ninjaGold/processMoney" method="post">
                    <input type="hidden" name="area" value="quest">
                    <input class="border_black button_shadow" type="submit" value="Find Gold!">
                </form>
            </div>
            
            <div class="border_black choice_boxes">
                <h2>Spa</h2>
                <p>(takes 5-20 gold)</p>
                <form action="/ninjaGold/processMoney" method="post">
                    <input type="hidden" name="area" value="spa">
                    <input class="border_black button_shadow" type="submit" value="Enter Spa!">
                </form>
            </div>
        </div>
        <p>Activities</p>
        <div class="border_black" id="activities">
        	<c:forEach var="message" items="${activities}">
        		<c:out value="${message}" escapeXml="false"/>
        	</c:forEach>
        </div>
    </div>
</body>
</html>