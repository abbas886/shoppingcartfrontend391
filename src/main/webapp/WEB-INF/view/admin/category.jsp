<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${categorySuccessMessage} ${categoryErrorMessage}
	<!-- create 3 text fields -->
	<form action="category/save/" method="post">
		<table>
			<tr>
				<td>ID</td>
 <!--  write in the if condition -->
				<td><input type="text" name='id'  value="${selectedCategory.id}"></td>

			</tr>

			<td>Name</td>

			<td><input type="text" name='name' value="${selectedCategory.name}"></td>

			</tr>

			<td>Description</td>

			<td><input type="text" name='description' value="${selectedCategory.description}"></td>

			<tr>
				<td><input type="submit" value='create category'></td>
			</tr>


		</table>

	</form>

	<!--  display all the categories -->

	<div>
		<table border="5" bgcolor="cyan">
			<tr>
				<td>Category ID</td>
				<td>Category Name</td>
				<td>Category Description</td>
				<td>Action</td>
			</tr>


			<c:forEach var="category" items="${categories}">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
				
					<td><a href="category/delete/?id=${category.id}">Delete</a></td>

					<td><a href="category/edit/?id=${category.id}">Edit</a></td>


					

				</tr>

			</c:forEach>

		</table>


	</div>











</body>
</html>