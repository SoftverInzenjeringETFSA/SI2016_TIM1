(function () {
    'use strict';

    app.controller('advertsListController',
        ['$scope', '$routeParams', 'advertService', 'categoryService',
            function ($scope, $routeParams, advertService, categoryService){

                advertService.getAdverts()
                    .then(function (response) {
                        $scope.adverts=response.data;
                    });

                categoryService.getCategories()
                    .then(function (response) {
                        $scope.categories=response.data;
                    });

                $scope.categoryIndeks = {value:"-1"};

                $scope.setCategory = function () {
                    if($scope.categoryIndeks.value=="-1"){
                        $scope.getAllAdverts();
                    }
                    else{
                        $scope.category = $scope.categories[$scope.categoryIndeks.value];
                        $scope.advertsByCategory($scope.category.id);
                    }
                };

                $scope.getAllAdverts = function () {
                    advertService.getAdverts()
                        .then(function (response) {
                            $scope.adverts=response.data;
                        })
                };

                $scope.advertsByCategory = function(categoryId){
                    advertService.getAdvertsByCategory(categoryId)
                        .then(function (response) {
                            $scope.adverts=response.data;
                        });
                };

                $scope.advertsByOwner = function(){
                    advertService.getAdvertsByOwner($routeParams.ownerId)
                        .then(function (response) {
                            $scope.adverts=response.data;
                        })
                };

                $scope.advertsWithReport = function(){
                    advertService.getAdvertsWithReport()
                        .then(function (response) {
                            $scope.adverts=response.data;
                        })
                };


            }
        ]
    );

}());
