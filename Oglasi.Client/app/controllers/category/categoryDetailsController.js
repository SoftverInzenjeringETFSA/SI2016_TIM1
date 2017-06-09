(function () {
    'use strict';
 
    app.controller('categoryDetailsController',
        ['$scope', '$routeParams', 'categoryService', '$location',
                 function ($scope, $routeParams, categoryService, $location){

        $scope.init = function (){

            categoryService.getCategory($routeParams.categoryId)
            .then(function (response) {
                       $scope.category=response.data;
                    });

        
                 }
                
            $scope.init();

            $scope.updateCategory = function()
            {
             swal("Success", "U fazi implementacije!", "success");   
            }

           $scope.deleteCategory = function() {
                    categoryService.deleteCategory($routeParams.categoryId)
                        .then(function() {

                            // swal({
                            //     title: "Success",
                            //     text: "Category deleted!",
                            //     type: "success"
                            // }, function() {
                            //     $location.path('/category/all')
                            //   $window.location.reload();
                            // });
                                swal("Success", "Category deleted!", "success");
                                $location.path('/category/all');
                                //  var url = "http://" + $window.location.host + "/category/all";
                                //  $log.log(url);
                                //  $window.location.href = url;
                               
                                
                        
                            }, function () {
                                swal("Error", "Category not deleted!", "error");
                            }
                        );
                };    
        
    }
        ]
    );

}());    