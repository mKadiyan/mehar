(function() {
    angular.module('mehar')
        .directive('leftpane', function () {
            return {
                restrict : 'E',
                templateUrl: './templates/leftPaneTemplate.html',
                controller: 'leftPaneController'
            };
        });
})();