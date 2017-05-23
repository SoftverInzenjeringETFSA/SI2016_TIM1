(function () {
    'use strict';

    // OVO JE ADNAN BABOVIC URADIOO
    app.controller('advertDetailsController',
        ['$scope', '$routeParams', 'advertService',
            function ($scope, $routeParams, advertService) {

                advertService.getAdvertDetails($routeParams.advertId)
                    .then(function (response) {
                       $scope.advert=response.data;
                    });

            }
        ]
    );

}());
