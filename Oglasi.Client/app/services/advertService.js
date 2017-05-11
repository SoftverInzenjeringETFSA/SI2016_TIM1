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

               var _getAdvertDetails = function (id) {
                     return $http.get(servicebase + '/advert/details/' + id)
                                .then(function (results) {
                                    return results;
                                 });
                 };

                 advertServiceFactory.getAdvertDetails = _getAdvertDetails;


        var _getSubscrins = function (id) {

            return $http.get(servicebase + '/advert/'+id+'/subscriptions')
                        .then(function(results) {
                            return results;
                        });
        };





        advertServiceFactory.getAdverts = _getAdverts;
        // advertServiceFactory.getAdvert = _getAdvert;

        advertServiceFactory.getSubscriptions=_getSubscrins;



        var _postSubscription = function (newSubscription) {

              return $http.post(servicebase + '/advert/subscribe', newSubscription)
                          .then(function (results) {
                              return results;
                          });
        }
        advertServiceFactory.subscribe = _postSubscription;

        var _getTitleOwner = function () {
              return $http.get(servicebase + '/advert/subscribe')
                          .then(function(results) {
                              return results;
                          });
        };
        advertServiceFactory.getTitleOwner = _getTitleOwner;

        var _postReport = function (newReport) {

              return $http.post(servicebase + '/advert/report', newReport)
                          .then(function (results) {
                              return results;
                          });
        }
        advertServiceFactory.report = _postReport;

        return advertServiceFactory;
    }]);

}());
