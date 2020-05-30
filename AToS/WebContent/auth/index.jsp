<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apes Together Strong</title>
</head>
<body>
	<h1>Apes Together Strong</h1>
	<p>
		Hello <c:out value="${sessionScope.loggedInUser.firstName}"></c:out>!
	</p>
	<form action="<c:out value="${pageContext.servletContext.contextPath}" />/logout" method="post">
		<input type="submit" value="Logout" class="btn btn-secondary">
	</form>
</body>
</html>