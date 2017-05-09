(function () {
    'use strict';
    app.controller('loginController', ['$scope', 'userAccountService', function ($scope, userAccountService) {

      $scope.login = function() {

          var user = {
              "username": $scope.user.username,
              "password": $scope.user.password
          };

          userAccountService.login(user)
                            .then(function(response) {
                                console.log('ss');
                            },
                        function(response) {
                            console.log(response);
                        });

            var ajax = new XMLHttpRequest();
            
      };


    }]);


}());
