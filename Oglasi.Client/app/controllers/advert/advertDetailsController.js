(function () {
    'use strict';

    // OVO JE ADNAN BABOVIC URADIOO
    app.controller('advertDetailsController',
        ['$scope', '$routeParams', 'advertService', '$location', '$route',
            function ($scope, $routeParams, advertService, $location, $route) {

                $scope.advert = {};

                advertService.getAdvertDetails($routeParams.advertId)
                    .then(function (response) {
                       $scope.advert=response.data;
                    });

                $scope.deleteAdvert = function() {
                    advertService.deleteAdvert($routeParams.advertId)
                        .then(function() {
                                alert("Advert deleted!");
                                $location.url("/");
                            }, function () {
                                alert("Error!");
                            }
                        );
                };

                $scope.setPriority = function () {
                    advertService.changePriority($scope.advert.id)
                        .then(function () {
                            alert("Priority changed!");
                            $route.reload();
                        }, function () {
                            alert("Error!");
                        });
                };

            }
        ]
    );

}());
