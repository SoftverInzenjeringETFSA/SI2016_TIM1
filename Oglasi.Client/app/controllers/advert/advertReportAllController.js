(function () {
    'use strict';
    app.controller('advertReportAllController', ['$scope', 'advertService', 'userAccountService', function ($scope, advertService, userAccountService) {
                

        $scope.adverts = [];
        
        advertService.getAdvertsWithReport()
              .then(function(response){
                $scope.adverts = response.data;
              });



    }]);

}());
