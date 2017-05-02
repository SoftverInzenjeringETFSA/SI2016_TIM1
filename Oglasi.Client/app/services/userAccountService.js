(function () {
    'use strict';

    app.factory('userAccountService', ['$http', 'ngAuthSettings', function ($http, ngAuthSettings) {

        var servicebase = ngAuthSettings.apiServiceBaseUri;

        var userAccountServiceFactory = {};

        var register = function (newAccount) {

            return $http.post(servicebase + '/account/register', newAccount)
                        .then(function (results) {
                            return results;
                        });
        };

        userAccountServiceFactory.register = register;

        return userAccountServiceFactory;
    }]);
}());
