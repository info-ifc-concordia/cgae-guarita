<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

	<c:import url="/includes/searchNavBar.jsp" />
	
	<script type="text/javascript">
		$(document).ready(function(){
		    $(".modal").modal();
		});
	</script>
	
	<h3 class="center-align">Editar usuário</h3>
	<div class="row">
		<div class="col s12 m6 offset-m3">
		
			<div id="sureDelete" class="modal">
				<div class="modal-content">
					<h4 class="ifc-green-text">Deletar Usuário</h4>
					<p>Você tem certeza que deseja apagar definitivamente este usuário da lista de usuários?</p>
					<p>A ação não poderá ser desfeita.</p>
				</div>
				<div class="modal-footer">
					<form method="POST" action="<c:url value="/users/control" />">
						<input type="text" name="id" id="id" value="${user.id}" class="invisible" />
						<a href="#!" class="modal-action modal-close waves-effect waves btn-flat">Cancelar</a>
						<button type="submit" class="modal-action modal-close waves-effect waves btn-flat">
							Apagar
						</button>
					</form>
				</div>
			</div>
		
			<form class="card-panel" method="POST"
				 	action="<c:url value="/users/${user.id}/edit" />">
				 	
				<h6 class="red-text">${errorMsg}</h6>
				<!-- ID -->
				<div class="input-field">
		            <input type="text" name="id" id="id" value="${user.id}" disabled />
		            <label for="id">#ID</label><br>
		        </div>
		        <!-- NOME DE USUÁRIO -->
				<div class="input-field">
		            <input type="text" name="username" id="username" value="${user.username}" disabled />
		            <label for="username">Nome de Usuário</label><br>
		        </div>
				<!-- NOME -->
				<div class="input-field">
		            <input type="text" name="newName" id="newName" value="${user.name}" class="${newNameMsg}" />
		            <label for="newName">Editar Nome</label><br>
		        </div>
		        <!-- EMAIL -->
		        <div class="input-field">
		            <input type="email" name="newEmail" id="newEmail" value="${user.email}" class="validate ${newEmailMsg}" />
		            <label for="newEmail">Editar Email</label><br>
		        </div>
		        <!-- SENHA -->
		        <div class="input-field">
		            <input type="password" name="password" id="password" class="${oldPassMsg}" />
		            <label for="password">Senha Antiga</label><br>
		        </div>
		        <div class="input-field">
		            <input type="password" name="newPassword" id="newPassword" class="${newPassMsg}" />
		            <label for="newPassword">Nova Senha</label><br>
		        </div>
		        <div class="input-field">
		            <input type="password" name="rePassword" id="rePassword" class="${rePassMsg}" />
		            <label for="rePassword">Confirmar Nova Senha</label><br>
		        </div>
		        <div class="input-field center-align col s4">
		            <button type="submit" class="btn ifc-green waves-effect waves-light">
		                Salvar Aterações
		            </button>
		        </div>
		        <div class="input-field center-align col s4">
		            <a href="<c:url value="/users/cgae/profile" />" class="btn grey darken-1 waves-effect waves-light">
		                Descartar Alterações
		            </a>
		        </div>
		        
				<c:set var="usrType" scope="session" value="ADMIN"/>
				<c:choose>
					<c:when test="${user.userType.equals(usrType)}">
						<div class="input-field center-align col s4">
				    		<a href="#sureDelete" class="btn ifc-red waves-effect waves-light disabled">
				        		Excluir Usuário
				    		</a>
				 	</div><br><br>
					</c:when>
					<c:otherwise>
						<div class="input-field center-align col s4">
				    		<a href="#sureDelete" class="btn ifc-red waves-effect waves-light">
				        		Excluir Usuário
				    		</a>
				 	</div><br><br>
					</c:otherwise>
				</c:choose>
		        
		        
			</form>
		</div>
	</div>

<c:import url="/includes/footer.jsp" />