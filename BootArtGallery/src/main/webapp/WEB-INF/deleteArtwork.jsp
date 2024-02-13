<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Delete Artwork</title>
</head>
<div style="text-align: center;">
<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
</div>
<body>
<%-- Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>
<h3>Delete Artwork</h3>

<c:if test="${!artworkDeleted}">
    <form action="/deleteArtwork" method="post">
        <input type="hidden" name="id" value="${deleteArtwork.id}" />
        <img src="${deleteArtwork.artworkImage}" alt="${deleteArtwork.title}" width="200" height="200" class="center">
        <br>
        <p>Are you sure you want to delete the Artwork title ${deleteArtwork.title} ?</p>
        <input type="submit" value="Delete"/>
    </form>
</c:if>

<c:if test="${artworkDeleted}">
    <h1>Success</h1>
    <p>The artwork has been successfully deleted.</p>
</c:if>

<c:if test="${!artworkDeleted && not empty errorMessage}">
    <h1>Delete Artwork Failed</h1>
    <p>There was an issue deleting the artwork or the artwork was not found.</p>
    <p>Error Message: ${errorMessage}</p>
</c:if>
</body>
</html>
