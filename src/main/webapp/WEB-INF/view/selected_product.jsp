<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <form action="product/cart/add" method = "post">
<img alt="" src="${selectedProductImage}"> <br>
${selectedProduct.id}
<img alt="" src="resources/images/${selectedProduct.id}.PNG">
product name: <input type="text" disabled="disabled" name="productName" value ="${selectedProduct.name}"> <br>
price <input type="text" disabled="disabled" name="price" value="${selectedProduct.price}"> <br>
Quantity : <input type="text" name="quantity" > <br>

Description : ${selectedProduct.description} <br>

<input type="submit" value="Add to Cart">
</form> --%>

<img alt="" src="${selectedProductImage}"> <br>
${selectedProduct.id}
<img alt="" src="resources/images/${selectedProduct.id}.PNG">
product name: ${selectedProduct.name} <br>
price : ${selectedProduct.price} <br>
Description : ${selectedProduct.description} <br>

<a href="cart/add/${selectedProduct.id}">Add to Cart</a>





<c:forEach items="${products}" var="product">

${product.name}

${product.description}


${product.price}

<img alt="" src="resources/images/${product.id}.PNG">



</c:forEach>









</body>
</html>