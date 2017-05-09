(function () {
    'use strict';

    app.factory('userAccountService', ['$http', 'ngAuthSettings', function ($http, ngAuthSettings) {

        var servicebase = ngAuthSettings.apiServiceBaseUri;

        var userAccountServiceFactory = {};

        var register = function (newAccount) {

            return $http.post(servicebase + '/account/register', newAccount)
                        .then(function (result) {
                            return result;
                        });
        };

        var login = function(user) {
            return $http.post(servicebase + '/login', user)
                        .then(function(result) {
                            return result;
                        });
        };

        var details = function() {
            return $http.get(servicebase + '/account')
                        .then(function(result) {
                            return result;
                        });
        };

        var update = function(user) {
            return $http.post(user)
                        .then(function(result) {
                            return result;
                        })
        };

        userAccountServiceFactory.register = register;
        userAccountServiceFactory.login = login;
        userAccountServiceFactory.details = details;
        userAccountServiceFactory.update = update;

        return userAccountServiceFactory;
    }]);
}());
