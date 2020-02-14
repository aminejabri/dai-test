$( "document" ).ready(function() {
 	
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

$("#notificationUtilisateur").click(function() {

	
		$.ajax({
			method: "POST",		  
			contentType : "application/json",
			dataType : 'json',
			timeout : 100000,
			url: "/api/message/notifications",
			data:JSON.stringify() 
			
	})
	  .done(function( msg ) {
	  
		  if (msg) {
			  $("#nompersone").html(msg);
		  }

	  });
		


});
