(function () {
    'use strict';
    app.controller('advertSubscriptionController', ['$scope', 'advertService', function ($scope, advertService) {

            //            $scope.getTitleOwner = function() {
          //                advertService.getTitleOwner()
          //                              .then(function(response){
              //                              $scope.titleOwner = response;
            //                                console.log(response);
                //                      });
              //        }

                          $scope.subscribe = function() {
                            advertService.subscribe($scope.newSubscription)
                                              .then(function(response){
                                                   console.log(response);
                                                });
                          }



    }]);

}());
