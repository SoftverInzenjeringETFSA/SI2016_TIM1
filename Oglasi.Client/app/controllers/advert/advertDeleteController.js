(function () {
    'use strict';

    app.controller('advertDeleterController',
        ['$scope', '$routeParams', 'advertService',
            function ($scope, $routeParams, advertService) {

                $scope.deleteAdvert = function() {
                    advertService.deleteAdvert($routeParams.advertId)
                        .then(function() {
                                alert("Advert deleted!");
                            }, function () {
                                alert("Error!");
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
