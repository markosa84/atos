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
		<h1>User Search</h1>
		<a href="<c:out value="${pageContext.servletContext.contextPath}" />/createUserFilter" class="btn btn-primary">Create New Filter</a>
	</div>
</body>
</html>