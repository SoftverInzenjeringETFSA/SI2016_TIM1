(function (){
    'use strict';
    app.controller('advertReportOneController', ['$scope', '$routeParams', 'advertService', '$location',
                                                      function ($scope, $routeParams, advertService, $location) {

        $scope.report = {};

        advertService.findOneReport($routeParams.id)
        			.then(function(response){
        				$scope.report = response.data;
        			});

              $scope.removeReport = function() {
                  advertService.deleteReport($routeParams.id)
                      .then(function() {
                              swal("Success", "Prijava izbrisana!", "success");
                              $location.url("/");
                          }, function () {
                              swal("Error", "Check your input!", "error");
                          }
                      );
              };

   }]);
}());
