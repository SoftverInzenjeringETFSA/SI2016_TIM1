(function (){
    'use strict';
    app.controller('subscriptionDetailsController', ['$scope', '$routeParams', 'advertService', function ($scope, $routeParams, advertService) {

        $scope.advertSubsriptionVM = {};

        advertService.getSubscriptionDetails($routeParams.id, $routeParams.s_id)
        			.then(function(response){
        				$scope.advertSubsriptionVM = response.data;
                //$scope.subscription = {subscriber:"sumejja", id: "1", message: "dedkdnlncs"};
        			});


   }]);
}());
