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
        <div>
        <input type="hidden" name="id" value="${editedArtwork.id}" />
        <img src="${editedArtwork.artworkImage}" alt="${editedArtwork.title}" width="200" height="200" />
        </div>
        <div>
         Image URL: <input type="text" name="artworkImage" value="${editedArtwork.artworkImage}" required /> <br>
            Title: <input type="text" name="title" value="${editedArtwork.title}" required /> <br>
            Description: <input type="text" name="description" value="${editedArtwork.description}" /> <br>
            Creation Year: <input type="text" name="creationYear" value="${editedArtwork.creationYear}" /> <br> 
            <input type="submit" value="Edit Artwork" />
        </div>
    </form>
<div>
<c:if test="${pageContext.request.method eq 'POST' && editSuccess}">
    <h3>Artwork Updated Successfully</h3>
    <p>New Artwork Details:</p>
    <p>Image URL: ${editedArtwork.artworkImage}</p>
    <p>Title: ${editedArtwork.title}</p>
    <p>Description: ${editedArtwork.description}</p>
    <p>Creation Year: ${editedArtwork.creationYear}</p>
</c:if>
</body>
</html>