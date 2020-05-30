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
			<a class="navbar-brand" href="#"><img src="<c:out value="${pageContext.servletContext.contextPath}" />/images/logo.png" alt="logo" style="width: 60px; height: 60px;"> </a>
		</nav>
		<h1>Apes Together Strong</h1>
		<!-- 		<form action="login" class="was-validated" method="post"> -->
		<div class="row h-75">
			<div class="col"></div>
			<div class="col my-auto">
				<h2>Login</h2>
				<form action="login" method="post">
					<div class="form-group">
						<label for="username">Username:</label>
						<input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required="required">
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please fill in your username!</div>
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required="required">
						<div class="valid-feedback">Valid.</div>
						<div class="invalid-feedback">Please specify a password!</div>
					</div>
					<c:if test="${param.invalidUsernameOrPassword}">
						<p class="text-danger">Invalid username or password.</p>
					</c:if>
					<button type="submit" class="btn btn-primary" href="editProfile">Login</button>
				</form>
				<div class="mt-3">
					<a href="registration">Register</a>
				</div>
				<div class="mt-3">
					<a href="editProfile">Edit Profile</a>
				</div>
			</div>
			<div class="col"></div>
		</div>
	</div>
</body>
</html>