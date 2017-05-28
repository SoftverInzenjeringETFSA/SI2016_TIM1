
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

  $routeProvider.when("/advert/with_report", {
      controller: "advertReportController",
      templateUrl: "views/advert/advert_with_reports.html"
  });
  
  $routeProvider.when("/advert/with_report/:id/details", {
      controller: "advertReportDetailsController",
      templateUrl: "views/advert/all_reports.html"
  });

  $routeProvider.when("/advert/with_report/details/:id", {
      controller: "advertReportOneController",
      templateUrl: "views/advert/one_report.html"
  });

  $routeProvider.when("/account", {
      controller: "userDetailsController",
      templateUrl: "views/userAccount/details.html"
  });

  $routeProvider.when("/advert/:id/subscriptions", {
    controller: "subscriptionsOnAdvertController",
    templateUrl: "views/advert/advert_subscriptions.html"

  });

  $routeProvider.when("/advert/:id/subscriptions/:s_id", {
   controller: "subscriptionDetailsController",
   templateUrl: "views/advert/advert_subscription_details.html"

  });

   $routeProvider.when("/category/create", {
    controller: "createCategoryController",
    templateUrl: "views/category/createCategory.html"

  });

     $routeProvider.when("/category/all", {
    controller: "allCategoriesController",
    templateUrl: "views/category/allCategories.html"

  });

    $routeProvider.when("/category/details/:categoryId", {
    controller: "categoryDetailsController",
    templateUrl: "views/category/categoryDetails.html"

  });

    $routeProvider.when("/advert/create", {
        controller: "advertRegisterController",
        templateUrl: "views/advert/advert_form.html"
    });

    $routeProvider.when("/advert/details/:advertId/update", {
        controller: "advertUpdateController",
        templateUrl: "views/advert/advert_form.html"
    });

  //$routeProvider.otherwise({ redirectTo: "/" });
  $routeProvider.when("/account/update", {
      controller: "userUpdateController",
      templateUrl: "views/userAccount/update.html"
  });
  $routeProvider.when("/users",{
    controller: "adminUserController",
    templateUrl: "views/userAccount/userAdmin.html"
  });
  $routeProvider.when("/advert/details/:advertId/check_in",{
    controller: "advertCheckInController",
    templateUrl: "views/advert/check_in.html",
  })

});

app.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptorService');
});
