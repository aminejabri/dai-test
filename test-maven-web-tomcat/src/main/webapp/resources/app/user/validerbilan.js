
 $( "#submit" ).click(function() {
	 
var bilanForm = {};
bilanForm["age"] = $("input[name='age']"). val();	
bilanForm["poids"] = $("input[name='poids']"). val();	
bilanForm["poids"]  = $("input[name='poids']"). val();
bilanForm["fcrepos"] = $("input[name='fcrepos']"). val();
bilanForm["fccible"] = $("input[name='fccible']"). val();
bilanForm["fc5"] = $("input[name='fc5']"). val();
bilanForm["fc30"] = $("input[name='fc30']"). val();
bilanForm["fc1"] = $("input[name='fc1']"). val();
bilanForm["indicedickson"] = $("input[name='indicedickson']"). val();
bilanForm["gainage"] = $("input[name='gainage']"). val();
bilanForm["fentejambeg"] = $("input[name='fentejambeg']"). val();
bilanForm["crunch"] = $("input[name='crunch']"). val();
bilanForm["fentejambed"] = $("input[name='fentejambed']"). val();
bilanForm["pompes"] = $("input[name='pompes']"). val();
bilanForm["squat"] = $("input[name='squat']"). val();
bilanForm["bras"] = $("input[name='bras']"). val();
bilanForm["dips"] = $("input[name='dips']"). val();
bilanForm["poitrine"] = $("input[name='poitrine']"). val();
bilanForm["taille"] = $("input[name='taille']"). val();
bilanForm["hanches"] = $("input[name='hanches']"). val();
bilanForm["cuisse"] = $("input[name='cuisse']"). val();
bilanForm["messagconfirmation"] = $("input[name='messageconfirmation']"). val();


	$.ajax({
				method: "POST",		  
				contentType : "application/json",
				dataType : 'json',
				timeout : 100000,
				url: "/api/user/validerbilan",
				data:JSON.stringify(bilanForm) 
				
				
		})
		  .done(function( msg ) {
		  
			  if (msg) {
			  	alert( "Data Saved: " + msg);
			  	window.location.href = "/user/profil"
			  } 

		  });

 });

