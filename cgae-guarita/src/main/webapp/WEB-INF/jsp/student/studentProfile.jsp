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

	<div class="col m8 offset-m2">
			
		<div class="center">
		    <img src="<c:url value="/students/${student.registration}/image"/>" 
		    		class="responsive-img">
		</div>
		
		<h5 class="center-align">${student.name}</h5>
		<h6 class="center-align">${student.course} - ${student.grade}</h6>
			
		<c:if test="${not user.userType.equals('Guarita')}">
			<div class="input-field right-align">
		<!-- NOVA OBSERVAÇÃO -->
				    <a class="ifc-green waves-effect waves-light btn" href="#newAuth">
				        Nova Observação
				        <i class="material-icons right">library_add</i>
				    </a>
		<!-- VISÃO GERAL -->
				    <a class="ifc-green waves-effect waves-light btn" href="<c:url value="/students/${student.registration}/autorizacoes" />">
				        Visão Geral
				        <i class="material-icons right">visibility</i>
				    </a>
		<!-- HISTORICO DO ALUNO -->
					<a class="ifc-green waves-effect waves-light btn" href="<c:url value="/students/${student.registration}/historical" />">
				        Historico de Movimentação
				        <i class="material-icons right">history</i>
				    </a>
			</div>
		</c:if>
		
		<div class="card-panel grey lighten-3 z-depth-1">
			<h5 class="">Última Observação</h5>
		    <p>${lastAuthorization.description}</p>
		    <p class="left-align col m6">Autorização dada por: ${lastAuthorization.userName}</p>
		    <p class="right-align col m6">${lastAuthorization.date}</p>
		    <br>
		</div>
	</div>
</div>

<c:import url="/includes/footer.jsp" />