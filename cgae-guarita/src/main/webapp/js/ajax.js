function showStudent(txtResgistration){
	$.ajax({
		method : "GET",
		url : "/cgae-guarita/students/" + txtResgistration + "/test",
		data : {
			registration : txtResgistration
		},
		
		success : function(response){
			console.log(response);
			var htmlContent = "" +
					"<div class='center'>" + 
					    "<img class='responsive-img' src='/cgae-guarita/students/" + response.data.student.registration + "/image'>" +
					"</div>" +
					
					"<h5 class='center-align'>" + response.data.student.name + "</h5>" +
					"<h6 class='center-align'>" + response.data.student.course + " - " + response.data.student.grade + "</h6>";
						
					if (response.data.user.userType !== "Guarita"){
						htmlContent += "<div id='newAuth' class='modal'>" +
								"<form method='POST' action='/cgae-guarita/students/" + response.data.student.registration + "/profile'>" +
									"<div class='modal-content'>" +
										"<h4 class='ifc-green-text'>Nova Observação</h4>" +
										"<div class='input-field'>" +
								            "<textarea name='description' id='description' class='materialize-textarea'></textarea>" +
								            "<label for='description' class='black-text'>Detalhes da Observação</label>" +
								        "</div>" + 
									"</div>" +
									"<div class='modal-footer'>" +
										"<input name='registration' id='registration' value='" + response.data.student.registration + "' class='invisible'>" +
										"<a href='#!' class='modal-action modal-close waves-effect waves btn-flat'>Cancelar</a>" +
										"<button type='submit' class='modal-action modal-close waves-effect waves btn-flat'>" +
											"Salvar" +
										"</button>" +
									"</div>" +
								"</form>" +
							"</div>" +
							
							"<div class='input-field right-align'>" +
						"<!-- NOVA OBSERVAÇÃO -->" +
								    "<a class='ifc-green waves-effect waves-light btn' href='#newAuth'>" +  
								        "Nova Observação" +
								        "<i class='material-icons right'>library_add</i>" +
								   "</a>&nbsp&nbsp" +
						"<!-- VISÃO GERAL -->" +
								    "<a class='ifc-green waves-effect waves-light btn' href='/cgae-guarita/students/" + response.data.student.registration + "/autorizacoes '>" + 
								        "Visão Geral" +
								        "<i class='material-icons right'>visibility</i>" +
								    "</a>&nbsp&nbsp" +
						"<!-- HISTORICO DO ALUNO -->" +
									"<a class='ifc-green waves-effect waves-light btn' href='/cgae-guarita/students/" + response.data.student.registration + "/historical '>" + 
								        "Historico de Movimentação" +
								        "<i class='material-icons right'>history</i>" + 
								    "</a>&nbsp&nbsp" +
							"</div>";
					}else{
						var txtMovementType = $("input[name=movementTypeRadio]:checked").val();
						registerMovement(txtResgistration, txtMovementType);
					}
					htmlContent += "<div class='card-panel grey lighten-3 z-depth-1'>" + 
							"<h5 class=''>Última Observação:</h5>" +
						    "<p>" + response.data.authorization.description + "</p>" +
						    "<br>" +
						    "<p class='left-align col m6'><b>Autorização dada por: " + response.data.authorization.userName + "</b></p>" +
						    "<p class='right-align col m6'>" + response.data.authorization.date + "</p>" +
						    "<br>" +
						"</div>";
			$("#studentData").html("");
			$("#studentData").removeClass().addClass("col m8 offset-m2");
			$("#studentData").html(htmlContent);
			$(".modal").modal();
			
		},
		
		fail : function(error){
			alert(error);
			error();
		}
	});
}


function listStudents(txtResgistration){
	$.ajax({
		method : "GET",
		url : "/cgae-guarita/students/list",
		data : {
			registration : txtResgistration
		},
		
		success : function(response){
			console.log(response);
			if(response.data.length === 1){
				alert("Comprimento de lista == 1");
				showStudent(txtResgistration);
			}else{
				var studentsTable = "" +
					"<table class='bordered centered highlight card-panel'>" +
						"<thead>" +
							"<tr>" +
								"<th>Matricula</th>" +
								"<th>Nome</th>" +
								"<th>Turma</th>" +
							"</tr>" +
						"</thead>" +
						"<tbody>";
							for(var student in response.data){
								studentsTable += "" +
								"<tr>" +
									"<td>" + response.data[student].registration + "</td>" +
									"<td><a href='#' onclick='showStudent(" + response.data[student].registration + ")' >" + response.data[student].name + "</a></td>" +
									"<td>" + response.data[student].grade + "</td>" +
								"</tr>";
							}
						studentsTable += "" +
						"</tbody>" +
					"</table>";
				$("#studentData").html("");
				$("#studentData").removeClass().addClass("col s6 offset-s3");
				$("#studentData").html(studentsTable);
			}
		}
	});
}


function registerMovement(txtResgistration, txtMovementType){
	alert(txtMovementType);
	$.ajax({
		method : "POST",
		url : "/cgae-guarita/students/" + txtResgistration + "/historical",
		data : {
			registration : txtResgistration,
			movementType: txtMovementType
		},
		
		success : function(response){
			console.log(response);
		}
	});
}

$("document").ready(function() {	
	if($("#srcRegistration").val() !== ""){
		alert("as");
		listStudents($("#srcRegistration").val());
	}
	
	//PEGA OS DADOS DO ALUNO
	$("#srcRegistration").keypress(function(event){
		if(event.keyCode === 13){
			var txtResgistration = $("#srcRegistration").val();
			listStudents(txtResgistration);
			$("#srcRegistration").val("");
		}
	});
});