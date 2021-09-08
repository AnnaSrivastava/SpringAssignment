<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore app</title>
</head>
<body>

<table border="1">
		<thead>
			<tr>
				<th>book id</th>
				<th>book isbn</th>
				<th>book title</th>
				<th>book author</th>
				<th>book price</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="b" items="${books}">
				<tr>
					<td>${b.id}</td>
					<td>${b.isbn}</td>
					<td>${b.title}</td>
					<td>${b.author}</td>
					<td>${b.price}</td>
					<td><a href="updatebook?id=${b.id}">update book</a></td>
					<td><a href="deletebook?id=${b.id}">delete book</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<a href="addbook">Add new Book</a>
</body>
</html>