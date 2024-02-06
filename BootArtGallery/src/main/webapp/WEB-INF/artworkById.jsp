<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artwork Details</title>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="scripts/rating.js"></script>

</head>
<body>
	<%--Edit the file nav.jsp to change nav links --%>
	<jsp:include page="nav.jsp" />

	<c:if test="${not empty artwork}">
		<div
			style="border: 1px solid #ccc; margin-bottom: 10px; padding: 10px;">
			<p>${artwork.title}, ${artwork.creationYear}</p>
			<p>Description: ${artwork.description}</p>

			<img src="${artwork.artworkImage}" alt="${artwork.title}" width="800"
				height="800">
		</div>
		<div>
		<div>
    <button class="rating" data-rating="Love" data-artwork-id="${artwork.id}">Love</button>
    <button class="rating" data-rating="Like" data-artwork-id="${artwork.id}">Like</button>
    <button class="rating" data-rating="Hate" data-artwork-id="${artwork.id}">Hate</button>
</div>
		</div>
	</c:if>
	<p>Comments: ${artwork.comments}</p>


</body>
</html>
