(function() {
    angular.module('mehar')
        .directive('footerpane', function () {
            return {
                restrict : 'E',
                templateUrl: './js/template/footerPaneTemplate.html',
                controller: 'footerPaneController'
            };
        });
})();