(function() {
var app = angular.module('mehar');
app.controller('headerPaneController', function($scope, $http) {
    console.log('I am here in controller');
    $scope.doLogin = function()
    {
     console.log('I am here in doLogin '+ $scope.loginId+'  password : '+ $scope.Password);
     myData = {"userName": $scope.loginId, "password": $scope.Password};
     $http({
           method: 'POST',
           url: 'Login',
           data: myData,
           headers: {'Content-Type': 'application/json'}
            }).success(function (data) {
                var myObj = angular.fromJson(data);
                if(myObj.status.toLowerCase() == "true")
                {
                    $scope.login = true;
                    $scope.userName = myObj.userName;

                }
                else
                {
                    alert(myObj.message);
                }

            }).error(function () {
                alert("login error");
         });
     };
    $scope.doRegistration = function() {
                          console.log('I am here in doRegistration');
    };
});
})();