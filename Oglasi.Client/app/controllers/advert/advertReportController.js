(function () {
    'use strict';
    app.controller('advertReportController', ['$scope', 'advertService', function ($scope, advertService) {

            //            $scope.getTitleOwner = function() {
          //                advertService.getTitleOwner()
          //                              .then(function(response){
              //                              $scope.titleOwner = response;
            //                                console.log(response);
                //                      });
              //        }

                            $scope.newReport = {};
                          var user = userAccountService.getAuthData();
                          if(user == null){
                            $scope.newReport.isGuest = true;
                            $scope.newReport.username = "";
                          }else{
                            $scope.newReport.isGuest = false;
                            $scope.newReport.username = user.username;

                          }
                          $scope.newReport.advertId = $routeParams.advertId;
                          $scope.newReport.message = "";


                          $scope.report = function() {
                            if($scope.newReport.message=="" || $scope.username == "") swal("Greska", "Poruka ne smije biti prazna! Korisnicko ime ne smije biti prazno!","error");

                            advertService.createInappropriateAdvertReport($scope.newReport)
                                              .then(function(response){
                                                   console.log(response);
                                                });
                          }

        $scope.adverts = [];
        
        advertService.getAdvertsWithReport()
              .then(function(response){
                $scope.adverts = response.data;
              });



    }]);

}());
