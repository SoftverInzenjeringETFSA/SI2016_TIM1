(function () {
    'use strict';
    app.controller('inapropppriateAdvertController', ['$scope', 'userAccountService', function ($scope, userAccountService) {

        advertService.getAdvert()
        			.then(function(response){
        				console.log(response);
        			});
      }

    }]);


}());