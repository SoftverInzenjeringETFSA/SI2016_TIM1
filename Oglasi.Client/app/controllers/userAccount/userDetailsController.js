(function () {
    'use strict';
    app.controller('userDetailsController', ['$scope', 'userAccountService', 'localStorageService',
                            function ($scope, userAccountService, localStorageService) {

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
