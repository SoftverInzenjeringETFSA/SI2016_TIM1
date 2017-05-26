(function () {
    'use strict';
    app.controller('adminUserController', ['$scope', '$location', 'userAccountService',
                            function ($scope, $location, userAccountService) {

        if(userAccountService.getAuthData() == null || userAccountService.getAuthData().role != 'ROLE_ADMIN') {
            $location.path('/');
        }
        userAccountService.getAllUsers().then(function(res){
          for(let i = 0; i<res.data.array.length; i++){
            let d = new Date(res.data.array[i].creationDate);
            res.data.array[i].creationDate = d.getDate() + "." + (d.getMonth()+1) + "." + d.getFullYear();
          }
          $scope.array = res.data.array;
          console.log($scope.array);
        });
        $scope.user = null;

        $scope.onListItemClick = function(index){
          $scope.user = $scope.array[index];

          $scope.user.index = index;
          if($scope.user.companyName == null) $scope.user.companyName = "None";
          if($scope.user.phone == null) $scope.user.phone = "None";


        };
        $scope.changeBlock = function(){
            userAccountService.changeUserBlock($scope.user.username).then(function(res){
            $scope.user.blocked = !$scope.user.blocked;
            $scope.array[$scope.user.index].blocked = $scope.user.blocked;
          });
        }
    }])
}());
