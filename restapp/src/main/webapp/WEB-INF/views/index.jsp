<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="pl">
	<head>
		<meta charset="utf-8">
		<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title><spring:message code="index.title" /></title>
		
		<link href="http://getbootstrap.com/dist/css/bootstrap.css"
			rel="stylesheet">
		
		<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"
			rel="stylesheet">
		
		<script
			src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
		<script src="/restapp/resource/js/controllers.js"></script>
	
	</head>

	<body>
		<div class="container">
			<div class="header">
				<h3 class="text-muted">
					<spring:message code="index.title" />
				</h3>
			</div>
		</div>
		<section class="container" ng-app="choirMemberApp">
			<div ng-controller="choirMemberCtrl" ng-init="initChoirMembers()">
				<table class="table table-hover">
					<tr>
						<th><spring:message code="choirMembersList.choirMember.id" /></th>
						<th><spring:message code="choirMembersList.choirMember.name" /></th>
						<th><spring:message code="choirMembersList.choirMember.phone" /></th>
						<th><spring:message code="choirMembersList.choirMember.action" /></th>
					</tr>
					<tr ng-repeat="choirMember in choirMembers">
						<td>{{choirMember.choirMemberId}}</td>
						<td>{{choirMember.choirMemberName}}</td>
						<td>{{choirMember.choirMemberPhoneNumber}}</td>
						<td><a href="#" class="label label-danger"
							ng-click="deleteFromChoirMemebers(choirMember.choirMemberId)"> <span
								class="glyphicon glyphicon-remove"></span><spring:message code="choirMembersList.choirMember.delete" />
						</a>
						<a href="#" class="label label-warning" style="margin-left : 10px;"
							ng-click="updateChoirMembers(chourMember.choirMemberId)"> <span
								class="glyphicon glyphicon-ok"></span><spring:message code="choirMembersList.choirMember.update" />
						</a></td>
					</tr>
					<tr id="addingSection" style="display:none;">
						<td>
							<input type="number" class ="form:input-large" style="width:70px;" placeholder="<spring:message code="choirMembersList.choirMember.id"/>"/>
						</td>
						<td>
							<input type="text" class = "form:input-large" placeholder="<spring:message code="choirMembersList.choirMember.name"/>"/>
						</td>
						<td>
							<input type="text" class = "form:input-large" placeholder="<spring:message code="choirMembersList.choirMember.phone"/>"/>
						</td>
						<td>
							<a href="#" class="label label-success" style="margin-left : 10px;"
								ng-click="addToChoirMembers()"> <span
									class="glyphicon glyphicon-ok"></span><spring:message code="choirMembersList.choirMember.add" />
							</a>
							<a href="#" class="label label-danger" style="margin-left : 10px;"
								ng-click="cancelAddingMember()"> <span
									class="glyphicon glyphicon-remove"></span><spring:message code="choirMembersList.choirMember.cancel" />
							</a>
						</td>
					</tr>
				</table>
				<a href="#" class="label label-primary" ng-click="getAddingSection()"> <span
								class="glyphicon glyphicon-plus"></span><spring:message code="choirMembersList.choirMember.create" />
				</a>
			</div>
			
			<!-- <table class="table table-hover">
				
			</table> -->
		</section>
	</body>
</html>



