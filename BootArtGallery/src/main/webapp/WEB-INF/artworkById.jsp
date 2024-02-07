<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artwork Details</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="scripts/rating.js"></script>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<div style="text-align: center;">
    <h2>LOVE&#128525; LIKE&#128527; HATE&#128520;</h2>
</div>

<jsp:include page="nav.jsp" />

<c:if test="${not empty artwork}">
    <div style="text-align: left; width: 800px; margin: 0 auto;">
        <p>${artwork.title}, ${artwork.creationYear}</p>
        <p>Description: ${artwork.description}</p>
    </div>
    <div style="text-align: center;">
        <img src="${artwork.artworkImage}" alt="${artwork.title}" width="800" height="800">
    </div>
    
    <div id="ratingButtons" style="text-align: center;">
        <button class="rating" data-rating="Love" data-artwork-id="${artwork.id}">&#128525;<span id="loveCounter_${artwork.id}">0</span></button>
        <button class="rating" data-rating="Like" data-artwork-id="${artwork.id}">&#128527;<span id="likeCounter_${artwork.id}">0</span></button>
        <button class="rating" data-rating="Hate" data-artwork-id="${artwork.id}">&#128520;<span id="hateCounter_${artwork.id}">0</span></button>
    </div>

    <div style="text-align: center; width: 100%;">
        <c:if test="${not empty sessionScope.loggedInUser}">
            <div style="display: inline-block; width: 800px; text-align: center;">
                <h2>Add Comment</h2>
                <form id="commentForm" action="addComment.do" method="POST">
                    <input type="hidden" name="artworkId" value="${artwork.id}">
                    <textarea id="commentText" name="commentText" rows="4" cols="50" placeholder="Enter your comment here"></textarea><br>
                    <br>
                </form>
            </div>
            <div>
                    <input id="submitComment" type="submit" value="Add Comment">
            </div>
        </c:if>
    </div>

    <div style="text-align: center;">
        <c:if test="${empty sessionScope.loggedInUser}">
            <p>Please <a href="/login">log in</a> to add a comment.</p>
        </c:if>
    </div>
</c:if>
</body>
</html>
