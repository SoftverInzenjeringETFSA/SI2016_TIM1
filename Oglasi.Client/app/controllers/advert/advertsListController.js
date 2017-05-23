(function () {
    'use strict';

    app.controller('advertsListController',
        ['$scope', '$routeParams', 'advertService',
            function ($scope, $routeParams, advertService){

                $scope.adverts = advertService.getAdverts();

                // hard kodirano
                $scope.categories = [
                    {id:"1", title:"Title 1", values:["Value 1.1", "Value 1.2"]},
                    {id:"2", title:"Title 2", values:["Value 2.1", "Value 2.2"]},
                    {id:"3", title:"Title 3", values:["Value 3.1", "Value 3.2"]}
                ];

                $scope.categoryIndeks = {value:"all"};

                $scope.getAllAdverts = function () {
                    $scope.adverts = advertService.getAdverts();
                };

                //$scope.advertsByCategory = function(){
                //    $scope.adverts = advertService.getAdvertsByCategory($routeParams.categoryId);
                //};

                $scope.advertsByOwner = function(){
                    $scope.adverts = advertService.getAdvertsByOwner($routeParams.ownerId)
                };

                $scope.advertsWithReport = function(){
                    $scope.adverts = advertService.getAdvertsWithReport();
                };

                $scope.setCategory = function () {
                    if($scope.categoryIndeks.value=="all"){
                        $scope.getAllAdverts();
                        return;
                    }
                    $scope.category = $scope.categories[$scope.categoryIndeks.value];
                    $scope.adverts = advertService.getAdvertsByCategory($scope.category.id);
                };

            }
        ]
    );

}());
