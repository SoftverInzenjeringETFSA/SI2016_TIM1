
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

  $routeProvider.when("/advert/details/:advertId", {
    controller: "advertDetailsController",
    templateUrl: "views/advert/details.html"
  });

  $routeProvider.when("/account", {
      controller: "userDetailsController",
      templateUrl: "views/userAccount/details.html"
  });


  $routeProvider.when("/advert/subscribe", {
      controller: "advertSubscriptionController",
      templateUrl: "views/advert/subscribe.html"
  });

  $routeProvider.when("/advert/report", {
      controller: "advertReportController",
      templateUrl: "views/advert/report.html"
  });

  $routeProvider.when("/account", {
      controller: "userDetailsController",
      templateUrl: "views/userAccount/details.html"
  });

   $routeProvider.when("/advert/:id/subscriptions", {
    controller: "subscriptionsOnAdvertController",
    templateUrl: "views/advert/advert_subscriptions.html"

  });

  $routeProvider.when("/advert/:id/subscriptions/subscription_details", {
   controller: "subscriptionDetailsController",
   templateUrl: "views/advert/advert_subscription_details.html"

  });

   $routeProvider.when("/category/create", {
    controller: "createCategoryController",
    templateUrl: "views/category/createCategory.html"

  });

    $routeProvider.when("/advert/create", {
        controller: "advertRegisterController",
        templateUrl: "views/advert/advert_form.html"
    });

    $routeProvider.when("/advert/details/:advertId/update", {
        controller: "advertUpdateController",
        templateUrl: "views/advert/advert_form.html"
    });

  $routeProvider.otherwise({ redirectTo: "/" });

});

app.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptorService');
});
