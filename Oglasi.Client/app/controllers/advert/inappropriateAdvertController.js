(function () {
    'use strict';
    app.controller('inapropppriateAdvertController', ['$scope', 'userAccountService', function ($scope, advertService) {

        advertService.getAdvert()
        			.then(function(response){
        				console.log(response);
        			});

    }]);


}());