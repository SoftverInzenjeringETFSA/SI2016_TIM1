(function () {
    'use strict';

    // OVO JE ADNAN BABOVIC URADIOO
    app.controller('advertDetailsController',
        ['$scope', '$routeParams', 'advertService',
            function ($scope, $routeParams, advertService) {

                  $scope.advert = advertService.getAdvertDetails($routeParams.advertId);

            }
        ]
    );

}());
