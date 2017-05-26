(function () {
    'use strict';
    app.controller('userUpdateController', ['$scope', '$location', 'userAccountService', 'localStorageService',
                            function ($scope, $location, userAccountService, localStorageService) {

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
                            },
                        function(response) {

                        });
        };

        $scope.update = function() {
            console.log($scope.acc);
            userAccountService.update($scope.acc)
                        .then(function(response) {
                            console.log("ok");
                            console.log(response);
                        },
                    function(response) {
                        console.log("nok");
                        console.log(response);
                    });
        };



        //call init functions
        $scope.getDetails();

    }]);


}());
