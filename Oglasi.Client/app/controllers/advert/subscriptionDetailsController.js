(function (){
    'use strict';
    app.controller('subscriptionDetailsController', ['$scope', '$routeParams', 'advertService', function ($scope, $routeParams, advertService) {

      $scope.subscriptions = [];
//TO DOOO
        advertService.deleteSubscription($routeParams.id)
        			.then(function(response){
        				$scope.subscriptions = response.data;

        			});


   }]);


}());
