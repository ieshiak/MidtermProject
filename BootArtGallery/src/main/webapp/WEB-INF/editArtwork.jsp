<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Artwork</title>
</head>
<div style="text-align: center;">
<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
</div>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>
<h3>Edit Artwork</h3>
<body>
	<form action="/editArtwork" method="post">
	<input type="hidden" name="id" value="${editedArtwork.id}"/>
	<img src="${editedArtwork.artworkImage}" alt="${editedArtwork.title}" width="200" height="200">
		<div>
			Title: <input type="text" name="title" required /> <br>
			Description: <input type="text" name="description" /> <br>
			Creation Year: <input type="text" name="creationYear" /> <br> 
			<input type="submit" value="Edit Artwork" />
		</div>
</body>
</html>