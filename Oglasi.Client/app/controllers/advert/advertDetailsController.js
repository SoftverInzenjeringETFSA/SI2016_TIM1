(function () {
    'use strict';

    // OVO JE ADNAN BABOVIC URADIOO
    app.controller('advertDetailsController',
        ['$scope', '$routeParams', 'advertService', '$location',
            function ($scope, $routeParams, advertService, $location) {

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

            }
        ]
    );

}());
