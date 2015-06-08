(function() {
    angular.module('mehar')
        .directive('rightpane', function () {
            return {
                restrict : 'E',
                templateUrl: './templates/rightPaneTemplate.html',
                controller: 'rightPaneController'
            };
        });
})();