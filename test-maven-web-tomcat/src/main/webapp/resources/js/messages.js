$( "#notificationCoach" ).click(function() {
 	
	setInterval(function(){
	
		$.ajax({
			method: "POST",		  
			contentType : "application/json",
			dataType : 'json',
			timeout : 100000,
			url: "/api/notification/count",
			data:JSON.stringify() 
			
	})
	  .done(function( msg ) {
	  
		  if (msg) {
			  $("#notification-span").html(msg);
		  }

	  });
		
	}, 5000);

});