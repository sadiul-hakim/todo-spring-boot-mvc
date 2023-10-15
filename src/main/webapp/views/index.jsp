<%@page import="com.hakim.model.Todo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%
List<Todo> todos = (List<Todo>) request.getAttribute("todos");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container">
			<a class="navbar-brand" href="#">TODO</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<form class="d-flex ms-auto" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>

	<!-- Navbar Ends -->

	<!-- Main Body -->

	<div class="container mt-5 bg-light p-4">

		<form class="d-flex justify-content-between" method="post"
			action="/save">
			<input type="text" class="form-control" name="content" />
			<button class="btn btn-primary mx-2">Add</button>
		</form>
		<!-- Input field ends -->

		<div class="mt-5">
			<ul class="list-group">
				<%
				for (Todo todo : todos) {
				%>

				<li
					class="list-group-item text-primary lead d-flex justify-content-between align-items-center">
					<p><%=todo.getContent()%>
					</p>
					<p><%=todo.getDate()%>
					</p>
					<div class="d-flex justify-content-around align-items-center">
						<i class="bi bi-pencil-square"></i> 
						<a class="bi bi-trash text-danger" href="/delete/<%= todo.getId()%>"></a>
					</div>
				</li>

				<%
				}
				%>
			</ul>
		</div>

	</div>

</body>
</html>