(function () {
    'use strict';
    app.controller('advertSubscriptionController', ['$scope', 'advertService', function ($scope, advertService) {



                          $scope.subscribe = function() {
                            advertService.subscribe($scope.newSubscription)
                                              .then(function(response){
                                                   console.log(response);
                                                });
                          }

    }]);

}());
