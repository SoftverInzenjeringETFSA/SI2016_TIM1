(function () {
    'use strict';

    app.controller('advertsListController',
        ['$scope', '$routeParams', 'advertService',
            function ($scope, $routeParams, advertService){

                $scope.adverts = advertService.getAdverts();

                $scope.getAllAdverts = function () {
                    $scope.adverts = advertService.getAdverts();
                };

                $scope.advertsByCategory = function(){
                    $scope.adverts = advertService.getAdvertsByCategory($routeParams.categoryId);
                };

                $scope.advertsByOwner = function(){
                    $scope.adverts = advertService.getAdvertsByOwner($routeParams.ownerId)
                };

                $scope.advertsWithReport = function(){
                    $scope.adverts = advertService.getAdvertsWithReport();
                };

            }
        ]
    );

}());
