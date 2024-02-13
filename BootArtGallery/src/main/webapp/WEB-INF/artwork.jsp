<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles.css">
    <title>Artwork Details</title>
</head>
<div style="text-align: center;">
<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
</div>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>

<c:forEach var="artwork" items="${artworks}">
    <p>
        <a href="getArtwork.do?artworkId=${artwork.id}">
            
            <img src="${artwork.artworkImage}" alt="${artwork.title}" width="800" height="800" class="center">
        </a>
    </p>
</c:forEach>

</body>
</html>
