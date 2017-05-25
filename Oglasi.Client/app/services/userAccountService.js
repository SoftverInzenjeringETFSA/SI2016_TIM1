(function () {
    'use strict';

    app.factory('userAccountService', ['$http', 'ngAuthSettings', 'localStorageService',
                                function ($http, ngAuthSettings, localStorageService) {

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

        var logout = function() {
            localStorageService.remove('authorizationData');
        };

        var details = function() {
            return $http.get(servicebase + '/account')
                        .then(function(result) {
                            return result;
                        });
        };

        var update = function(user) {
            return $http.post(servicebase + '/account/update' ,user)
                        .then(function(result) {
                            return result;
                        });
        };

        var getAuthData = function() {
            var auth = null;
            var authData = localStorageService.get('authorizationData');
            if(authData != null) {
                auth = {};
                auth.isAuthenticated = true;
                auth.username = authData.username;
                auth.role = authData.role;
            }
            return auth;
        }

        var getAllUsers = function(){
            return $http.get(servicebase + '/account/all').then(function(res){
              return res;
            });
        }

        var changeUserBlock = function(username){
          return $http.post(servicebase + '/account/block', username)
                      .then(function(res){
                        return res;
                      });
        }

        userAccountServiceFactory.register = register;
        userAccountServiceFactory.login = login;
        userAccountServiceFactory.details = details;
        userAccountServiceFactory.update = update;
        userAccountServiceFactory.getAuthData = getAuthData;
        userAccountServiceFactory.logout = logout;
        userAccountServiceFactory.getAllUsers = getAllUsers;
        userAccountServiceFactory.changeUserBlock = changeUserBlock;


        return userAccountServiceFactory;
    }]);
}());
