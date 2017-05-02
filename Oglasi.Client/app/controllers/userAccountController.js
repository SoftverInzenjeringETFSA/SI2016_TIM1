(function () {
    'use strict';
    app.controller('userAccountController', ['$scope', 'userAccountService', function ($scope, userAccountService) {



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
