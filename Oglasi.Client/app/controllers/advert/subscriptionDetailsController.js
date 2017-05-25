(function (){
    'use strict';
    app.controller('subscriptionDetailsController', ['$scope', '$routeParams', 'advertService', '$location',
                                                      function ($scope, $routeParams, advertService, $location) {

        $scope.advertSubscriptionVM = {};

        advertService.getSubscriptionDetails($routeParams.id, $routeParams.s_id)
        			.then(function(response){
        				$scope.advertSubscriptionVM = response.data;
        			});

              $scope.removeSubscription = function() {
                  advertService.deleteSubscription($routeParams.s_id)
                      .then(function(response) {
                              swal("Success", "Prijava izbrisana!", "success");
                              $location.url("/");
                          }, function (response) {
                              swal("Error", "Check your input!", "error");
                          }
                      );
              };

   }]);
}());
