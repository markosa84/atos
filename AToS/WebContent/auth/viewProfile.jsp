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
<title>Edit Profile</title>
</head>
<body style="height: 100%;">
	<div class="container h-100">
		<jsp:include page="navigation.jsp" flush="true">
			<jsp:param name="selectedItem" value="searchUser" />
		</jsp:include>
		<div class="row h-75">
			<div class="col"></div>
			<div class="col my-auto">
				<h2>View Profile</h2>
				<form action="#" method="get">
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" class="form-control" id="username" value="${user.username}" readonly="readonly">
					</div>
					<c:if test="${!user.showAllDetails}">
						<div class="alert alert-warning">
							<strong>This user did not allow the details of the profile to be shown!</strong>
						</div>
					</c:if>
					<c:if test="${user.showAllDetails}">
						<div class="form-group">
							<label for="email">E-mail</label>
							<input type="email" class="form-control" id="email" value="${user.email}" readonly="readonly">
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="firstName">First name</label>
								<input type="text" class="form-control" id="firstName" value="${user.firstName}" readonly="readonly">
							</div>
							<div class="form-group col-md-6">
								<label for="lastName">Last name</label>
								<input type="text" class="form-control" id="lastName" value="${user.lastName}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label for="city">City</label>
							<input type="text" class="form-control" id="city" value="${cityMap.get(user.cityId)}" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="dateOfBirth">Date of Birth:</label>
							<input type="date" class="form-control" id="dateOfBirth" value="${user.dateOfBirth}" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="gender">Gender</label>
							<input type="text" class="form-control" id="gender" value="${genderMap.get(user.genderId)}" readonly="readonly">
						</div>
					</c:if>
				</form>
				<form action="loadSendMessage" method="post">
					<input type="hidden" name="username" value="${user.username}">
					<input type="submit" value="Send Message" class="btn btn-primary">
				</form>
			</div>
			<div class="col"></div>
		</div>
	</div>
</body>
</html>