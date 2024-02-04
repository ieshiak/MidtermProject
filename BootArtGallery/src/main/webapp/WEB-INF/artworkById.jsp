<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Artwork Details</title>
</head>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>
    <c:if test="${not empty artwork}">
        <div style="border: 1px solid #ccc; margin-bottom: 10px; padding: 10px;">
           <h3><a href="<c:url value='/artwork/${artwork.id}' />">${artwork.title}</a></h3>

            <p>ID: ${artwork.id}</p>
            <p>Image: ${artwork.artworkImage}</p>
            <p>Creation Year: ${artwork.creationYear}</p>
            <p>Description: ${artwork.description}</p>
            <p>Ratings: ${artwork.ratings}</p>
            <p>Comments: ${artwork.comments}</p>
            <!-- Add other artwork details as needed -->
        </div>
    </c:if>

    <!-- Handle the case where the artwork is not found -->
    <c:if test="${empty artwork}">
        <p>Artwork not found.</p>
    </c:if>
</body>
</html>
