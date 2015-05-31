(function() {
var app = angular.module('mehar');
app.controller('headerPaneController', function($scope, $http) {
    console.log('I am here in controller');
    $scope.doLogin = function()
    {
     console.log('I am here in doLogin '+ $scope.Username+'  password : '+ $scope.Password);
     myData = {"userName": $scope.Username, "password": $scope.Password};
     $http({
           method: 'POST',
           url: 'Login',
           data: myData,
           headers: {'Content-Type': 'application/json'}
            }).success(function (data) {
                alert(data);
            }).error(function () {
                alert("login error");
         });
     };
    $scope.doRegistration = function() {
                          console.log('I am here in doRegistration');
    };
});
})();