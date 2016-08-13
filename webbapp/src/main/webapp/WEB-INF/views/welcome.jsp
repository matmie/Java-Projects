<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html >
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<link rel="stylesheet"
			href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Witaj</title>
	</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>				
			</div>
		</div>
	</section>
</body>
</html>