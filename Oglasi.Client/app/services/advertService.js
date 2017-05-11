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

        var _getAdvertDetails = function (id) {
            return $http.get(servicebase + '/advert/details/' + id)
                        .then(function (results) {
                            return results;
                        });
        };

        advertServiceFactory.getAdvertDetails = _getAdvertDetails;

        return advertServiceFactory;
    }]);
}());
