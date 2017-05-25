(function () {
    'use strict';
    app.controller('userDetailsController', ['$scope', '$location', 'userAccountService', 'localStorageService','advertService',
                            function ($scope, $location, userAccountService, localStorageService,advertService) {

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
                                advertService.getAdvertsByOwner($scope.acc.id).then(function(response){$scope.adverts=response.data;});
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
        $scope.deleteAdvert = function() {
            advertService.deleteAdvert($routeParams.advertId)
                .then(function() {
                        alert("Advert deleted!");
                        $location.url("/");
                    }, function () {
                        alert("Error!");
                    }
                );
        };



        //call init functions
        $scope.getDetails();

    }]);


}());
