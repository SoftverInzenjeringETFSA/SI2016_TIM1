(function () {
    'use strict';
    app.controller('advertsListController', ['$scope', 'advertService', function ($scope, advertService) {

      advertService.getAdverts()
                  .then(function(response) {
                      alert(response.data);
                  });
    }]);


}());
