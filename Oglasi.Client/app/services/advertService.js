(function () {
    'use strict';

    app.factory('advertService', ['$http', 'ngAuthSettings', function ($http, ngAuthSettings) {

        var servicebase = ngAuthSettings.apiServiceBaseUri;

        var advertServiceFactory = {};

        var _getSubscriptions = function (id) {

<<<<<<< HEAD
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


(function () {
    'use strict';

    app.factory('advertService', ['$http', 'ngAuthSettings', function ($http, ngAuthSettings) {

        var servicebase = ngAuthSettings.apiServiceBaseUri;

        var advertServiceFactory = {};

        var _getAdvert = function () {

            return $http.get(servicebase + '/advert/advert_details')
=======
            return $http.get(servicebase + '/advert/'+id+'/subscriptions')
>>>>>>> d8fcea88c2b37bac8899a82a2539acd8e8732dc2
                        .then(function(results) {
                            return results;
                        });
        };

<<<<<<< HEAD

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

=======
        advertServiceFactory.getSubscriptions= _getSubscriptions;

        return advertServiceFactory;
    }]);
>>>>>>> d8fcea88c2b37bac8899a82a2539acd8e8732dc2

}());
