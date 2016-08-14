<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="metas-incl.jsp" />
		<title>Produkty</title>
	</head>
	<body>
		<section>
		    <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">
		    	<spring:message code="button.logout.label"/>
		    </a>
			<div class="jumbotron">
				<div class="container">
					<h1>Produkty</h1>
					<p>Dodaj produkty</p>
				</div>
			</div>
		</section>
		<section class="container">
			<form:form modelAttribute="newProduct" class="form-horizontal">
				<fieldset>
					<legend>Dodaj nowy produkt</legend>
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="productId">
							<spring:message code="addProduct.form.productId.label"/>
						</label>
						<div class="col-lg-10">
							<form:input path="productId" id="productId" type="text" class="form:input-large"/>						
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="name">Nazwa</label>
						<div class="col-lg-10">
							<form:input path="name" id="name" type="text" class="form:input-large"/>						
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="unitPrice">Cena</label>
						<div class="col-lg-10">
							<form:input path="unitPrice" id="unitPrice" type="text" class="form:input-large"/>						
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="description">Opis</label>
						<div class="col-lg-10">
							<form:textarea path="description" id="description" rows="2"/>						
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="manufacturer">Producent</label>
						<div class="col-lg-10">
							<form:input path="manufacturer" id="manufacturer" type="text" class="form:input-large"/>						
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="category">Kategoria produktu</label>
						<div class="col-lg-10">
							<form:input path="category" id="category" type="text" class="form:input-large"/>						
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Liczba dostępnych sztuk</label>
						<div class="col-lg-10">
							<form:input path="unitsInStock" id="unitsInStock" type="text" class="form:input-large"/>						
						</div>
					</div>
					<%-- <div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="unitsInOrder">Liczba zamawianych sztuk</label>
						<div class="col-lg-10">
							<form:input path="unitsInOrder" id="unitsInOrder" type="text" class="form:input-large"/>						
						</div>
					</div> --%>
					<%-- <div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="discontinued">Wycofany</label>
						<div class="col-lg-10">
							<form:checkbox path="discontinued" id="discontinued"/>						
						</div>
					</div> --%>
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="condition">Stan</label>
						<div class="col-lg-10">
							<form:radiobutton path="condition" value="New"/>Nowy
							<form:radiobutton path="condition" value="Old"/>Używany
							<form:radiobutton path="condition" value="Refurbished"/>Odnowiony						
						</div>
					</div> 
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj" />					
						</div>
					</div>
				</fieldset>
			</form:form>
		</section>
	</body>
</html>