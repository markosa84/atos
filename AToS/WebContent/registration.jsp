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
<title>Login</title>
</head>
<body style="height: 100%;">
	<div class="container h-100">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<a class="navbar-brand" href="#"> <img src="images/logo.png" alt="logo" style="width: 60px; height: 60px;">
			</a>
		</nav>
		<h1>Apes Together Strong</h1>
		<c:out value="hello"></c:out>
		<div class="row h-75">
			<div class="col"></div>
			<div class="col my-auto">
				<h2>Register</h2>
				<!-- <form action="login" class="was-validated" method="post"> -->
				<form action="register" method="post">
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
					</div>
					<div class="form-group">
						<label for="email">E-mail</label>
						<input type="email" class="form-control" id="email" name="email" placeholder="Enter e-mail">
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
					</div>
					<div class="form-group">
						<label for="passwordConfirm">Password Confirmation</label>
						<input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm" placeholder="Enter password again">
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="firstName">First name</label>
							<input type="text" class="form-control" id="firstName" name="firstName">
						</div>
						<div class="form-group col-md-6">
							<label for="lastName">Last name</label>
							<input type="text" class="form-control" id="lastName" name="lastName">
						</div>
					</div>
					<div class="form-group">
						<label for="city">City:</label>
						<select class="form-control" id="city" name="city">
							<c:forEach var="city" items="${cities}">
								<option value="${city.cityId}">${city.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="dateOfBirth">Date of Birth:</label>
						<input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" placeholder="Enter birth date">
					</div>
					<div class="form-group">
						<label for="gender">Gender:</label>
						<select class="form-control" id="gender" name="gender">
							<option>Female</option>
							<option>Male</option>
						</select>
					</div>
					<div class="form-group">
						<div class="form-check">
							<label class="form-check-label" data-toggle="tooltip" title="Selecting this will make you show up in searches.">
								<input type="checkbox" class="form-check-input" name="showMeInSearch" value="">
								Show me in search
							</label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-check">
							<label class="form-check-label" data-toggle="tooltip" title="Selecting this will make all your personal data to show up for others on your profile page.">
								<input type="checkbox" class="form-check-input" name="showAllDetails" value="">
								Show all details
							</label>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Register</button>
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
</body>
</html>