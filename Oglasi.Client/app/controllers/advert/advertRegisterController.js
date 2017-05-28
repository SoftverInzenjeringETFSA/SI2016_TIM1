(function () {
    'use strict';

    app.controller('advertRegisterController',
        ['$scope', 'advertService', 'categoryService', 'userAccountService',
            function ($scope, advertService, categoryService, userAccountService) {

                userAccountService.details()
                    .then(function (response) {
                        var user=response.data;
                        var userId=user==null ? null : user.id;
                        $scope.advert = {
                            title:null, description:null, categoryId:null, ownerId:userId,
                            contactShared:true, categorySpecValues:[]
                        };
                    });

                categoryService.getCategories()
                    .then(function (response) {
                        $scope.categories=response.data;
                    });

                $scope.categoryIndeks = {value:""};
                $scope.category = {id:null, values:[]};

                $scope.setCategory = function () {
                    $scope.advert.categorySpecValues = [];

                    if($scope.categoryIndeks.value.length>1){}
                    else if($scope.categoryIndeks.value==""){
                        $scope.category = {id:null, values:[]}
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

                    advertService.registerAdvert($scope.advert)
                        .then(function() {
                                swal("Success", "Advert created!", "success");
                            }, function () {
                                swal("Error", "Advert not created. Check your input!", "error");
                            }
                        );
                };

            }
        ]
    );

}());
