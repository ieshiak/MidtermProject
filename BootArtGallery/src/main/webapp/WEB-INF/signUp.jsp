<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create User</title>
</head>
<div style="text-align: center;">
<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
</div>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<jsp:include page="nav.jsp"/>
	<h3>Sign Up</h3>
	
	<form action="/createUser" method="post">
		<div>
			First Name: <input type="text" name="firstName" required/> <br>
			Last Name: <input type="text" name="lastName" required/> <br>
			Username: <input type="text" name="username" required/> <br> 
			Password: <input type="password" name="password" required/> <br> 
			<input type="submit" value="Sign Up" />
		</div>
</form>
    
    <c:if test="${pageContext.request.method eq 'POST'}">
        <c:if test="${not empty userCreated}">
            <h3>Congrats for being apart of our family!</h3>
            
            <c:if test="${userCreated}">
                <p>New User Details:</p>
                <p>First Name: ${newUser.firstName}</p>
                <p>Last Name: ${newUser.lastName}</p>
                <p>Username: ${newUser.username}</p>
            </c:if>
            
            <c:if test="${not userCreated}">
                <p>Error: Please try again.</p>
            </c:if>
        </c:if>
    </c:if>
</body>
</html>