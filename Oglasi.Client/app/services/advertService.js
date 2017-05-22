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

        var _getAdvertsByCategory = function (categoryId) {
            return $http.get(servicebase + '/advert/category/'+categoryId)
                        .then(function (results) {
                            return results;
                        });
        };
        advertServiceFactory.getAdvertsByCategory = _getAdvertsByCategory;

        var _getAdvertsByOwner = function (ownerId) {
            return $http.get(servicebase + '/advert/owner/'+ownerId)
                        .then(function (results) {
                            return results;
                        });
        };
        advertServiceFactory.getAdvertsByOwner = _getAdvertsByOwner;

        var _getAdvertsWithReport = function () {
            return $http.get(servicebase + '/advert/with_report')
                        .then(function (results) {
                            return results;
                        });
        };
        advertServiceFactory.getAdvertsWithReport = _getAdvertsWithReport;

        var _getAdvertDetails = function (id) {
            return $http.get(servicebase + '/advert/details/' + id)
                        .then(function (results) {
                            return results;
                        });
        };
        advertServiceFactory.getAdvertDetails = _getAdvertDetails;

        // register
        var _registerAdvert = function (advert) {
            return $http.post(servicebase+'/advert/create', advert)
                        .then(function (results) {
                            return results;
                        });
        };
        advertServiceFactory.registerAdvert = _registerAdvert;

        // update
        var _updateAdvert = function (advert) {
            return $http.post(servicebase+'/advert/update', advert)
                .then(function (results) {
                    return results;
                });
        };
        advertServiceFactory.updateAdvert = _updateAdvert;

        //delete
        var _deleteAdvert = function (id) {
            return $http.delete(servicebase+'/advert/delete/' + id)
                .then(function (results) {
                    return results;
                });
        };
        advertServiceFactory.deleteAdvert = _deleteAdvert;


        var _getSubscrins = function (id) {

            return $http.get(servicebase + '/advert/'+id+'/subscriptions')
                        .then(function(results) {
                            return results;
                        });
        };

        // advertServiceFactory.getAdvert = _getAdvert;

        advertServiceFactory.getSubscriptions=_getSubscrins

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
