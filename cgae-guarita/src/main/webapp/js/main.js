$(document).ready(function(){
//	INICIALIZAÇÕES NECESSÁRIAS DO MATERIALIZE
    $(".modal").modal();
    $("select").material_select();
//    $("#textarea1").trigger("");
    $(".dropdown-button").dropdown();
});

$("#fileInput").change( function(event) {
	var tmppath = URL.createObjectURL(event.target.files[0]);
    $("#imgFileInput").fadeIn("fast").attr("src", tmppath);
});