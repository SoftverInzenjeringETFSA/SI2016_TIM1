(function () {
    'use strict';

    app.factory('advertService', ['$http', 'ngAuthSettings', function ($http, ngAuthSettings) {

        var servicebase = ngAuthSettings.apiServiceBaseUri;

        var advertServiceFactory = {};

        var _getSubscriptions = function (id) {

            return $http.get(servicebase + '/advert/'+id+'/subscriptions')
                        .then(function(results) {
                            return results;
                        });
        };

        advertServiceFactory.subscriptions= _getSubscriptions;

        return advertServiceFactory;
    }]);

}());
