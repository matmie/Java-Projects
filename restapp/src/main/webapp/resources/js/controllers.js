var choirMemberApp = angular.module('choirMemberApp', []);

choirMemberApp.controller('choirMemberCtrl', function($scope, $http) {

	$scope.refreshChoirMembers = function() {
		$http.get('/restapp/membersList/getAll').success(function(data) {
			$scope.choirMembers = data;
		});
	};

	$scope.initChoirMembers = function() {
		$scope.refreshChoirMembers();
	};

	$scope.addToChoirMembers = function() {
		$http.post('/restapp/membersList/add').success(function(data) {
			$scope.refreshChoirMembers();
		});
	};
	$scope.updateChoirMembers = function(choirMemberId) {
		$http.put('/restapp/membersList/update/' + choirMemberId).success(
				function(data) {
					$scope.refreshChoirMembers();
				});
	};

	$scope.deleteFromChoirMemebers = function(choirMemberId) {
		$http.put('/restapp/membersList/delete/' + choirMemberId).success(
				function(data) {
					$scope.refreshChoirMembers();
				});
	};
	$scope.getAddingSection = function() {
		document.getElementById("addingSection").setAttribute("style",
				"");
	};
	$scope.cancelAddingMember = function() {
		document.getElementById("addingSection").setAttribute("style",
				"display:none;");
	};

});
