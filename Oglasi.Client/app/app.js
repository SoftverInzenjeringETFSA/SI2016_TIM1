var app = angular.module('oglasi', ['ngRoute', 'ui.bootstrap', 'angular-loading-bar', 'LocalStorageModule']);

var apiurl = "http://localhost:8080/";

app.constant('ngAuthSettings', {
    apiServiceBaseUri: apiurl,
    clientId: 'ngAuthApp'
});

app.config(function ($routeProvider) {

  $routeProvider.when("/login", {
    controller: "loginController",
    templateUrl: "views/userAccount/login.html"
  });

  $routeProvider.when("/adverts", {
    controller: "advertsListController",
    templateUrl: "views/advert/all.html"
  });
  $routeProvider.when("/account/register", {
    controller: "registerController",
    templateUrl: "views/userAccount/register.html"
  });
  $routeProvider.otherwise({ redirectTo: "/" });
});

app.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptorService');
});
