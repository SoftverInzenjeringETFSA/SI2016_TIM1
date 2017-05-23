(function () {
    'use strict';

    app.controller('advertRegisterController',
        ['$scope', 'advertService', 'categoryService',
            function ($scope, advertService, categoryService) {

                // hard kodirano: ownerId:"1"

                var nula = {
                    title:"", description:"", categoryId:"", ownerId:"1", contactShared:"true", categorySpecValues:[]
                };

                $scope.advert = nula;

                categoryService.getCategories()
                    .then(function (response) {
                        $scope.categories=response.data;
                    });

                $scope.categoryIndeks = {value:"-1"};
                $scope.categorySpecValues = [];

                $scope.setCategory = function () {
                    if($scope.categoryIndeks.value=="-1"){
                        $scope.category = {values:[]}
                    }
                    else{
                        $scope.category = $scope.categories[$scope.categoryIndeks.value];
                        console.log($scope.category);
                    }
                    $scope.categorySpecValues = [];
                };

                $scope.createAdvert = function() {
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

                    var s="";
                    for(var i in $scope.advert.categorySpecValues){
                        s+=$scope.advert.categorySpecValues[i].categorySpecTitle+" = "+
                            $scope.advert.categorySpecValues[i].value+"\n";
                    }

                    alert(
                        "Title: "+$scope.advert.title+"\n"+
                        "Description: "+$scope.advert.description+"\n"+
                        "Contact shared: "+$scope.advert.contactShared+"\n"+
                        "Category id: "+$scope.advert.categoryId+"\n"+
                        "Category specification values:"+"\n"+s
                    );

                    advertService.registerAdvert($scope.advert)
                        .then(function() {
                                alert("Advert created!");

                                $scope.advert = nula;
                                $scope.categoryIndeks = {value:"-1"};
                                $scope.categorySpecValues = [];
                            }, function () {
                                alert("Error!");

                                $scope.advert = nula;
                                $scope.categoryIndeks = {value:"-1"};
                                $scope.categorySpecValues = [];
                            }
                        );
                };

            }
        ]
    )

}());
