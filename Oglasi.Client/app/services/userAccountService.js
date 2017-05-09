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
        }

        userAccountServiceFactory.register = register;
        userAccountServiceFactory.login = login;

        return userAccountServiceFactory;
    }]);
}());
