<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<footer class="footer">
	<div class="container">
		<ul class="footer-links">
			<li><a href="/about" target="_blank"><spring:message code="footer.about.label" /></a></li>
			<li><a href="/regulations" target="_blank"><spring:message code="footer.regulations.label" /></a></li>
			<li></li>
			<li></li>
		</ul>
	</div>

</footer>