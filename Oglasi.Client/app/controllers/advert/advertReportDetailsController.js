(function (){
    'use strict';
    app.controller('advertReportDetailsController', ['$scope', '$routeParams', 'advertService', '$location',
                                                      function ($scope, $routeParams, advertService, $location) {

        $scope.reports = {};

        advertService.getAllReports($routeParams.id)
        			.then(function(response){
        				$scope.reports = response.data;
        			});

   }]);
}());
