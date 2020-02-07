/**
 * 
 */
 
 $(document).ready(function(){
 
 $( "#submit" ).click(function() {
 
  	alert('ok'); 
  	var user = {};
  	user["username"]='John';
  	user["email"]='Joh';
  	user["password"]='John';
  	
	$( "#target" ).keyup(function() {
  	alert( "Handler for .keyup() called." );
	});

		
	$.ajax({
		  method: "POST",		  
            contentType : "application/json",
            dataType : 'json',
            timeout : 100000,
		  url: "/api/user/exists",
		  data:JSON.stringify(user)
		})
		  .done(function( msg ) {
		  
		    alert( "Data Saved: " + msg.username );
		  });

 });

});
 