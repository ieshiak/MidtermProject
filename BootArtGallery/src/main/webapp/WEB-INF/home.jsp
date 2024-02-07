<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.skilldistillery.artgallery.entities.Artwork" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet" href="styles.css">
</head>
<div style="text-align: center;">
<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
</div>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>

<div style="text-align: center;">
<div id="slideshow" data-component="slideshow">
        <div role="list">
          <div class="slide center">
            <img src="images/BusyBody.PNG" alt="" width="800" height="800">
          </div>
          <div class="slide">
            <img src="images/BeautieFullMoon.JPG" alt="" width="800" height="800">
          </div>
          <div class="slide">
            <img src="images/PinkDragon.JPG" alt="" width="800" height="800">
          </div>
        </div>
      </div>
      </div>
    <script src="scripts/slideshow.js"></script>
    </body>
  </html>
  
  
  
  