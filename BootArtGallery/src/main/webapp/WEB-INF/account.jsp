<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account View</title>
</head>
<body>
	<%--Edit the file nav.jsp to change nav links --%>
	<jsp:include page="nav.jsp" />

	<h2>Account View</h2>
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
			<h3>Recent Comments:</h3>
			<c:if test="${not empty comments}">
				<ul>
					<c:forEach var="comment" items="${comments}">
						<li>${comment.commentText}- ${comment.createTime}</li>
						<!-- Adjust based on your Comment entity -->
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${empty comments}">
				<p>No comments available.</p>
			</c:if>

		</c:when>
		<c:otherwise>
			<p>Not logged in</p>
		</c:otherwise>
	</c:choose>

<div align= "center">
<form action="/upload" method="post" enctype="multipart/form-data">
    <label for="photo">Select Image:</label>
    <input type="file" name="photo" id="photo" accept="image/*" required>
    <br>
    <input type="submit" value="Upload Photo">
</form>
</div>

</body>
</html>