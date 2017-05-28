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

                    var status={message:"", error:false};

                    if($scope.advert.title==null || !/\S+/.test($scope.advert.title)){
                        status={message:"Title is empty.", error:true};
                    }
                    else if($scope.advert.description==null || !/\S+/.test($scope.advert.description)){
                        status={message:"Description is empty.", error:true};
                    }
                    else if($scope.advert.categoryId!=null){
                        if($scope.advert.categorySpecValues.length!=$scope.category.values.length) {
                            status={message:"Some or all category specification values are not set.", error:true};
                        }
                        else{
                            for(var i in $scope.advert.categorySpecValues){
                                if($scope.advert.categorySpecValues[i].value==null ||
                                    !/\S+/.test($scope.advert.categorySpecValues[i].value)){
                                    status={message:"Some or all category specification values are empty.", error:true};
                                    break;
                                }
                            }
                        }
                    }

                    if(status.error){
                        swal("Error", status.message, "error");
                        return;
                    }

                    for(var i in $scope.category.values){
                        $scope.advert.categorySpecValues[i].categorySpecTitle=$scope.category.values[i];
                        $scope.advert.categorySpecValues[i].categorySpecId=$scope.category.valuesId[i];
                    }

                    advertService.updateAdvert($scope.advert)
                        .then(function() {
                                swal("Success", "Advert updated!", "success");
                            }, function () {
                                swal("Error", "Advert not updated. Check your input!", "error");
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
