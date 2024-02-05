<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Artwork Details</title>
</head>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>
<h2>Artwork Details</h2>

    <p>Title: ${artwork.title}</p>
    <p>Creation Year: ${artwork.creationYear}</p>
    <p>Description: ${artwork.description}</p>


</body>
</html>
