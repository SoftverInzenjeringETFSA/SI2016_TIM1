(function () {
    'use strict';
    app.controller('advertCheckInController',
        ['$scope', '$routeParams', '$location', 'advertService', 'userAccountService',
            function ($scope, $routeParams, $location, advertService, userAccountService) {

              var userAcc = userAccountService.getAuthData();

              $scope.isUserAcc = (userAcc != null)? true: false;

              $scope.checkIn = function(){
                var info = {};
                console.log("USER ACC:");
                console.log(userAcc);
                if(userAcc != null){
                  info.subscriber = userAcc.username;
                }else{
                  info.firstName = $scope.firstName;
                  info.lastName = $scope.lastName;
                  info.mail = $scope.mail;
                  info.phone = $scope.phone;
                  if(info.mail == null && info.phone == null){
                    swal("Ne valja", "Morate unijeti ili email ili broj telefona", "error");
                    return;
                  }
                }

                info.advertId = $routeParams.advertId;
                info.message = $scope.message;
                console.log(info);
                advertService.checkIn(info).then(function(res){
                  swal("Success", "Uspjesno ste se prijavili na oglas", "success");
                  $location.path("/advert/details/" + $routeParams.advertId);
                });

              }

            }]
          );

}());
