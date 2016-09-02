<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<html>
	<head>
		<jsp:include page="../../views/metas-incl.jsp" />
		<title>Składanie zamówienia anulowane!!! </title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1 class="alert alert-danger">Składanie zamówienia anulowano.</h1>
					<p>Proces składania zamówienia został anulowany! Możesz wrócic do zakupów ...</p>
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
