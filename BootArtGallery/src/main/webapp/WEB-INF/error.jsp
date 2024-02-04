<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
</head>
<body>
         <h1>Error Page</h1>
        <p>An unexpected error occurred. Please try again later.</p>
        <%-- Display error details only if available --%>
        <c:if test="${not empty exception}">
            <p>Error Details:</p>
            <pre>${errorDetails}</pre>
        </c:if>
    </div>
</body>
</html>
