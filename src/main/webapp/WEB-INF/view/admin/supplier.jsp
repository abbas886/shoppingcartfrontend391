<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${supplierSuccessMessage} ${supplierErrorMessage}
	<!-- create 3 text fields -->
	<form action="supplier/save/" method="post">
		<table>
			<tr>
				<td>ID</td>
				<!--  write in the if condition -->
				<td><input type="text" name='id' value="${selectedSupplier.id}"></td>

			</tr>

			<td>Name</td>

			<td><input type="text" name='name'
				value="${selectedSupplier.name}"></td>

			</tr>

			<td>Address</td>

			<td><input type="text" name='address'
				value="${selectedSupplier.address}"></td>

			<tr>
				<td><input type="submit" value='Submit'></td>
			</tr>


		</table>

	</form>

	<!--  display all the supplier -->

	<div>
		<table border="5" bgcolor="cyan">
			<tr>
				<td>Supplier ID</td>
				<td>Supplier Name</td>
				<td>Supplier Address</td>
				<td>Action</td>
			</tr>


			<c:forEach var="supplier" items="${suppliers}">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.address}</td>

					<td><a href="supplier/delete/?id=${supplier.id}">Delete</a></td>

					<td><a href="supplier/edit/?id=${supplier.id}">Edit</a></td>




				</tr>

			</c:forEach>

		</table>


	</div>











</body>
</html>