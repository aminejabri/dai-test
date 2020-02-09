/**
 * 
 */
 
 $(document).ready(function(){

	// $( "#username" ).keyup(function() {
	// 	$.ajax({
	// 			method: "POST",		  
	// 			contentType : "application/json",
	// 			dataType : 'json',
	// 			timeout : 100000,
	// 			url: "/api/user/username-exists",
	// 			data:JSON.stringify($( "#username" ).val())
	// 		})
	// 		.done(function( msg ) {
				
	// 		});
	// });



 $( "#submit" ).click(function() {
 		
	$.ajax({
				method: "POST",		  
				contentType : "application/json",
				dataType : 'json',
				timeout : 100000,
				url: "/api/user/username-exists",
				data:JSON.stringify() 
				
		})
		  .done(function( msg ) {
		  
			  if (msg) {
			  	alert( "Data Saved: " + msg);
			  } else {
				 $( "#inscription-from" ).submit();
			  }

		  });

 });

});
 