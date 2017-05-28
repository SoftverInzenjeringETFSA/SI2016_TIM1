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

                          $scope.report = function() {
                            advertService.report($scope.newReport)
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
