(function () {
    'use strict';

    app.controller('advertDetailsController', ['$scope', '$routeParams', 'advertService', function ($scope, $routeParams, advertService) {

      $scope.advert = {};

      $scope.getAdvert = function() {
                advertService.getAdvertDetails($routeParams.id)
                            .then(function(response) {
                                $scope.advert = response.data;
                            });
              }

          }]);
}());
