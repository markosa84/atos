<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="auth/sendMessage.css">
<title>Send Message</title>
</head>
<body>
	<div class="container h-100">
		<jsp:include page="navigation.jsp" flush="true">
			<jsp:param name="selectedItem" value="messages" />
		</jsp:include>
		<h1>Chat with ${username}</h1>
		<h1>History</h1>
		<div class="messagesContainer">
			<div>
				<c:forEach var="messageItem" items="${messages}">
					<c:if test="${sessionScope.loggedInUser.username.equals(messageItem.usernameFrom)}">
						<p class="text-left">
							<fmt:parseDate value="${messageItem.dateAndTime}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
							<span class="font-weight-bold"><fmt:formatDate pattern="yyyy. MM. dd. HH:mm:ss" value="${parsedDateTime}" />:</span> ${messageItem.messageText}
						</p>
					</c:if>
					<c:if test="${!sessionScope.loggedInUser.username.equals(messageItem.usernameFrom)}">
						<p class="text-right">
							<fmt:parseDate value="${messageItem.dateAndTime}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
							${messageItem.messageText} <span class="font-weight-bold">:<fmt:formatDate pattern="yyyy. MM. dd. HH:mm:ss" value="${parsedDateTime}" /></span>
						</p>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<form action="saveMessage" method="post">
			<div class="form-row align-items-center">
				<div class="col-2">
					<label for="message">Message:</label>
				</div>
				<div class="col-8">
					<input type="text" id="message" name="message" class="form-control" autofocus="autofocus">
				</div>
				<div class="col-2">
					<input type="hidden" name="usernameTo" value="${username}">
					<input type="submit" value="Send" class="btn btn-primary">
				</div>
			</div>
		</form>
	</div>
</body>
</html>