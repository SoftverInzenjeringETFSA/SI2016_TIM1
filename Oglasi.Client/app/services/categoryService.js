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

                c.getCategories = function () {
                    return $http.get(servicebase + '/category/all')
                        .then(function (result) {
                            return result;
                        })
                };

                c.getCategory = function (id) {
                    return $http.get(servicebase + '/category/get/' + id)
                        .then(function (result) {
                            return result;
                        })
                };    

                c.deleteCategory = function (id) {
                    return $http.get(servicebase + '/category/delete/' + id)
                        .then(function (result) {
                            return result;
                        })
                };    

                return c;

        }]);

}());