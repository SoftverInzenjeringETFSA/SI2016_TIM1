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

         var _getAdvert = function () {

            return $http.get(servicebase + '/advert/advert_details')
                        .then(function(results) {
                            return results;
                        });
        };


         var _messageInappropriate = function (newMessage) {

            return $http.post(servicebase + '/advert/inappropriate_advert', newMessage)
                        .then(function (results) {
                            return results;
                        });
        };


        var _getSubscrins = function (id) {

            return $http.get(servicebase + '/advert/'+id+'/subscriptions')
                        .then(function(results) {
                            return results;
                        });
        };



       

        advertServiceFactory.getAdverts = _getAdverts;
        advertServiceFactory.getAdvert = _getAdvert;
        advertServiceFactory.messageInappropriate = _messageInappropriate;
        advertServiceFactory.subscriptions=_getSubscrins;



        return advertServiceFactory;
    }]);

}());

