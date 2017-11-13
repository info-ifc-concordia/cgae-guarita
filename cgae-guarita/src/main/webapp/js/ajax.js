$("document").ready(function(){
	var registration = $("#registration").val();
	var movementType = $("#in").val();
	if (movementType == null){
		var movementType = $("#out").val();
	}
	alert(movementType);
	/*$.ajax({
		url:"/students/" + registration + "/historical",
		type:"POST",
		data:{
			movementType:movementType,
		}
	});*/
});
