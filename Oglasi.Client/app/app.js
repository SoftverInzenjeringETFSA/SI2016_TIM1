var app = angular.module('oglasi',['ngRoute', 'ui.bootstrap']);//, 'angular-loading-bar', 'LocalStorageModule']);

var apiurl = "http://localhost:8080/";

app.constant('ngAuthSettings', {
    apiServiceBaseUri: apiurl,
    clientId: 'ngAuthApp'
});

app.config(function ($routeProvider) {
  $routeProvider.when("/adverts", {
    controller: "advertController",
    templateUrl: "views/advert/all.html"
  });
  $routeProvider.otherwise({ redirectTo: "/" });
});
