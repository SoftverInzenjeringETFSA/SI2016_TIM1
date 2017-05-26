(function () {
    'use strict';

    app.controller('advertUpdateController',
        ['$scope', 'advertService', 'categoryService', '$routeParams',
            function ($scope, advertService, categoryService, $routeParams) {

                // korisnik id se podrazumijeva iz oglasa

                advertService.getAdvertDetails($routeParams.advertId)
                    .then(function (response) {
                        $scope.advert=response.data;

                        categoryService.getCategories()
                            .then(function (response) {
                                $scope.categories=response.data;

                                $scope.categoryIndeks = {value:""};
                                $scope.category = {id:undefined, values:[]};

                                if(angular.isDefined($scope.advert.categoryId)){
                                    for(var i in $scope.categories){
                                        if($scope.advert.categoryId==$scope.categories[i].id){
                                            $scope.categoryIndeks.value=i;
                                            $scope.category = $scope.categories[i];

                                            break;
                                        }
                                    }
                                }
                            });
                    });

                $scope.setCategory = function () {
                    $scope.advert.categorySpecValues = [];

                    if($scope.categoryIndeks.value.length>1){}
                    else if($scope.categoryIndeks.value==""){
                        $scope.category = {id:undefined, values:[]}
                    }
                    else{
                        $scope.category = $scope.categories[$scope.categoryIndeks.value];
                    }
                };

                $scope.saveAdvert = function() {
                    $scope.advert.categoryId = $scope.category.id;

                    for(var i in $scope.category.values){
                        $scope.advert.categorySpecValues[i].categorySpecTitle=$scope.category.values[i];
                        $scope.advert.categorySpecValues[i].categorySpecId=$scope.category.valuesId[i];
                    }

                    advertService.updateAdvert($scope.advert)
                        .then(function() {
                                alert("Advert updated!");
                            }, function () {
                                alert("Error!");
                            }
                        );
                };
            }
        ]
    );

}());
/**
 * Created by Dell on 23.5.2017..
 */
