(function() {
    angular.module('mehar', [])
        .directive('headerpane', function () {
            return {
                restrict : 'E',
                templateUrl: './template/headerPaneTemplate.html',
                controller: 'headerPaneController'
            };
        });
})();