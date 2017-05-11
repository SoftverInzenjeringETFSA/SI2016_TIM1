
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

  $routeProvider.when("/", {
    controller: "advertsListController",
    templateUrl: "views/advert/all.html"
  });
  $routeProvider.when("/account/register", {
    controller: "registerController",
    templateUrl: "views/userAccount/register.html"
  });

  $routeProvider.when("/advert/details/:id", {
    controller: "advertDetailsController",
    templateUrl: "views/advert/details.html"
  });


  $routeProvider.when("/account", {
      controller: "userDetailsController",
      templateUrl: "views/userAccount/details.html"
  });

  $routeProvider.otherwise({ redirectTo: "/" });

});

app.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptorService');
});
