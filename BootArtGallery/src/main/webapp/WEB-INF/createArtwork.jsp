<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Artwork</title>
</head>
<body>
	<h3>Create Artwork</h3>
	<h3>HEY</h3>
	
	<form action="/createArtwork" method="post">
		<div>
			Title: <input type="text" name="title" required /> <br>
			Description: <input type="text" name="description" /> <br>
			Creation Year: <input type="text" name="creationYear" /> <br> <input
				type="submit" value="Create Artwork" />
		</div>
	</form>
		<form action="/upload" method="post" enctype="multipart/form-data">
			<label for="photo">Select Image:</label> <input type="file"
				name="photo" id="photo" accept="image/*" required> <br>
			<input type="submit" value="Upload Photo">
		</form>

</body>
</html>