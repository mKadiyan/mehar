(function() {
    angular.module('myapp', [])
        .directive('headerpane', function () {
            return {
                restrict : 'E',
                templateUrl: './js/template/headerPaneTemplate.html'
                //controller: '../controller/headerPaneController'
            };
        });
})();