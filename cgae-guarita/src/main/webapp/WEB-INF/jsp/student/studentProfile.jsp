<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

	<!-- MODAL -->
	<div id="newAuth" class="modal">
		<form method="POST" action="<c:url value="/students/${student.registration}/profile" />">
			<div class="modal-content">
				<h4 class="ifc-green-text">Nova Observação</h4>
				<div class="input-field">
		            <textarea name="description" id="description" class="materialize-textarea"></textarea>
		            <label for="description" class="black-text">Detalhes da Observação</label>
		        </div>
			</div>
			<div class="modal-footer">
				<input name="registration" value="${student.registration}" class="invisible">
				<a href="#!" class="modal-action modal-close waves-effect waves btn-flat">Cancelar</a>
				<button type="submit" class="modal-action modal-close waves-effect waves btn-flat">
					Salvar
				</button>
			</div>
		</form>
	</div>
	
	<c:import url="/includes/searchNavBar.jsp" />

<!-- CÓDIGO -->
<div class="row">

	<div class="col m8 s12 offset-m2">
		<c:if test="${user.userType.equals('Guarita')}">
			<div class="input-field inline center">
				<input name="inOrOut" type="radio" id="in">
				<label class="black-text" for="in">Entrada</label>
		
				<input name="inOrOut" type="radio" id="out">
				<label class="black-text" for="out">Saída</label>
			</div>
		</c:if>
		
		<div class="center">
		    <img src="<c:url value="/students/${student.registration}/image"/>" 
		    		class="responsive-img">
		</div>
		
		<h5 class="center-align">${student.name}</h5>
		<h6 class="center-align">${student.course} - ${student.grade}</h6>
			
		<p class="col m4">Última Observação</p>
		<div class="input-field col m5 right-align">
		    <a class="ifc-green waves-effect waves-light btn" href="#newAuth">
		        Nova Observação
		        <i class="material-icons right">library_add</i>
		    </a>
		</div>
		<div class="input-field col m3 right-align">
		    <a class="ifc-green waves-effect waves-light btn" 
		    		href="<c:url value="/students/${student.registration}/autorizacoes" />">
		        Visão Geral
		        <i class="material-icons right">visibility</i>
		    </a>
		</div>
		
		<div class="card-panel grey lighten-3 z-depth-1">
		    <h6 class="">Última observação feita para o aluno</h6>
		    <p>${lastAuthorization.description}</p>
		    <p class="right-align ifc-color-1-text">${lastAuthorization.date}</p>
		</div>
	
	</div>

</div>


<c:import url="/includes/footer.jsp" />