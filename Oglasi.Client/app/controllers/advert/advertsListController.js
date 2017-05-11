(function () {
    'use strict';
    app.controller('advertsListController', ['$scope', 'advertService', function ($scope, advertService) {

      advertService.getAdverts()
                  .then(function(response) {
                      $scope.adverts = response.data;
                      //alert(response);
                  });

    $scope.advertDetails = function(advert) {
            advertService.getAdvert(advert);
    }


    }]);

}());
