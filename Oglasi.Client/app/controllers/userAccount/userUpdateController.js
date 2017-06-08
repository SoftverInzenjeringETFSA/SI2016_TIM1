(function () {
    'use strict';
    app.controller('userUpdateController', ['$scope','$window' ,'$location', 'userAccountService', 'localStorageService',
                            function ($scope, $window, $location, userAccountService, localStorageService) {

        if(userAccountService.getAuthData() == null || userAccountService.getAuthData().isAuthenticated != true) {
            $location.path('/login');
        }

        $scope.getDetails = function() {
            userAccountService.details()
                            .then(function(response) {
                                $scope.acc = response.data;
                                console.log($scope.acc);
                                if($scope.acc.companyName != null) {
                                    $scope.accType = "Company";
                                }
                                else {
                                    $scope.accType = "Individual";
                                }
                                $scope.checkUsername=$scope.acc.username;
                            },
                        function(response) {

                        });
        };


        $scope.update = function() {
            console.log($scope.acc);
            userAccountService.update($scope.acc)
                        .then(function(response) {
                          if ($scope.checkUsername === $scope.acc.username)
                          {
                            swal("Success", "Račun izmjenjen", "success");
                            $location.path('/account');
                          }
                          else {
                          userAccountService.logout();
                          $scope.auth = userAccountService.getAuthData();

                            swal({
                              title: "Račun izmjenjen!",
                              text: "Molimo ponovo se prijavite koristeći nove podatke",
                              type: "success"
                            },function(){  location.reload();}

                            );
                              $location.path('/login');


                            console.log(response);



                        }},
                    function(response) {
                        console.log("nok");
                        console.log(response);
                    });
        };



        //call init functions
        $scope.getDetails();


    }]);


}());
