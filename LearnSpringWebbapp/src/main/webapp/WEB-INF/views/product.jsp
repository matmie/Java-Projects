<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html">
<html>
	<head>
		<jsp:include page="metas-incl.jsp"></jsp:include>
		<title>Produkt</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Produkt</h1>
				</div>
			</div>
		</section>
		
		<section class = "container">
			<div class = "row">
				  <div class="col-md-5">
				  	<h1>${product.name}</h1>
				  	<p>${product.description}</p>
				  	<p>
				  		<strong>Kod produktu: </strong><span class="label label-warning">${product.productId}</span>
				  	</p>
				  	<p>
				  		<strong>Producent: </strong>${product.manufacturer}
				  	</p>
				  	<p>
				  		<strong>Kategoria: </strong>${product.category}
				  	</p>
				  	<p>
				  		<strong>Dostępna liczba sztuk: </strong>${product.unitsInStock}
				  	</p>
				  	<h4>${product.unitPrice} PLN</h4>
				  	<p>
				  		<a href="#" class="btn btn-warning btn-large">
				  			<span class="glyphicon-shopping-cart glyphicon"></span>
				  			Zamów teraz
				  		</a>
				  		<a href=<spring:url value="/products"/> class="btn btn-large btn-default">
				  			<span class="glyphicon-hand-left glyphicon"></span>Powrót
				  		</a>
				  	</p>
				  </div> 
			</div>
		</section>
		
	</body>
</html>