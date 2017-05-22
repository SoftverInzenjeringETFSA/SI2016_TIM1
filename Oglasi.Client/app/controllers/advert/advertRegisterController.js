(function () {
    'use strict';
    app.controller('advertsRegisterController', ['$scope', 'advertService', function ($scope, advertService) {

      $scope.getAdverts = function() {
                advertService.getAdverts()
                            .then(function(response) {
                                alert(response.data);
                            });
              };
      }])

});
