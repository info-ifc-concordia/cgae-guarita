$("document").ready(function(){
	$("#srcRegistration").keypress(function(e) {
	    if(e.which == 13) {
	    	var studentRegistration = $("#srcRegistration").val();
	    	$.ajax({
	    		url:"/cgae-guarita/students/" + studentRegistration + "/profile",
	    		type:"GET",
	    		data:{
	    			registration:studentRegistration,
	    		},
	    		success:function(response){
	    			
	    			
	    			//Limpa a barra de pesquisa
	    			$("#srcRegistration").val("");
	    		},
	    		failure:function(response){
	    			$("document").html(response);
	    		}
	    	});
	    }
	});
});
