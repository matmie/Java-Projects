<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html">
<html>
	<head>
		<jsp:include page="metas-incl.jsp"></jsp:include>
		<title>Produkty</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Produkty</h1>
					<p>Wszystkie produkty dostępne w naszym sklepie</p>
				</div>
			</div>
		</section>
		
		<section class = "container">
			<%int licznik = 0;%>
			<c:forEach items="${products}" var="product">
			  <%if (licznik % 4 == 0) {%>
			  	<div class = "row">
			  <%} %>
				  <div class="col-md-3" style="padding-bottom: 15px">
				  	<div class="thumbnail"> 
				  		<a href=<spring:url value="/products/product?id=${product.productId}"/>>
				  	    	<img src="<c:url value="/resource/images/${product.productId}.png"/>" alt="image" style="width: 100%">
				  	    </a>
				  		<div class="caption">
				  			<h3>${product.name}</h3>
				  			<p>${product.description}</p>
				  			<p>${product.unitPrice} PLN</p>
				  			<p>Liczba sztuk w magazynie: ${product.unitsInStock}</p>
				  			<p>
				  				<a href=<spring:url value="/products/product?id=${product.productId}"/> class="btn btn-primary">
				  					<span class="glyphicon-info-sign glyphicon"></span> Szczegóły
				  				</a>
				  				<a href="<c:url value="/resource/pdf/${product.productId}.pdf"/>" class="btn btn-primary" target="_blank">
				  					<span class="glyphicon-file glyphicon"></span> Podręcznik
				  				</a>
				  			</p>
				  		</div>
				  	</div>
				  </div>
			  <%if(licznik % 4 == 3 ){%>
			  	</div>
			  <%} %>
			  <%licznik++;%>
			</c:forEach> 
		</section>
		
	</body>
</html>