(function () {
    'use strict';
    app.controller('loginController', ['$scope', 'userAccountService', 'localStorageService',
                            function ($scope, userAccountService, localStorageService) {

      $scope.login = function() {

          var user = {
              "username": $scope.user.username,
              "password": $scope.user.password
          };

          userAccountService
                .login($scope.user)
                .then(function(response) {
                    console.log(response.headers()['authorization']);
                    var authObj = {
                        token : response.headers()['authorization'].split(" ")[1]
                    };
                    localStorageService.set('authorizationData', authObj);
                },
                    function(response) {
                        console.log(response);
                    }
                );

      };


    }]);


}());
