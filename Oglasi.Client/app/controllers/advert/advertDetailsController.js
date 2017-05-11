(function () {
    'use strict';
    app.controller('advertsDetailsController', ['$scope', 'userAccountService', function ($scope, userAccountService) {

        advertService.getAdvert()
        			.then(function(response){
        				console.log(response);
        			});
      

    }]);


}());