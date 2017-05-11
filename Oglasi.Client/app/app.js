
var app = angular.module('oglasi', ['ngRoute',/* 'ui.bootstrap'/*, 'angular-loading-bar'*/, 'LocalStorageModule']);

<<<<<<< HEAD

=======
>>>>>>> d8fcea88c2b37bac8899a82a2539acd8e8732dc2
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

<<<<<<< HEAD
  $routeProvider.when("/", {
    controller: "advertsListController",
    templateUrl: "views/advert/all.html"
  });
=======
>>>>>>> d8fcea88c2b37bac8899a82a2539acd8e8732dc2
  $routeProvider.when("/account/register", {
    controller: "registerController",
    templateUrl: "views/userAccount/register.html"
  });

<<<<<<< HEAD
  $routeProvider.when("/advert/details/:id", {
    controller: "advertDetailsController",
    templateUrl: "views/advert/details.html"
  });


  $routeProvider.when("/account", {
      controller: "userDetailsController",
      templateUrl: "views/userAccount/details.html"
  });

=======
  $routeProvider.when("/account", {
      controller: "userDetailsController",
      templateUrl: "views/userAccount/details.html"
  });

   $routeProvider.when("/advert/:id/subscriptions", {
    controller: "subscriptionsOnAdvertController",
    templateUrl: "views/advert/advert_subscriptions.html"
  });

>>>>>>> d8fcea88c2b37bac8899a82a2539acd8e8732dc2
  $routeProvider.otherwise({ redirectTo: "/" });

});

app.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptorService');
});
