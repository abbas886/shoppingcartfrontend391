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
	<center>
		<h2>Welcome to shopping cart</h2>
		${logoutMessage}
	</center>

	<br>
	<a href="login"> Existing userr</a>
	<a href="register"> New User</a>
	
	<a href="logout"> logout</a>
	
	<hr color="blue" size="5">
	
	<jsp:include page="product_menu.jsp"></jsp:include>
	
	
	
	<c:if test="${isAdmin==true}">
	<jsp:include page="admin/adminhome.jsp"></jsp:include>
	</c:if>
	
	
	${welcomeMessage}
	
	${errorMessage}
	${successMessage}
	
		

	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedRegister==true}">
		<jsp:include page="registration.jsp"></jsp:include>
	</c:if>
</body>
</html>