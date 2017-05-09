(function () {
    'use strict';
    app.controller('registerController', ['$scope', 'userAccountService', function ($scope, userAccountService) {

      // model initialization
      $scope.accType = "Individual";

      $scope.submit = function() {

        userAccountService.register($scope.acc)
                          .then(function(response) {

                                  swal("Success", "Account created!", "success");
                                  $scope.acc = null;

                              },
                              function(response) {
                                  swal("Error", "Check your input!", "error");
                              }
                          );
      }


    }]);


}());
