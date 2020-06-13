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
<title>Create User Filter</title>
</head>
<body style="height: 100%;">
	<div class="container">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark" id="mainNav">
			<div class="container">
				<a class="navbar-brand" href="<c:out value="${pageContext.servletContext.contextPath}" />/auth/home.jsp"><img src="<c:out value="${pageContext.servletContext.contextPath}" />/images/logo.png" alt="logo" style="width: 60px; height: 60px;"></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse align-items-center" id="navbarResponsive">
					<ul class="navbar-nav mr-auto align-items-center">
						<li class="nav-item "><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/auth/home.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/loadProfile">Edit profile</a></li>
						<li class="nav-item active"><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/searchUser">Search user</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Manage Meetups</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Messages</a></li>
					</ul>
					<ul class="navbar-nav ml-auto align-items-center">
						<li class="nav-item"><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/logout">Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="row h-75">
			<div class="col"></div>
			<div class="col my-auto">
				<h2>Create User Filter</h2>
				<form action="saveCreateUserFilter" method="post">
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="filterName">Filter Name:</label>
							<input type="text" class="form-control<c:if test="${filterNameInvalid}"> is-invalid</c:if>" id="filterName" name="filterName" value="${filterName}">
							<c:if test="${filterNameInvalid}">
								<p class="text-danger">Invalid filter name.</p>
							</c:if>
						</div>
					</div>
					<div class="form-group">
						<label for="gender">Interest:</label>
						<select class="form-control<c:if test="${interestInvalid}"> is-invalid</c:if>" id="interest" name="interest">
							<option <c:if test="${interest == -1}">selected="selected"</c:if> value="-1">Please select interest</option>
							<c:forEach var="interestItem" items="${interests}">
								<option <c:if test="${interestItem.interestId == interest}">selected="selected"</c:if> value="${interestItem.interestId}">${interestItem.name}</option>
							</c:forEach>
						</select>
						<c:if test="${interestInvalid}">
							<p class="text-danger">Invalid interest.</p>
						</c:if>
					</div>
					<div class="form-group">
						<label for="city">City:</label>
						<select class="form-control<c:if test="${cityInvalid}"> is-invalid</c:if>" id="city" name="city">
							<option <c:if test="${city == -1}">selected="selected"</c:if> value="-1">Please select your city</option>
							<c:forEach var="cityItem" items="${cities}">
								<option <c:if test="${cityItem.cityId == city}">selected="selected"</c:if> value="${cityItem.cityId}">${cityItem.name}</option>
							</c:forEach>
						</select>
						<c:if test="${cityInvalid}">
							<p class="text-danger">Invalid city.</p>
						</c:if>
					</div>
					<div class="form-group">
						<label for="gender">Gender:</label>
						<select class="form-control<c:if test="${genderInvalid}"> is-invalid</c:if>" id="gender" name="gender">
							<option <c:if test="${gender == -1}">selected="selected"</c:if> value="-1">Please select your gender</option>
							<c:forEach var="genderItem" items="${genders}">
								<option <c:if test="${genderItem.genderId == gender}">selected="selected"</c:if> value="${genderItem.genderId}">${genderItem.name}</option>
							</c:forEach>
						</select>
						<c:if test="${genderInvalid}">
							<p class="text-danger">Invalid gender.</p>
						</c:if>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="ageFrom">Age From:</label>
							<input type="number" class="form-control<c:if test="${ageFromInvalid}"> is-invalid</c:if>" id="ageFrom" name="ageFrom" value="${ageFrom}">
							<c:if test="${ageFromInvalid}">
								<p class="text-danger">Invalid age from.</p>
							</c:if>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="ageTo">Age To:</label>
							<input type="number" class="form-control<c:if test="${ageToInvalid}"> is-invalid</c:if>" id="ageTo" name="ageTo" value="${ageTo}">
							<c:if test="${ageToInvalid}">
								<p class="text-danger">Invalid age to.</p>
							</c:if>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Create</button>
				</form>
			</div>
			<div class="col"></div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
	</div>
</body>
</html>