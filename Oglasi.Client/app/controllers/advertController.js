(function () {
    'use strict';
    app.controller('advertController', ['$scope', 'advertService', function ($scope, advertService) {

      advertService.getAdverts()
                  .then(function(response) {
                      alert(response.data);
                  });
    }]);


}());
