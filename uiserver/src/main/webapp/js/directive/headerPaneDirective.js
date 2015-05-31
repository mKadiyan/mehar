(function() {
    angular.module('mehar', [])
        .directive('headerpane', function () {
            return {
                restrict : 'E',
                templateUrl: './js/template/headerPaneTemplate.html',
                controller: 'headerPaneController'
            };
        });
})();