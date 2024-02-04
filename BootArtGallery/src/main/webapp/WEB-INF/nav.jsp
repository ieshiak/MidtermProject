<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<nav>
	<a href="/home">Home</a>
	<c:choose>
<c:when test="${not empty sessionScope.loggedInUser }">
<a href="/account">Account</a>
<a href="/logout">Logout</a>
</c:when>
<c:otherwise>
<a href="/login">Login</a>
</c:otherwise>
</c:choose>
</nav>