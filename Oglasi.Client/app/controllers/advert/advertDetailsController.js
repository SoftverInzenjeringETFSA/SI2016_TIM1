(function () {
    'use strict';

    // OVO JE ADNAN BABOVIC URADIOO
    app.controller('advertDetailsController',
        ['$scope', '$routeParams', 'advertService', '$location', '$route', 'userAccountService',
            function ($scope, $routeParams, advertService, $location, $route, userAccountService) {

                var user=userAccountService.getAuthData();
                if(user!=null && user.role=="ROLE_ADMIN"){
                    $scope.checkAdmin=true;
                }
                else if(user!=null){
                    $scope.checkAdmin=false;
                }

                advertService.getAdvertDetails($routeParams.advertId)
                    .then(function (response) {
                        $scope.advert=response.data;

                        $scope.contactValues=[];

                        if($scope.advert.ownerEmail!=null && $scope.advert.ownerEmail!=""){
                            $scope.contactValues.push({title:"Email", value:$scope.advert.ownerEmail});
                        }
                        if($scope.advert.ownerPhone!=null && $scope.advert.ownerPhone!="") {
                            $scope.contactValues.push({title:"Telefon", value:$scope.advert.ownerPhone});
                        }

                    });

                $scope.deleteAdvert = function() {
                    advertService.deleteAdvert($routeParams.advertId)
                        .then(function() {
                                swal("Success", "Advert deleted!", "success");
                                $location.url("/");
                            }, function () {
                                swal("Error", "Advert not deleted!", "error");
                            }
                        );
                };

                $scope.setPriority = function () {
                    advertService.changePriority($scope.advert.id)
                        .then(function () {
                            swal("Success", "Priority changed!", "success");
                            $route.reload();
                        }, function () {
                            swal("Error", "Priority not changed!", "error");
                        });
                };

                $scope.checkIn = function(){
                    $location.path($location.path() + '/check_in');
                };

                $scope.reportMe = function () {
                    $location.path('/advert/' + $routeParams.advertId + '/report');
                };

            }
        ]
    );

}());
