(function () {
    'use strict';
    app.controller('userDetailsController', ['$scope', '$location', 'userAccountService', 'localStorageService','advertService', '$route',
                            function ($scope, $location, userAccountService, localStorageService, advertService, $route) {

        if(userAccountService.getAuthData() == null || userAccountService.getAuthData().isAuthenticated != true) {
            $location.path('/login');
        }
        
        $scope.auth = userAccountService.getAuthData() || {};

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
        $scope.deleteAdvert = function(advertId) {
            advertService.deleteAdvert(advertId)
                .then(function() {
                        swal("Success", "Advert deleted!", "success");
                        $route.reload();
                    }, function () {
                        swal("Error", "Advert not deleted!", "error");
                    }
                );
        };



        //call init functions
        $scope.getDetails();

    }]);


}());
