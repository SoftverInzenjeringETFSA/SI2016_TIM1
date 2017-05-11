(function (){
    'use strict';
    app.controller('subscriptionsOnAdvertController', ['$scope', '$routeParams', 'advertService', function ($scope, $routeParams, advertService) {

        $scope.subscriptions = [];

        advertService.getSubscriptions($routeParams.id)
        			.then(function(response){
        				$scope.subscriptions = response.data;
        			});


   }]);


}());
