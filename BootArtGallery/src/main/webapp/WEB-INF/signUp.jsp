<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="styles.css">
<title>Sign Up</title>

<style>

</style>
</head>
<body>
	<div style="text-align: center;">
		<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
	</div>
	<%--Edit the file nav.jsp to change nav links --%>
	<jsp:include page="nav.jsp" />
	
<div class="container2">
        <h2>Sign Up</h2>
	<form action="/signUp" method="post">
			<input type="text" name="firstName" placeholder="First Name" required/> <br>
			<input type="text" name="lastName" placeholder="Last Name" required/> <br>
			<input type="text" name="username" placeholder="Username" required/> <br> 
			<input type="password" name="password" placeholder="Password" required/> <br> 
			<input type="submit" value="Sign Up" />
	</form>
</div>
    
    <c:if test="${pageContext.request.method eq 'POST'}">
        <c:if test="${not empty userCreated}">
            <h3>Congrats for being apart of our family!</h3>
            
            <c:if test="${userCreated}">
                <p>New User Details:</p>
                <ul>
                <li>First Name: ${newUser.firstName}</li>
                <li>Last Name: ${newUser.lastName}</li>
                <li>Username: ${newUser.username}</li>
                </ul>
            </c:if>
            
            <c:if test="${not userCreated}">
                <p>Error: Please try again.</p>
            </c:if>
        </c:if>
    </c:if>
</body>
</html>