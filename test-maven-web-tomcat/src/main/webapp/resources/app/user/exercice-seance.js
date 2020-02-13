$( ".Consulter-seance" ).click(function() {
 	var idSeance = $(this).attr('id');	
	$.ajax({
				method: "POST",		  
				contentType : "application/json",
				dataType : 'json',
				timeout : 100000,
				url: "/seance/exercice",
				data:JSON.stringify(idSeance) 
				
		})
		  .done(function( msg ) {
		  
			  if (msg) {
			  	alert( "xxx: " + msg);
			 
			  }

		  });

});