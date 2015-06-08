(function() {
    angular.module('mehar')
        .directive('footerpane', function () {
            return {
                restrict : 'E',
                templateUrl: './templates/footerPaneTemplate.html',
                controller: 'footerPaneController'
            };
        });
})();