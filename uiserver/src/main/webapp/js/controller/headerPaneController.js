(function() {
var app = angular.module('mehar');
app.controller('headerPaneController', function($scope) {
    console.log('I am here in controller');
    $scope.doLogin = function() {
                     console.log('I am here in doLogin');
                 };
    $scope.doRegistration = function() {
                          console.log('I am here in doRegistration');
                      };
});
})();