$(document).ready(function() {
    $.ajax({
    //    url: "http://rest-service.guides.spring.io/greeting"
    	 url: "http://localhost:8080/getHashTable"
    }).then(function(data) {
       $('.greeting-id').append(data.name);
       $('.greeting-content').append(data.employer);
    });
});