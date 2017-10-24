<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

<div id="modal1" class="modal">
	<div class="modal-content">
		<h4>Editar Observação</h4>
		<textarea id="textarea1" class="materialize-textarea"></textarea>
	</div>
    <div class="modal-footer">
        <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat">Cancelar</a>
        <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Salvar</a>
    </div>
</div>

<div class="row">
	<div class="col m8 offset-m2">
		<h4 class="center-align">${authorizations.get(0).student.name}</h4>
        <h6 class="center-align">Visão de todas as observações</h6><br>
        <!--  -->
        
        <c:forEach items="${authorizations}" var="authorization">
        
	        <div class="">
	            <h5 class="center-align">${authorization.date}</h5>
	            <div class="card-panel col s12 grey lighten-3 z-depth-1">
	                <p>${authorization.description}</p>
	                <p class="right-align ifc-green-text">${authorization.time}</p>
	
	                <div class="input-field right-align">
	                    <a class="ifc-green waves-effect waves-light btn">
	                        Editar
	                        <i class="material-icons right">mode_edit</i>
	                    </a>
	                </div>
	                <br>
	            </div>
	        </div><br>
        	
        
        </c:forEach>
        
        
    </div>
</div>

<c:import url="/includes/footer.jsp" />