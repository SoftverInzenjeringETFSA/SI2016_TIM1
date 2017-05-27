(function () {
    'use strict';

    app.controller('advertDeleterController',
        ['$scope', '$routeParams', 'advertService',
            function ($scope, $routeParams, advertService) {

                $scope.deleteAdvert = function() {
                    advertService.deleteAdvert($routeParams.advertId)
                        .then(function() {
                                swal("Success", "Advert deleted!", "success");
                            }, function () {
                                swal("Error", "Advert not deleted!", "error");
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
