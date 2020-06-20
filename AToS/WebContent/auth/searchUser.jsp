<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="height: 100%;">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<title>User Search</title>
</head>
<body style="height: 100%;">
	<div class="container">
		<jsp:include page="navigation.jsp" flush="true">
			<jsp:param name="selectedItem" value="searchUser" />
		</jsp:include>
		<h1>User Search</h1>
		<c:if test="${saveSuccessful}">
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Filter successfully created</strong>
			</div>
		</c:if>
		<c:if test="${deleteSuccessful}">
			<div class="alert alert-primary alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Filter deleted successfully</strong>
			</div>
		</c:if>
		<form action="searchUserAction" method="post">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Filter Name</th>
						<th>Interest</th>
						<th>City</th>
						<th>Gender</th>
						<th>Age From</th>
						<th>Age To</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="filterItem" items="${filters}">
						<tr>
							<td>${filterItem.displayName}</td>
							<td>${interestMap.get(filterItem.interestId)}</td>
							<td>${cityMap.get(filterItem.cityId)}</td>
							<td>${genderMap.get(filterItem.genderId)}</td>
							<td>${filterItem.ageFrom}</td>
							<td>${filterItem.ageTo}</td>
							<td><input type="submit" value="Delete" class="btn btn-danger float-right" name="delete_${filterItem.searchUserFilterId}"></td>
							<td><input type="submit" value="Execute" class="btn btn-primary float-right" name="execute_${filterItem.searchUserFilterId}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<a href="<c:out value="${pageContext.servletContext.contextPath}" />/loadCreateUserFilter" class="btn btn-primary">Create New Filter</a>
	</div>
</body>
</html>