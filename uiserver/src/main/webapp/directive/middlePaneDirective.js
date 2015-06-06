(function() {
    angular.module('mehar')
        .directive('middlepane', function () {
            return {
                restrict : 'E',
                templateUrl: './js/template/middlePaneTemplate.html',
                controller: 'middlePaneController'
            };
        });
})();