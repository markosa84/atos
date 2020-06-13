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
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark" id="mainNav">
			<div class="container">
				<a class="navbar-brand" href="<c:out value="${pageContext.servletContext.contextPath}" />/auth/home.jsp"><img src="<c:out value="${pageContext.servletContext.contextPath}" />/images/logo.png" alt="logo" style="width: 60px; height: 60px;"></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse align-items-center" id="navbarResponsive">
					<ul class="navbar-nav mr-auto align-items-center">
						<li class="nav-item"><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/auth/home.jsp">Home</a></li>
						<li class="nav-item active"><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/loadProfile">Edit profile</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/loadSearchUser">Search user</a></li>
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
				<h2>Edit Profile</h2>
				<c:if test="${saveSuccessful}">
					<div class="alert alert-success alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<strong>Save successful!</strong>
					</div>
				</c:if>
				<form action="saveProfile" method="post">
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" class="form-control<c:if test="${usernameInvalid}"> is-invalid</c:if>" id="username" name="username" placeholder="Enter username" value="${username}" readonly="readonly">
						<c:if test="${usernameInvalid}">
							<p class="text-danger">Invalid username.</p>
						</c:if>
					</div>
					<div class="form-group">
						<label for="email">E-mail</label>
						<input type="email" class="form-control<c:if test="${emailInvalid}"> is-invalid</c:if>" id="email" name="email" placeholder="Enter e-mail" value="${email}" readonly="readonly">
						<c:if test="${emailInvalid}">
							<p class="text-danger">Invalid e-mail address.</p>
						</c:if>
					</div>
					<div class="form-group">
						<label for="password">Old Password</label>
						<input type="password" class="form-control<c:if test="${oldPasswordInvalid}"> is-invalid</c:if>" id="oldPassword" name="oldPassword" placeholder="Enter old password">
						<c:if test="${oldPasswordInvalid}">
							<p class="text-danger">Invalid old password.</p>
						</c:if>
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" class="form-control<c:if test="${passwordInvalid}"> is-invalid</c:if>" id="password" name="password" placeholder="Enter password">
						<c:if test="${passwordInvalid}">
							<p class="text-danger">Invalid password.</p>
						</c:if>
					</div>
					<div class="form-group">
						<label for="passwordConfirm">Password Confirmation</label>
						<input type="password" class="form-control<c:if test="${passwordConfirmInvalid}"> is-invalid</c:if>" id="passwordConfirm" name="passwordConfirm" placeholder="Enter password again">
						<c:if test="${passwordConfirmInvalid}">
							<p class="text-danger">Invalid password confirmation.</p>
						</c:if>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="firstName">First name</label>
							<input type="text" class="form-control<c:if test="${firstNameInvalid}"> is-invalid</c:if>" id="firstName" name="firstName" value="${firstName}">
							<c:if test="${firstNameInvalid}">
								<p class="text-danger">Invalid first name.</p>
							</c:if>
						</div>
						<div class="form-group col-md-6">
							<label for="lastName">Last name</label>
							<input type="text" class="form-control<c:if test="${lastNameInvalid}"> is-invalid</c:if>" id="lastName" name="lastName" value="${lastName}">
							<c:if test="${lastNameInvalid}">
								<p class="text-danger">Invalid last name.</p>
							</c:if>
						</div>
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
						<label for="dateOfBirth">Date of Birth:</label>
						<input type="date" class="form-control<c:if test="${dateOfBirthInvalid}"> is-invalid</c:if>" id="dateOfBirth" name="dateOfBirth" placeholder="Enter birth date" value="${dateOfBirth}">
						<c:if test="${dateOfBirthInvalid}">
							<p class="text-danger">Invalid date of birth.</p>
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
					<div class="form-group">
						<div class="form-check">
							<label class="form-check-label" data-toggle="tooltip" title="Selecting this will make you show up in searches.">
								<input type="checkbox" class="form-check-input" name="showMeInSearch" value="" <c:if test="${showMeInSearch != null}">checked="checked"</c:if>>
								Show me in search
							</label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-check">
							<label class="form-check-label" data-toggle="tooltip" title="Selecting this will make all your personal data to show up for others on your profile page.">
								<input type="checkbox" class="form-check-input" name="showAllDetails" value="" <c:if test="${showAllDetails != null}">checked="checked"</c:if>>
								Show all details
							</label>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
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