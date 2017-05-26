(function () {
    'use strict';
 
    app.controller('categoryDetailsController',
        ['$scope', '$routeParams', 'categoryService', 
                 function ($scope, $routeParams, categoryService){

        $scope.init = function (){

            categoryService.getCategory($routeParams.categoryId)
            .then(function (response) {
                       $scope.category=response.data;
                    });

        
                 }
                
            $scope.init();

            
        
    }
        ]
    );

}());    