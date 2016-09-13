<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%-- 		<meta name="description" content="<tiles:insertAttribute name="page_description"/>"> --%>
		<link rel="stylesheet" href="<spring:eval expression="@properties.getProperty('portal.bootstrapHttpCssHref')" />"
		      integrity="<spring:eval expression="@properties.getProperty('portal.bootstrapHttpCssIntegrity')" />"
		      crossorigin="<spring:eval expression="@properties.getProperty('portal.bootstrapHttpCssCrossorigin')" />" />
		<link rel="stylesheet" href="<spring:eval expression="@properties.getProperty('portal.bootstrapHttpThemeCssHref')" />"
		      integrity="<spring:eval expression="@properties.getProperty('portal.bootstrapHttpThemeCssIntegrity')" />"
		      crossorigin="<spring:eval expression="@properties.getProperty('portal.bootstrapHttpThemeCssCrossorigin')" />" />
		<script src="<spring:eval expression="@properties.getProperty('portal.bootstrapHttpJsSrc')" />" 
		        integrity="<spring:eval expression="@properties.getProperty('portal.bootstrapHttpJsIntegrity')" />"
		        crossorigin="<spring:eval expression="@properties.getProperty('portal.bootstrapHttpJsCrossorigin')" />">
		</script>

	    <title>

	    </title>
	</head>

	<body>
	  <tiles:insertAttribute name="default_Header"/>
	  <tiles:insertAttribute name="default_Navigation"/>
	  <tiles:insertAttribute name="default_Content" />
	  <tiles:insertAttribute name="default_Footer" />
	</body>
</html>
