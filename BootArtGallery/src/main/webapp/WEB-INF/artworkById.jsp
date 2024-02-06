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
			<button class="rating-button" data-rating="Love"
				data-artwork-id="${artwork.id}">Love</button>
			<button class="rating-button" data-rating="Like"
				data-artwork-id="${artwork.id}">Like</button>
			<button class="rating-button" data-rating="Hate"
				data-artwork-id="${artwork.id}">Hate</button>
		</div>

	</c:if>
	<p>Comments: ${artwork.comments}</p>




</body>
</html>
