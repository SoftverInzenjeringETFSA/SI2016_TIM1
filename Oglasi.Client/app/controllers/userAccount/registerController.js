(function () {
    'use strict';
    app.controller('registerController', ['$scope', 'userAccountService', function ($scope, userAccountService) {

      // model initialization
      $scope.accType = "Individual";

      $scope.save = function(username) {

        var acc = {
          username: username
        };

        userAccountService.register(acc)
                          .then(function(response) {
                            console.log(response);
                          });
      }


    }]);


}());
