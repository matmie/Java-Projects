var choirMemberApp = angular.module('choirMemberApp', []);

choirMemberApp.controller('choirMemberCtrl', function($scope, $http, $location, $anchorScroll) {

	$scope.refreshChoirMembers = function() {
		$http.get('/SimpleListManagementRestApp/membersList/getAll').success(function(data) {
			$scope.choirMembers = data;
		});
	};

	$scope.initChoirMembers = function() {
		$scope.refreshChoirMembers();
	};

	$scope.addToChoirMembers = function() {
		var dataToSend = JSON.stringify({
			choirMemberName : $scope.choirMemberName,
			choirMemberPhoneNumber : $scope.choirMemberPhoneNumber
		});
		var res = $http.post('/SimpleListManagementRestApp/membersList/add', dataToSend);
		res.success(function(data) {
			$scope.refreshChoirMembers();
			$scope.choirMemberName = "";
			$scope.choirMemberPhoneNumber = "";
			$scope.cancelAddingMember();
		});
		res.error(function(data) {
			var validationDiv = document.getElementById('validation');
			$scope.setValidationErrors(data,validationDiv);
		})
	};
	$scope.updateChoirMembers = function() {
		var dataToSend = JSON.stringify({
			choirMemberId  : $scope.choirMemberId,
			choirMemberName : $scope.choirMemberName,
			choirMemberPhoneNumber : $scope.choirMemberPhoneNumber
		});
		var ret = $http.put('/SimpleListManagementRestApp/membersList/update/' + $scope.choirMemberId,
				dataToSend);
		ret.success(function(data) {
			$scope.scrollTo('id_'+$scope.choirMemberId);
			$scope.refreshChoirMembers();
			$scope.choirMemberName = "";
			$scope.choirMemberPhoneNumber = "";
			$scope.choirMemberId = "";
			$scope.cancelAddingMember();
		});
		ret.error(function(data) {
			var validationDiv = document.getElementById('validation');
			$scope.setValidationErrors(data,validationDiv);
		});
	};

	$scope.deleteFromChoirMemebers = function(choirMemberId) {
		$scope.cancelAddingMember();
		$http.put('/SimpleListManagementRestApp/membersList/delete/' + choirMemberId).success(
				function(data) {
					$scope.refreshChoirMembers();
				});
	};
	$scope.getAddingSection = function() {
		document.getElementById("addingSection").setAttribute("style", "");
		document.getElementById("aAdd").setAttribute("style","");
		document.getElementById("aUpdate").setAttribute("style","display:none;");
		$scope.scrollTo('inputNameId');
		$scope.choirMemberName = "";
		$scope.choirMemberPhoneNumber = "";
		$scope.choirMemberId = "";
		var validationDiv = document.getElementById('validation');
		validationDiv.innerHTML = '';
	};
	$scope.cancelAddingMember = function() {
		document.getElementById("addingSection").setAttribute("style",
				"display:none;");
		var validationDiv = document.getElementById('validation');
		validationDiv.innerHTML = '';
		
	};
	$scope.getUpdateSection = function(choirMemberId, choirMemberName, choirMemberPhoneNumber){
		document.getElementById("addingSection").setAttribute("style", "");
		document.getElementById("aAdd").setAttribute("style","display:none;");
		document.getElementById("aUpdate").setAttribute("style","");
		$scope.choirMemberId = choirMemberId;
		$scope.choirMemberName = choirMemberName;
		$scope.choirMemberPhoneNumber = choirMemberPhoneNumber;
		$scope.scrollTo('inputNameId');
		var validationDiv = document.getElementById('validation');
		validationDiv.innerHTML = '';
	};
	
	$scope.scrollTo = function(scrollLocation){
		$location.hash(scrollLocation);
		$anchorScroll();
	};
	
	$scope.setValidationErrors = function(data, validationDiv){
		validationDiv.innerHTML = '';
		angular.forEach(data.errors, function(value,key){
			var el = document.createElement('H4');
			el.setAttribute("style", "color:red;")
			var textNode = document.createTextNode(value);
			el.appendChild(textNode);
			validationDiv.append(el);
		});
		$scope.scrollTo('addingButton');
	}

});
