(function () {
    'use strict';
    app.controller('createCategoryController', ['$scope', 'categoryService', function ($scope, categoryService) {

     $scope.categoryVM = {};

  $scope.categoryVM.values = [""];
  
  $scope.addNewValue = function() {


    $scope.categoryVM.values.push("");
  };
    
  $scope.removeValue = function() {
    var lastItem = $scope.categoryVM.values.length-1;
    $scope.categoryVM.values.splice(lastItem);
  };

  $scope.save = function() {
      categoryService.create($scope.categoryVM)
                    .then(function(response) {
                        
                                  swal("Success", "Category created!", "success");
                                  $scope.acc = null;
                    },function(response) {
                                  swal("Error", "Check your input!", "error");
                    });
  }


    }]);


}());