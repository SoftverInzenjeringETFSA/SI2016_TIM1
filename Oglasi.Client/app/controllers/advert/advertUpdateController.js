(function () {
    'use strict';

    app.controller('advertUpdateController',
        ['$scope', 'advertService', 'categoryService', '$routeParams',
            function ($scope, advertService, categoryService, $routeParams) {

                // hard kodirano: ownerId:"1"

                var nula = {
                    title:"", description:"", categoryId:"", ownerId:"1", contactShared:"true", categorySpecValues:[]
                };

                advertService.getAdvertDetails($routeParams.advertId)
                    .then(function (response) {
                        $scope.advert=response.data;
                    });

                console.log("advert id:"+$routeParams.advertId);
                //console.log("advert id:"+$scope.advert.id);

                categoryService.getCategories()
                    .then(function (response) {
                        $scope.categories=response.data;
                    });

                $scope.categoryIndeks = {value:""};
                $scope.category = {id:"", values:[]};
                $scope.categorySpecValues = [];

                if($scope.advert.categoryId!=""){
                    for(var i in $scope.categories){
                        if($scope.advert.categoryId==$scope.categories[i].id){
                            $scope.categoryIndeks.value=i;
                            $scope.category = $scope.categories[i];

                            break;
                        }
                    }
                }

                $scope.setCategory = function () {
                    if($scope.categoryIndeks.value==""){
                        $scope.category = {id:"", values:[]}
                    }
                    else{
                        $scope.category = $scope.categories[$scope.categoryIndeks.value];
                        console.log($scope.category);
                    }
                    $scope.categorySpecValues = [];
                };

                $scope.updateAdvert = function() {
                    $scope.advert.categoryId = $scope.category.id;

                    for(var i in $scope.category.values){
                        var title=$scope.category.values[i];
                        var valueId=$scope.category.valuesId[i];
                        var value=$scope.categorySpecValues[i];

                        $scope.advert.categorySpecValues.push({
                            value:value,
                            categorySpecId:valueId,
                            categorySpecTitle:title
                        });
                    }

                    advertService.updateAdvert($scope.advert)
                        .then(function() {
                                alert("Advert updated!");

                                $scope.advert = nula;
                                $scope.categoryIndeks = {value:""};
                                $scope.category = {id:"", values:[]}
                                $scope.categorySpecValues = [];
                            }, function () {
                                alert("Error!");

                                $scope.advert = nula;
                                $scope.categoryIndeks = {value:""};
                                $scope.category = {id:"", values:[]}
                                $scope.categorySpecValues = [];
                            }
                        );
                };
            }
        ]
    )

}());
/**
 * Created by Dell on 23.5.2017..
 */
