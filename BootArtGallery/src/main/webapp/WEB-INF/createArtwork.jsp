<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Artwork</title>
</head>
<div style="text-align: center;">
<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
</div>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>
	<h3>Create Artwork</h3>
	
	<form action="/createArtwork" method="post">
		<div>
			Title: <input type="text" name="title" required /> <br>
			Description: <input type="text" name="description" /> <br>
			Creation Year: <input type="text" name="creationYear" /> <br> <input
				type="submit" value="Create Artwork" />
		</div>
<br>
<div>
 <c:if test="${pageContext.request.method eq 'POST'}">
 
        <c:if test="${not empty artworkCreated}">
            <h3>Artwork Added Successfully</h3>
            
            <c:if test="${artworkCreated}">
            
                <p>New Artwork Details:</p>
                <p>Title: ${newArtwork.title}</p>
                <p>Description: ${newArtwork.description}</p>
                <p>Creation Year: ${newArtwork.creationYear}</p>
            </c:if>
            
            <c:if test="${not artworkCreated}">
                <p>Error: Artwork not added. Please try again.</p>
            </c:if>
</c:if>
</c:if>
</div>
</body>
</html>