(function () {
    'use strict';
    app.controller('loginController', ['$scope', '$location', 'userAccountService', 'localStorageService',
                            function ($scope, $location, userAccountService, localStorageService) {


        //$scope.auth = userAccountService.getAuthData();
        if(userAccountService.getAuthData()){
            $location.path('/account');
        }


      $scope.login = function() {

          var user = {
              "username": $scope.user.username,
              "password": $scope.user.password
          };

          userAccountService
                .login($scope.user)
                .then(function(response) {

                    var authObj = {
                        token : response.headers()['authorization'].split(" ")[1],
                        username : $scope.user.username
                    };
                    localStorageService.set('authorizationData', authObj);

                    userAccountService.details()
                                    .then(function(response) {
                                        authObj.role = response.data.roleName;
                                        localStorageService.set('authorizationData', authObj);
                                        var auth = userAccountService.getAuthData();
                                        $scope.auth.isAuthenticated = auth.isAuthenticated;
                                        $scope.auth.username = auth.username;
                                        $scope.auth.role = auth.role;
                                        $location.path('/account');
                                    },
                                function(response) {

                                });
                },
                    function(response) {
                        console.log(response);
                    }
                );

      };


    }]);


}());
