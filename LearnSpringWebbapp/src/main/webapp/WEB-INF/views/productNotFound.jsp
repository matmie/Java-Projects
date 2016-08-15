<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html">
<html>
	<head>
		<jsp:include page="metas-incl.jsp"></jsp:include>
		<title>Witaj</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1 class="alert alert-danger">Brak produktu o wskazanym identyfikatorze: ${invalidProductId }.</h1>
				</div>
			</div>
		</section>
		
		<section>
			<div class="container">
				<p>${url}</p>
				<p>${exception}</p>
			</div>
			<div class="container">
				<p>
					<a href="<spring:url value="/products" />" class="btn btn-primary">
						<span class="glyphicon glyphicon-hand-left"></span> Produkty
					</a>
				</p>
			</div>
		</section>
		
	</body>
</html>