<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="/Webstore/resource/js/controllers.js"></script>

<section class="container" data-ng-app="cartApp">
	<div class="row">
		<div class="col-md-5">
			<img src="<c:url value="/resource/images/${product.productId}.png"/>"
				alt="image" style="width: 100%">
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
			<h4>${product.unitPrice}PLN</h4>
			<p>
				<a href="<c:url value="/resource/pdf/${product.productId}.pdf"/>"
					class="btn btn-primary" target="_blank"> <span
					class="glyphicon-file glyphicon"></span> Podręcznik
				</a>
			</p>
			<p data-ng-controller="cartCtrl">
				<a href="#" class="btn btn-warning btn-large"
					data-ng-click="addToCart('${product.productId}')"> <span
					class="glyphicon-shopping-cart glyphicon"></span> Zamów teraz
				</a> <a href="<spring:url value="/cart" />" class="btn btn-default">
					<span class="glyphicon-hand-right glyphicon"></span> Koszyk
				</a> <a href="<spring:url value="/products" />" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span> Wstecz
				</a>

			</p>
		</div>
	</div>
</section>
