<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Artwork Details</title>
</head>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>

<h2>All Artwork</h2>
<c:forEach var="artwork" items="${artworks}">
    <p>
        <a href="getArtwork.do?artworkId=${artwork.id}">
            ${artwork.title}
        </a>
    </p>
</c:forEach>

</body>
</html>
