<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Artwork Search Results</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="scripts/rating.js"></script>
    <link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
  	<div style="text-align: center;">
		<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
	</div>
	<%--Edit the file nav.jsp to change nav links --%>
	<jsp:include page="nav.jsp" />

    <div style="text-align: center;">
        <h2>Search Results</h2>
    </div>

    <c:if test="${not empty artworks}">
        <c:forEach var="artwork" items="${artworks}">
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

            <div style="border: 1px solid #ccc; margin-bottom: 10px; padding: 10px; text-align: left; width: 800px; margin: 0 auto; background-color: #f9f9f9;">
                <p style="font-weight: bold;">Comments</p>
                <ul style="list-style-type: none; padding: 0;">
                    <c:forEach var="comment" items="${artwork.comments}">
                        <li style="margin-bottom: 5px;">
                            <strong>${comment.user.username}</strong>: ${comment.commentText}
                        </li>
                    </c:forEach>
                </ul>
            </div>
            
        </c:forEach>
    </c:if>
     <div style="text-align: center; width: 400%;">
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
</body>
</html>
