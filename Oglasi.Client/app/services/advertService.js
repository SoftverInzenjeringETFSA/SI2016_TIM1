(function () {
    'use strict';

    app.factory('advertService', ['$http', 'ngAuthSettings', function ($http, ngAuthSettings) {

        var servicebase = ngAuthSettings.apiServiceBaseUri;

        var advertServiceFactory = {};

        var _getAdverts = function () {

            return $http.get(servicebase + '/advert/all')
                        .then(function (results) {
                            return results;
                        });
        };

        advertServiceFactory.getAdverts = _getAdverts;

        var _postSubscription = function (newSubscription) {

              return $http.post(servicebase + '/advert/subscribe', newSubscription)
                          .then(function (results) {
                              return results;
                          });
        }
        advertServiceFactory.subscribe = _postSubscription;

        return advertServiceFactory;
    }]);
}());
