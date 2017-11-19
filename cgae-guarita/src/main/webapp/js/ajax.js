$("document").ready(function() {
	alert("OK");
	$("#srcRegistration").keypress(function(event){
		if(event.keyCode === 13){
			alert("cu");
			var txtResgistration = $("#srcRegistration").val();
			alert(txtResgistration);
			
			$.ajax({
				method : "GET",
				url : "/cgae-guarita/students/" + txtResgistration + "/test",
				data : {
					registration : txtResgistration
				},
				
				success : function(response){
					alert(response);
					console.log(response);
				},
				
				fail : function(error){
					alert(error);
					error();
				}
			});
		}
	});
});