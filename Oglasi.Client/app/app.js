
var app = angular.module('oglasi', ['ngRoute',/* 'ui.bootstrap'/*, 'angular-loading-bar'*/, 'LocalStorageModule']);

var apiurl = "http://localhost:8080";

app.constant('ngAuthSettings', {
    apiServiceBaseUri: apiurl,
    clientId: 'ngAuthApp'
});

app.config(function ($routeProvider) {

  $routeProvider.when("/login", {
    controller: "loginController",
    templateUrl: "views/userAccount/login.html"
  });

  $routeProvider.when("/account/register", {
    controller: "registerController",
    templateUrl: "views/userAccount/register.html"
  });

  $routeProvider.when("/account", {
      controller: "userDetailsController",
      templateUrl: "views/userAccount/details.html"
  });

   $routeProvider.when("/advert/:id/subscriptions", {
    controller: "subscriptionsOnAdvertController",
    templateUrl: "views/advert/advert_subscriptions.html"
  });

  $routeProvider.otherwise({ redirectTo: "/" });
});

app.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptorService');
});
