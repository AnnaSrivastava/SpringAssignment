<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a new Book</title>
<style type="text/css">
	.error{
		color:#EE1313;
	}
</style>
</head>
<body>
<form:form action="addbook" method="post" modelAttribute="book">
	<form:hidden path="id"/><br/>
	Enter isbn: <form:input path="isbn"/><form:errors path="isbn" class="error"/><br/>
	Enter title: <form:input path="title"/><form:errors path="title" class="error"/><br/>
	Enter author: <form:input path="author"/><form:errors path="author" class="error"/><br/>
	Enter Book Type: <form:select path="bookType" items="${booktypes}"/><br/>
	Enter price: <form:input path="price"/><form:errors path="price" class="error"/><br/>
	Enter book publish date:<form:input path="pubDate"/><form:errors path="pubDate" class="error"/><br/>
	<input type="submit">
</form:form>
</body>
</html>