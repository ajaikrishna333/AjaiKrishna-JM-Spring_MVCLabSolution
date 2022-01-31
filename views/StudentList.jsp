<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student Record</title>
</head>

<body>
	<div class="container">
		<hr>
		<h3>Student Record</h3>
		<hr>

		<form action="/StudentRecords/student/searchStudent"
			class="form-inline">
			<a href="/StudentRecords/student/addStudent"
				class="btn btn-primary btn-sm mb-3"> Add Student</a> <input
				type="search" name="studentName" placeholder="Student Name"
				class="form-control-sm ml-5 mb-3">
			<button type="submit" class="btn btn-success btn-sm ml-2 mb-3">Search</button>
			<a href="/StudentRecords/student/listStudents"
				class="btn btn-success btn-sm ml-2 mb-3">Clear</a>
		</form>

		<table class="table table-bordered table-striped">

			<thead class="thead-dark">
				<tr>
					<th>Student Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${sList}" var="temp">

					<tr>
						<td><c:out value="${temp.studentName}" /></td>
						<td><c:out value="${temp.department}" /></td>
						<td><c:out value="${temp.country}" /></td>
						<td><a
							href="/StudentRecords/student/updateStudent?id=${temp.id}"
							class="btn btn-info btn-sm">Update Student Details</a> <a
							href="/StudentRecords/student/deleteStudent?id=${temp.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete
								Student</a></td>
						</td>
					</tr>

				</c:forEach>

			</tbody>

		</table>

	</div>
</body>

</html>