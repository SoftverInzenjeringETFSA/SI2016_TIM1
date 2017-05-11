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

  $routeProvider.when("/advert/details", {
    controller: "advertDetailsController",
    templateUrl: "views/advert/advert_details.html"
  });

   $routeProvider.when("/advert/details/inappropriate", {
    controller: "inappropriateAdvertController",
    templateUrl: "views/advert/inappropriate_advert.html"
  });

  //   $routeProvider.when("/advert/details/application_form", {
  //   controller: "applicationOnAdvertController",
  //   templateUrl: "views/advert/application_form.html"
  // });

   $routeProvider.when("/advert/:id/subscriptions", {
    controller: "subscriptionsOnAdvertController",
    templateUrl: "views/advert/advert_subscriptions.html"
  });


  $routeProvider.otherwise({ redirectTo: "/" });
});

app.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptorService');
});
