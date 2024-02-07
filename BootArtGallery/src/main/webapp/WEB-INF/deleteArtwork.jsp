<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Artwork</title>
</head>
<div style="text-align: center;">
<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
</div>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>
<h3>Delete Artwork</h3>
<body>
<form action="/deleteArtwork" method="post">
        <input type="hidden" name="id" value="${deleteArtwork.id}"/>
 		<img src="${deleteArtwork.artworkImage}" alt="${deleteArtwork.title}" width="200" height="200" class="center">
        <p>Are you sure you want to delete the Artwork with ID ${deleteArtwork.id}?
        </p>


        <input type="submit" value="Delete"/>
    </form>
</body>
</html>