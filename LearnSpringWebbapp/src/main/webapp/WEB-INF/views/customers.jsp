<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
	<head>
		<jsp:include page="metas-incl.jsp"></jsp:include>
		<title>Klienci</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Klienci</h1>
					<p>Wszyscy klienci zarejestrowani w naszym sklepie</p>
				</div>
			</div>
		</section>
		
		<section class = "container">
			<div class = "row">
				<c:forEach items="${customers}" var="customer">
				  <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				  	<div class="thumbnail">
				  		<div class="caption">
				  			<h3>${customer.name}</h3>
				  			<p>${customer.address}</p>
				  			<p>${customer.noOfOrdersMade}</p>
				  		</div>
				  	</div>
				  </div>
				</c:forEach> 
			</div>
		</section>
		
	</body>
</html>