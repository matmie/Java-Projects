<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<jsp:include page="../../views/metas-incl.jsp" />
<title>Dziękujemy</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger">Dziękujemy</h1>
				<p>
					Dziękujemy za złożenia zamówienia. Zostanie przesłane
					<fmt:formatDate type="date"
						value="${order.shippingDetail.shippingDate}" />
					!
				</p>
				<p>Numer Twojego zamówienia to ${order.orderId}</p>
			</div>
		</div>
	</section>

	<section>
		<div class="container">
			<p>
				<a href="<spring:url value="/products" />" class="btn btn-primary">
					<span class="glyphicon-hand-left glyphicon"></span> Produkty
				</a>
			</p>
		</div>

	</section>
</body>
</html>
