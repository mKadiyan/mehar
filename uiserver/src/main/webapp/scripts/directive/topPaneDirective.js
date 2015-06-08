(function() {
    angular.module('mehar')
        .directive('toppane', function () {
            return {
                restrict : 'E',
                templateUrl: './templates/topPaneTemplate.html',
                controller: 'topPaneController'
            };
        });
})();