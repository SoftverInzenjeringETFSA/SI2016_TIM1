(function () {
    'use strict';
    app.controller('userDetailsController', ['$scope', '$location', 'userAccountService', 'localStorageService',
                            function ($scope, $location, userAccountService, localStorageService) {

        if(userAccountService.getAuthData() == null || userAccountService.getAuthData().isAuthenticated != true) {
            $location.path('/login');
        }

        $scope.getDetails = function() {
            userAccountService.details()
                            .then(function(response) {
                                $scope.acc = response.data;
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
            userAccountService.update($scope.acc)
                        .then(function(response) {
                            console.log(response);
                        },
                    function(response) {
                        console.log(response);
                    });
        };



        //call init functions
        $scope.getDetails();

    }]);


}());
