(function() {
    angular.module('mehar')
        .directive('middlepane', function () {
            return {
                restrict : 'E',
                templateUrl: './templates/middlePaneTemplate.html',
                controller: 'middlePaneController'
            };
        });
})();