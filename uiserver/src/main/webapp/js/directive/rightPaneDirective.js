(function() {
    angular.module('mehar')
        .directive('rightpane', function () {
            return {
                restrict : 'E',
                templateUrl: './js/template/rightPaneTemplate.html',
                controller: 'rightPaneController'
            };
        });
})();