(function () {
    'use strict';
 
    app.controller('allCategoriesController',
        ['$scope', '$routeParams', 'categoryService', 
            function ($scope, $routeParams, categoryService){

             categoryService.getCategories()
                  .then(function (response) {
                        $scope.categories=response.data;
                    });



            }
        ]
    );

}());    