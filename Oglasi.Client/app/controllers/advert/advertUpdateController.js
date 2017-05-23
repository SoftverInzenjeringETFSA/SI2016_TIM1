(function () {
    'use strict';

    app.controller('advertUpdateController',
        ['$scope', 'advertService',
            function ($scope, advertService) {/*

                // hard kodirano: ownerId:"0"
                $scope.advert = {
                    title:"", description:"", categoryId:"", ownerId:"0", contactShared:"true", categorySpecValues:[]
                };

                // hard kodirano
                $scope.categories = [
                    {id:"1", title:"Title 1", values:["Value 1.1", "Value 1.2"]},
                    {id:"2", title:"Title 2", values:["Value 2.1", "Value 2.2"]},
                    {id:"3", title:"Title 3", values:["Value 3.1", "Value 3.2"]}
                ];

                $scope.categoryIndeks = {value:"0"};
                $scope.category = $scope.categories[$scope.categoryIndeks.value];
                $scope.categorySpecValues = [];

                $scope.setCategory = function () {
                    $scope.category = $scope.categories[$scope.categoryIndeks.value];
                    $scope.categorySpecValues = [];
                };

                $scope.registerAdvert = function() {
                    $scope.advert.categoryId = $scope.category.id;

                    for (var i in $scope.category.values) {
                        var title = $scope.category.values[i];
                        var value = $scope.categorySpecValues[i];
                        // hard kodirano: categorySpecId:"0"
                        $scope.advert.categorySpecValues.push({
                            value: value,
                            categorySpecId: "0",
                            categorySpecTitle: title
                        });
                    }

                    advertService.updateAdvert($scope.advert)
                        .then(function () {
                                alert("Advert updated!");
                                for (var i in $scope.category.values) {
                                    $scope.advert.categorySpecValues.pop();
                                }
                            }, function () {
                                alert("Error!");
                                for (var i in $scope.category.values) {
                                    $scope.advert.categorySpecValues.pop();
                                }
                            }
                        );
                }
            */
            }
        ]
    )

}());
/**
 * Created by Dell on 23.5.2017..
 */
