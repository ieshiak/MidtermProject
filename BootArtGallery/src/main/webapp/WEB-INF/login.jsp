<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="styles.css">
<title>Sign in</title>

<style>

</style>
</head>
<body>
	<div style="text-align: center;">
		<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
	</div>
	<%--Edit the file nav.jsp to change nav links --%>
	<jsp:include page="nav.jsp" />
	
	
	<div class="container">
        <h2>Sign In</h2>
        <form action="/login" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="Sign In">
        </form>
    </div>
</body>
</html>

	