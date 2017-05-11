(function (){
    'use strict';
    app.controller('subscriptionsOnAdvertController', ['$scope', 'advertService', function ($scope, advertService) {

       /* advertService.getSubscriptions()
        			.then(function(response){
        				console.log(response);
        			});*/
    		$scope.subscriptions = [{
    			subscriberName: "mmm",
    			datetime: "jhjh"
    		},{
    			subscriberName: "mm2",
    			datetime: "time"
    		}];

     
   }]);


}());