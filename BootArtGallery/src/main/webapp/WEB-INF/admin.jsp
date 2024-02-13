<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
    <title>Admin</title>
    <link rel="stylesheet" href="styles.css">

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
        
        <div class="artwork-container">
	<c:forEach var="artworkList" items="${artworkList}">
    <div class="artwork">
        <a href="getArtwork.do?artworkId=${artworkList.id}">
            <img src="${artworkList.artworkImage}" alt="${artworkList.title}" style="width: 100px; height: auto;">
        </a>
        <ul>
            <li><a href="/createArtwork">Create New Artwork</a></li>
            <li><a href="/editArtwork?id=${artworkList.id}">Edit Existing Artwork</a></li>
            <li><a href="/deleteArtwork?id=${artworkList.id}">Delete Artwork</a></li>
        </ul>
    </div>
    </c:forEach>

        </div>
    </c:if>
</c:if>

    <c:if test="${empty sessionScope.loggedInUser}">
        <p>You need to <a href="/login">login</a> as an admin to access this page.</p>
    </c:if>
</body>
</html>
