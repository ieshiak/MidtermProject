<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account View</title>
</head>
<div style="text-align: center;">
<h2>LOVE&#128525;LIKE&#128527;HATE&#128520;</h2>
</div>
<body>
	<%--Edit the file nav.jsp to change nav links --%>
	<jsp:include page="nav.jsp" />
	<c:choose>
		<c:when test="${not empty sessionScope.loggedInUser }">
			<hr>
			<h2>
				Hello,
				<c:out value="${sessionScope.loggedInUser.username}" />
			</h2>
			<h4>
				Login time:
				<c:out value="${sessionScope.loginTime}" />
			</h4>
			<c:if test="${not empty comments}">
    <h3>Recent Comments:</h3>
    <ul>
        <c:forEach var="comment" items="${comments}" varStatus="loop">
    <li>
        <img src="${artworkList[loop.index].artworkImage}" alt="Artwork Image" width="50" height="50">
        <strong>${comment.user.username}</strong>: ${comment.commentText}
    </li>
</c:forEach>

    </ul>
</c:if>
		</c:when>
		<c:otherwise>
			<p>Not logged in</p>
		</c:otherwise>
	</c:choose>

</body>
</html>