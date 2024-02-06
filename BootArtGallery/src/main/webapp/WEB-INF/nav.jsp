<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<style>
    nav {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px;
        background-color: #f0f0f0;
    }

    nav a {
        margin-right: 10px; 
    }

    form {
        display: flex;
        align-items: center;
    }
</style>
<nav>
	<a href="/home">Home</a>
	<c:choose>
<c:when test="${not empty sessionScope.loggedInUser }">
<a href="/account">Account</a>
<a href="/createArtwork">Create</a>
<a href="/uploadForm">Upload</a>
<a href="/logout">Logout</a>
</c:when>
<c:otherwise>
<a href="/login">Login</a>
<a href="/artwork">Artwork</a>
</c:otherwise>
</c:choose>

<form action="getArtwork.do" method="GET">
  Artwork ID: <input type="text" name="artworkId" />
  <input type="submit" value="Show Artwork" />
</form>
</nav>