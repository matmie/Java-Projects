<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<section class="container">
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<spring:message code="login.form.title" />
						</h3>
					</div>
				</div>
				<div class="panel-body">
					<c:if test="${not empty error}">
						<div class="alert alert-danger">
							<spring:message
								code="AbstractUserDetails.AuthenticationProvider.badCredentails" />
						</div>
					</c:if>
					<form action="<c:url value="/j_spring_security_check"></c:url>"
						method="post">
						<fieldset>
							<div class="form-group">
								<input class="form-control"
									placeholder="<spring:message code="login.form.label.nazwauzytkownika"/>"
									name='j_username' type="text" />
							</div>
							<div class="form-group">
								<input class="form-control"
									placeholder="<spring:message code="login.form.label.haslo"/>"
									name='j_password' type="password" value="" />
							</div>
							<input class="btn btn-lg btn-succes btn-block" type="submit"
								value="<spring:message code="login.form.label.buttonSubmit"/>" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
