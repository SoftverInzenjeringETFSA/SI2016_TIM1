(function () {
    'use strict';

    app.controller('advertRegisterController',
        ['$scope', 'advertService', 'categoryService', 'userAccountService',
            function ($scope, advertService, categoryService, userAccountService) {

                userAccountService.details()
                    .then(function (response) {
                        var user=response.data;
                        $scope.advert = {
                            title:undefined, description:undefined, categoryId:undefined, ownerId:user.id,
                            contactShared:true, categorySpecValues:[]
                        };
                    });

                categoryService.getCategories()
                    .then(function (response) {
                        $scope.categories=response.data;
                    });

                $scope.categoryIndeks = {value:""};
                $scope.category = {id:undefined, values:[]};

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

                    advertService.registerAdvert($scope.advert)
                        .then(function() {
                                alert("Advert created!");
                            }, function () {
                                alert("Error!");
                            }
                        );
                };

            }
        ]
    );

}());
