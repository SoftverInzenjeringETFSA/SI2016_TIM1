(function () {
    'use strict';


    app.factory('categoryService', ['$http', 'ngAuthSettings', 'localStorageService',
                                function ($http, ngAuthSettings, localStorageService) {
                var c = {}

                 var servicebase = ngAuthSettings.apiServiceBaseUri;

                c.create = function(category) {
                return $http.post(servicebase + '/category/create', category)
                .then(function(result){
                    return result;
                })
                };

                      
                       

                return c;

        }]);

}());