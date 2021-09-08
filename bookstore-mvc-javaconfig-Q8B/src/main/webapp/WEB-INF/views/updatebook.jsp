<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update a Book</title>
</head>
<body>
<form:form action="addbook" method="post" modelAttribute="book">
	<form:hidden path="id"/><br/>
	Enter isbn: <form:input path="isbn" readonly="true"/><br/>
	Enter title: <form:input path="title" readonly="true"/><br/>
	Enter author: <form:input path="author" readonly="true"/><br/>
	Enter price: <form:input path="price"/><br/>
	<input type="submit">
</form:form>
</body>
</html>