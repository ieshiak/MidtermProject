<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>File Upload Example</title>
</head>
<body>

    <c:if test="${message ne null}">
        <div>
            <h2><c:out value="${message}"/></h2>
        </div>
    </c:if>

    <div>
        <form method="POST" enctype="multipart/form-data" action="/">
            <table>
                <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
                <tr><td></td><td><input type="submit" value="Upload" /></td></tr>
            </table>
        </form>
    </div>

    <div>
        <ul>
            <c:forEach var="file" items="${files}">
                <li>
                    <a href="<c:out value="${file}"/>"><c:out value="${file}"/></a>
                </li>
            </c:forEach>
        </ul>
    </div>

</body>
</html>
