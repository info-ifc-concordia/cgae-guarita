<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

<div class="row">
	<div class="col m8 offset-m2">
		<h4 class="center-align">${authorizations.get(0).student.name}</h4>
        <h6 class="center-align">Visão de todas as observações</h6><br>
        <!--  -->
        
        <h5 class="center-align">${authorizations.get(0).date}</h5>
        
	<!-- PRIMEIRO LOOP -->
        
        <c:forEach var="i" begin="0" end="${Integer.parseInt(authorizations.size)}">
        	<c:set var="currentDate" scope="page" value="${authorizations.get(i).date}"></c:set>
        	
        	<!-- SEGUNDO LOOP -->
        	
	        <c:forEach items="${authorizations}" var="authorization" varStatus="status">
	        	
	        	<c:if test="${not authorization.date.equals(currentDate)}">
                	<h5 class="center-align">${authorization.date}</h5>
                	<c:set var="currentDate" scope="page" value="${authorization.date}"></c:set>
        		</c:if>
        		
	<!-- MODAL EDITAR -->
	        	
	        	<div id="edit${authorization.id}" class="modal">
	        		<form method="POST" action="<c:url value="/students/${authorization.student.registration}/autorizacoes" />">
						<div class="modal-content">
							<h4>Editar Observação</h4>
							<textarea name="newDescription" class="materialize-textarea">${authorization.description}</textarea>
						</div>
					    <div class="modal-footer">
					    	<input type="text" name="id" id="id" value="${authorization.id}" class="invisible" />
					        <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat">Cancelar</a>
					        <button type="submit" class="modal-action modal-close waves-effect waves btn-flat">
								Salvar Alterações
							</button>
					    </div>
				    </form>
				</div>
				
	<!-- MODAL DELETAR -->
				
				<div id="delete${authorization.id}" class="modal">
					<div class="modal-content">
						<h4>Excluir Autorização</h4>
						<p>Você tem certeza que deseja apagar definitivamente esta autororização?</p>
						<p>A ação não poderá ser desfeita.</p>
					</div>
				    <div class="modal-footer">
				        <form method="POST" action="<c:url value="/students/${authorization.student.registration}/autorizacoes" />">
							<input type="text" name="id" id="id" value="${authorization.id}" class="invisible" />
							<a href="#!" class="modal-action modal-close waves-effect waves btn-flat">Cancelar</a>
							<button type="submit" class="modal-action modal-close waves-effect waves btn-flat">
								Apagar
							</button>
						</form>
				    </div>
				</div>
	        		
	<!-- ESTRUTURA -->   
			     
	            <div class="card-panel col s12 grey lighten-3 z-depth-1">
	                <p>${authorization.description}</p>
	                <p class="right-align ifc-green-text">${authorization.time}</p>
	
	                <div class="input-field right-align">
	                    <a class="ifc-green waves-effect waves-light btn" href="#edit${authorization.id}">
	                        Editar Autorização
	                        <i class="material-icons right">edit</i>
	                    </a>
	                    
	                    <a class="ifc-red waves-effect waves-light btn" href="#delete${authorization.id}">
	                        Excluir Autorização
	                        <i class="material-icons right">delete</i>
	                    </a>
	                </div>
	                <br>
	            </div><br>
        	
	        
	        </c:forEach>
        </c:forEach>
        
        
    </div>
</div>

<c:import url="/includes/footer.jsp" />