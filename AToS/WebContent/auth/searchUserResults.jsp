<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.time.Period"%>
<%@ page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html style="height: 100%;">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<title>User Search Results</title>
</head>
<body style="height: 100%;">
	<div class="container">
		<jsp:include page="navigation.jsp" flush="true">
			<jsp:param name="selectedItem" value="searchUser" />
		</jsp:include>
		<h1>User Search Results</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Username</th>
					<th>Full name</th>
					<th>Age</th>
					<th>Gender</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${userInfos.isEmpty()}">
					<tr>
						<td colspan="5" class="text-center">No matches found</td>
					</tr>
				</c:if>
				<c:forEach var="userInfo" items="${userInfos}">
					<tr>
						<td>${userInfo.username}</td>
						<td><c:if test="${userInfo.showAllDetails}">
								${userInfo.lastName}&nbsp;${userInfo.firstName}
							</c:if></td>
						<td><c:if test="${userInfo.showAllDetails}">
								${Period.between(userInfo.dateOfBirth, LocalDate.now()).getYears()}
							</c:if></td>
						<td><c:if test="${userInfo.showAllDetails}">
								${genderMap.get(userInfo.genderId)}
							</c:if></td>
						<td>
							<form action="<c:out value="${pageContext.servletContext.contextPath}" />/loadViewProfile" method="post">
								<input type="hidden" name="username" value="${userInfo.username}">
								<input type="submit" value="View&nbsp;Profile" class="btn btn-warning float-right">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>