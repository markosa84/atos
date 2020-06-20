<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark" id="mainNav">
	<div class="container">
		<a class="navbar-brand" href="<c:out value="${pageContext.servletContext.contextPath}" />/auth/home.jsp"><img src="<c:out value="${pageContext.servletContext.contextPath}" />/images/logo.png" alt="logo" style="width: 60px; height: 60px;"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse align-items-center" id="navbarResponsive">
			<ul class="navbar-nav mr-auto align-items-center">
				<li class="nav-item <c:out value="${param.selectedItem.equals(\"home\") ? \"active\" : \"\"}"></c:out>"><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/auth/home.jsp">Home</a></li>
				<li class="nav-item <c:out value="${param.selectedItem.equals(\"editProfile\") ? \"active\" : \"\"}"></c:out>"><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/loadEditProfile">Edit profile</a></li>
				<li class="nav-item <c:out value="${param.selectedItem.equals(\"searchUser\") ? \"active\" : \"\"}"></c:out>"><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/loadSearchUser">Search user</a></li>
				<li class="nav-item <c:out value="${param.selectedItem.equals(\"manageMeetups\") ? \"active\" : \"\"}"></c:out>"><a class="nav-link" href="#">Manage Meetups</a></li>
				<li class="nav-item <c:out value="${param.selectedItem.equals(\"messages\") ? \"active\" : \"\"}"></c:out>"><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/loadMessages">Messages</a></li>
			</ul>
			<ul class="navbar-nav ml-auto align-items-center">
				<li class="nav-item"><a class="nav-link" href="<c:out value="${pageContext.servletContext.contextPath}" />/logout">Logout</a></li>
			</ul>
		</div>
	</div>
</nav>