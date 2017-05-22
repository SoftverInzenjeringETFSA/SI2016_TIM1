(function () {
    'use strict';

    app.controller('advertRegisterController',
        ['$scope', '$routeParams', 'advertService',
            function ($scope, $routeParams, advertService) {

                $scope.advert = {};

                $scope.registerAdvert = function() {
                    advertService.registerAdvert($scope.advert)
                        .then(function(response) {
                                // alert(response.data);
                            }
                        );
                };

                $scope.updateAdvert = function() {
                    advertService.updateAdvert($scope.advert)
                        .then(function(response) {
                                // alert(response.data);
                            }
                        );
                };

                $scope.deleteAdvert = function() {
                    advertService.deleteAdvert($routeParams.advertId)
                        .then(function(response) {
                                // alert(response.data);
                            }
                        );
                };

            }
        ]
    )

}());
