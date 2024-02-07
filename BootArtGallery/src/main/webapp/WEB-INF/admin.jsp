<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin</title>
</head>
<div style="text-align: center;">
<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
</div>
<body>
    <%-- Edit the file nav.jsp to change nav links --%>
    <jsp:include page="nav.jsp" />

    <h2>Welcome to Admin</h2>

    <c:if test="${not empty sessionScope.loggedInUser}">
    <c:if test="${sessionScope.loggedInUser.admin}">
        <h3>Artwork Management</h3>
        
        <c:forEach var="artworkList" items="${artworkList}">
        <a href="getArtwork.do?artworkId=${artworkList.id}">
            <img src="${artworkList.artworkImage}" alt="${artworkList.title}" width="200" height="200" class="center">
        </a>
        <ul>
            <li><a href="/createArtwork">Create New Artwork</a></li>
            <li><a href="/editArtwork/${artworkList.id}">Edit Existing Artwork</a></li>
            <li><a href="/deleteArtwork/${artworkList.id}">Delete Artwork</a></li>
        </ul>
		</c:forEach>
        
    </c:if>
</c:if>
    <c:if test="${empty sessionScope.loggedInUser}">
        <p>You need to <a href="/login">login</a> as an admin to access this page.</p>
    </c:if>
</body>
</html>
