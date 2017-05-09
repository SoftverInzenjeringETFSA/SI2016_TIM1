(function () {
    'use strict';
    app.controller('indexController', ['$scope', '$location', 'userAccountService', function ($scope, $location, userAccountService) {

      // model initialization
      $scope.auth = userAccountService.getAuthData() || {};

      $scope.logout = function() {
            userAccountService.logout();
            $scope.auth = userAccountService.getAuthData();
            $location.path('/login');
      };


    }]);


}());
