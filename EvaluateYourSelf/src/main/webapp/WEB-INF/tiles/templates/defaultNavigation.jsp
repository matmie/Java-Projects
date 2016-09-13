<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="navigation">
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse navbar-strech">
         <form class="navbar-form navbar-right no-margin-right">
            <div class="form-group">
              <input type="text" placeholder="<spring:message code="navbar.input.search.placeholder" />" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary"><spring:message code="navbar.button.search.label" /></button>
            <button type="button" class="btn btn-default"><spring:message code="navbar.button.signin.label" /></button>
            <button type="button" class="btn btn-success"><spring:message code="navbar.button.signup.label" /></button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
</div>