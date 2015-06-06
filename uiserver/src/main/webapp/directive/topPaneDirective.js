(function() {
    angular.module('mehar')
        .directive('toppane', function () {
            return {
                restrict : 'E',
                templateUrl: './js/template/topPaneTemplate.html',
                controller: 'topPaneController'
            };
        });
})();