(function() {
    angular.module('mehar', [])
        .directive('headerpane', function () {
            return {
                restrict : 'E',
                templateUrl: './templates/headerPaneTemplate.html',
                controller: 'headerPaneController'
            };
        });
})();