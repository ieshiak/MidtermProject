<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
    <title>Error Page</title>
</head>
<div style="text-align: center;">
<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
</div>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>
<body>
<div style="text-align: center;">
         <h1>Error Page</h1>
	<img src="/images/Devil.PNG" alt="${artwork.title}" width="100" height="100" style="text-align: center;">
        <p>Please try again!</p>
        <%-- Display error details only if available --%>
        <c:if test="${not empty exception}">
            <pre>${errorDetails}</pre>
            <pre>${error}</pre>
            <pre>${errorMessage}</pre>
            <pre>${errorSignUp}</pre>
        </c:if>
    </div>
</body>
</html>
