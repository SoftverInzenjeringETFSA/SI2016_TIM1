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


        return advertServiceFactory;
    }]);

}());


(function () {
    'use strict';

    app.factory('advertService', ['$http', 'ngAuthSettings', function ($http, ngAuthSettings) {

        var servicebase = ngAuthSettings.apiServiceBaseUri;

        var advertServiceFactory = {};

        var _getAdvert = function () {

            return $http.get(servicebase + '/advert/advert_details')
                        .then(function(results) {
                            return results;
                        });
        };

       
        advertServiceFactory.getAdvert=_getAdvert;


        return advertServiceFactory;
    }]);
   

}());


(function () {
    'use strict';

    app.factory('advertService', ['$http', 'ngAuthSettings', function ($http, ngAuthSettings) {

        var servicebase = ngAuthSettings.apiServiceBaseUri;

        var userAccountServiceFactory = {};

        var _messageInappropriate = function (newMessage) {

            return $http.post(servicebase + '/advert/inappropriate_advert', newMessage)
                        .then(function (results) {
                            return results;
                        });
        };

        userAccountServiceFactory.message = _messageInappropriate;

        return userAccountServiceFactory;
    }]);
}());


(function () {
    'use strict';

    app.factory('advertService', ['$http', 'ngAuthSettings', function ($http, ngAuthSettings) {

        var servicebase = ngAuthSettings.apiServiceBaseUri;

        var userAccountServiceFactory = {};

        var application = function (newApplication) {

            return $http.post(servicebase + '/advert/details/application', newApplication)
                        .then(function (results) {
                            return results;
                        });
        };

        userAccountServiceFactory.application = application;

        return userAccountServiceFactory;
    }]);
}());


