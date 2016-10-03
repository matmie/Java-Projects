var choirMemberApp = angular.module('choirMemberApp', []);

choirMemberApp.controller('choirMemberCtrl', function($scope, $http, $location, $anchorScroll) {

	$scope.refreshChoirMembers = function() {
		$http.get('/restapp/membersList/getAll').success(function(data) {
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
		var res = $http.post('/restapp/membersList/add', dataToSend);
		res.success(function(data) {
			$scope.refreshChoirMembers();
			$scope.choirMemberName = "";
			$scope.choirMemberPhoneNumber = "";
			$scope.cancelAddingMember();
		});
		res.error(function(data) {
			console.log("failure message: " + JSON.stringify({
				data : data
			}));
		})
	};
	$scope.updateChoirMembers = function() {
		var dataToSend = JSON.stringify({
			choirMemberId : $scope.choirMemberId,
			choirMemberName : $scope.choirMemberName,
			choirMemberPhoneNumber : $scope.choirMemberPhoneNumber
		});
		var choirMemberOldId = document.getElementById("hiddenInput").getAttribute("value");
		var ret = $http.put('/restapp/membersList/update/' + choirMemberOldId,
				dataToSend);
		ret.success(function(data) {
			$scope.refreshChoirMembers();
			$scope.choirMemberName = "";
			$scope.choirMemberPhoneNumber = "";
			$scope.choirMemberId = "";
			$scope.cancelAddingMember();
		});
		ret.error(function(data) {
			console.log("failure message: " + JSON.stringify({
				data : data
			}));
		});
	};

	$scope.deleteFromChoirMemebers = function(choirMemberId) {
		$http.put('/restapp/membersList/delete/' + choirMemberId).success(
				function(data) {
					$scope.refreshChoirMembers();
				});
	};
	$scope.getAddingSection = function() {
		document.getElementById("addingSection").setAttribute("style", "");
		document.getElementById("aAdd").setAttribute("style","");
		document.getElementById("aUpdate").setAttribute("style","display:none;");
		document.getElementById("inputID").setAttribute("style","width:70px; display: none;");
		$scope.scrollTo('inputID');
		$scope.choirMemberName = "";
		$scope.choirMemberPhoneNumber = "";
		$scope.choirMemberId = "";
	};
	$scope.cancelAddingMember = function() {
		document.getElementById("addingSection").setAttribute("style",
				"display:none;");
		document.getElementById("inputID").setAttribute("style","width:70px; display:none;");
		
	};
	$scope.getUpdateSection = function(choirMemberId, choirMemberName, choirMemberPhoneNumber){
		document.getElementById("addingSection").setAttribute("style", "");
		document.getElementById("inputID").setAttribute("style","width:70px;");
		document.getElementById("aAdd").setAttribute("style","display:none;");
		document.getElementById("aUpdate").setAttribute("style","");
		document.getElementById("hiddenInput").setAttribute("value", choirMemberId);
		$scope.choirMemberId = choirMemberId;
		$scope.choirMemberName = choirMemberName;
		$scope.choirMemberPhoneNumber = choirMemberPhoneNumber;
		$scope.scrollTo('inputID');
	};
	
	$scope.scrollTo = function(scrollLocation){
		$location.hash(scrollLocation);
		$anchorScroll();
	};

});
