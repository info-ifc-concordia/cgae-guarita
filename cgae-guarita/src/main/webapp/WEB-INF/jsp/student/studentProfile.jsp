<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

	<!-- MODAL -->
	
	<div id="modal2" class="modal">
	    <div class="modal-content">
	        <h4>Nova Observação</h4>
	        <div class="input-field">
	            <textarea id="textarea2" class="materialize-textarea"></textarea>
	            <label for="textarea2">Detalhes da Observação</label>
	
	        </div>
	    </div>
	    <div class="modal-footer">
	        <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat">Cancelar</a>
	        <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Salvar</a>
	    </div>
	</div>
	
	<c:import url="/includes/searchNavBar.jsp" />

<div class="row">

	<div class="col m8 s12 offset-m2">
		
		<div class="center">
		    <img src="http://www.motsandco.com/wp-content/uploads/avatar-1-300x300.png" class="responsive-img"> <!-- MUDAR -->
		</div>
		
		<h5 class="center-align">${student.name}</h5>
		<h6 class="center-align">${student.course} - ${student.grade}</h6>
			
		<p class="col m4">Última Observação</p>
		<div class="input-field col m5 right-align">
		    <a class="ifc-green waves-effect waves-light btn" href="#modal2">
		        Nova Observação
		        <i class="material-icons right">library_add</i>
		    </a>
		</div>
		<div class="input-field col m3 right-align">
		    <a class="ifc-green waves-effect waves-light btn" 
		    		href="<c:url value="/alunos/${student.registration}/autorizacoes" />">
		        Visão Geral
		        <i class="material-icons right">visibility</i>
		    </a>
		</div>
		
		<div class="card-panel grey lighten-3 z-depth-1">
		    <p class="">Última observação feita para o aluno</p>
		    <p class="right-align ifc-color-1-text">DD/MM/AAAA</p>
		</div>
	
	</div>

</div>


<c:import url="/includes/footer.jsp" />