<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>

<h2>LOVE.LIKE.HATE</h2>

    <p>
        Title: ${artwork.title}<br>
        Creation Year: ${artwork.creationYear}<br>
        Description: ${artwork.description}<br>
        <img src="images/IMG_7157.JPG">
        
    </p>

</body>
</html>