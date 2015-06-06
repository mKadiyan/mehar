(function() {
    angular.module('mehar')
        .directive('leftpane', function () {
            return {
                restrict : 'E',
                templateUrl: './js/template/leftPaneTemplate.html',
                controller: 'leftPaneController'
            };
        });
})();