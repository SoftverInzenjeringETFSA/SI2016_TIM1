(function () {
    'use strict';

    app.controller('advertsListController',
        ['$scope', '$routeParams', 'advertService',
            function ($scope, $routeParams, advertService){

                $scope.adverts = [];

                advertService.getAdverts()
                    .then(function(response){
                            $scope.adverts = response.data;
                            //alert(response);
                        }
                    );

                $scope.advertsByCategory = function(){
                    advertService.getAdvertsByCategory($routeParams.categoryId)
                        .then(function(response){
                                $scope.adverts = response.data;
                            }
                        );
                }

                $scope.advertsByOwner = function(){
                    advertService.getAdvertsByCategory($routeParams.ownerId)
                        .then(function(response){
                                $scope.adverts = response.data;
                            }
                        );
                }

                $scope.advertsWithReport = function(){
                    advertService.getAdvertsWithReport()
                        .then(function(response){
                                $scope.adverts = response.data;
                            }
                        );
                }

            }
        ]
    );

}());
