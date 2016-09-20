<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>



<div class="container">
    <h1><tiles:getAsString name="viewName" /></h1>
	<c:forEach items="${infos}" var="info">
		<p>${info.key} : ${info.value}</p>
	</c:forEach>
</div>