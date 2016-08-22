<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="metas-incl.jsp" />
<title>Produkty</title>
</head>
<body>
	<section>
		<a href="<c:url value="/j_spring_security_logout" />"
			class="btn btn-danger btn-mini pull-right"> <spring:message
				code="button.logout.label" />
		</a>
		<div class="pull-right" style="padding-right: 50px">
			<a href="?language=pl">Polski</a>|<a href="?language=nl">Holenderski</a>
		</div>
		<div class="jumbotron">
			<div class="container">
				<h1>Produkty</h1>
				<p>Dodaj produkty</p>
			</div>
		</div>
	</section>
	<section class="container">
		<!-- enctype="multipart/form-data" - Typ żądania jako multipart, aby formularz poprawnie przesyłał pliki graficzne jako jego czesc
		     enccode - wskazuje w jaki sposób mają zostac zakodowane dane przesyłane z formularza na serwer. -->
		<form:form modelAttribute="newProduct" class="form-horizontal"
			enctype="multipart/form-data">
			<form:errors cssClass="text-danger danger" path="*" element="div"/>
			<fieldset>
				<legend>Dodaj nowy produkt</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.productId.label" />
					</label>
					<div class="col-lg-10">
						<form:input path="productId" id="productId" type="text"
							class="form:input-large" />
							<form:errors cssClass="text-danger" path="productId"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">
						<spring:message code="addProduct.form.name.label" />
					</label>
					<div class="col-lg-10">
						<form:input path="name" id="name" type="text"
							class="form:input-large" />
						<form:errors cssClass="text-danger" path="name"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitPrice">
						<spring:message code="addProduct.form.unitPrice.label" />
					</label>
					<div class="col-lg-10">
						<form:input path="unitPrice" id="unitPrice" type="text"
							class="form:input-large" />
						<form:errors cssClass="text-danger" path="unitPrice"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="description">
						<spring:message code="addProduct.form.description.label" />
					</label>
					<div class="col-lg-10">
						<form:textarea path="description" id="description" rows="2" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="manufacturer">
						<spring:message code="addProduct.form.manufacturer.label" />
					</label>
					<div class="col-lg-10">
						<form:input path="manufacturer" id="manufacturer" type="text"
							class="form:input-large"  />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="category">
						<spring:message code="addProduct.form.category.label" />
					</label>
					<div class="col-lg-10">
						<form:input path="category" id="category" type="text"
							class="form:input-large" />
						<form:errors cssClass="text-danger" path="category" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
						<spring:message code="addProduct.form.unitsInStock.label" />
					</label>
					<div class="col-lg-10">
						<form:input path="unitsInStock" id="unitsInStock" type="text"
							class="form:input-large" />
						<form:errors cssClass="text-danger" path="unitsInStock"/>
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
					<label class="control-label col-lg-2 col-lg-2" for="condition">
						<spring:message code="addProduct.form.condition.label" />
					</label>
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="New" />
						<spring:message code="addProduct.form.condition.new.label" />
						<form:radiobutton path="condition" value="Old" />
						<spring:message code="addProduct.form.condition.old.label" />
						<form:radiobutton path="condition" value="Refurbished" />
						<spring:message code="addProduct.form.condition.refurbished.label" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productImage">
						<spring:message code="addProduct.form.productImage.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="productImage" path="productImage" type="file"
							class="form:input-large" />
						<form:errors cssClass="text-danger" path="productImage"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productPdf">
						<spring:message code="addProduct.form.productPdf.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="productPdf" path="productPdf" type="file"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Dodaj" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>