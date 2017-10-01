<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />
	
	<c:import url="/includes/searchNavBar.jsp" />
	
	<h3 class="center-align">Editar usuário</h3>
	<div class="row">
		<div class="col m6 s12 offset-m3">
		
			<form method="POST" class="card-panel" 
					action="<c:url value="/users/change-data" />">
					
				<h6 class="red-text">${errorMsg}</h6>
				<!-- NOME -->
				<div class="input-field">
		            <input type="text" name="newName" id="name" value="${user.name}" class="${newNameMsg}" />
		            <label class="ifc-color-2-text" for="name">Editar Nome</label><br>
		        </div>
		        <!-- EMAIL -->
		        <div class="input-field">
		            <input type="email" name="newEmail" id="email" value="${user.email}" class="validate ${newEmailMsg}" />
		            <label class="ifc-color-2-text" for="password">Editar Email</label><br>
		        </div>
		        <!-- SENHA -->
		        <div class="input-field">
		            <input type="password" name="password" id="password" class="${oldPassMsg}" />
		            <label class="ifc-color-2-text" for="password">Senha Antiga</label><br>
		        </div>
		        <div class="input-field">
		            <input type="password" name="newPassword" id="newPassword" class="${newPassMsg}" />
		            <label class="ifc-color-2-text" for="newPassword">Nova Senha</label><br>
		        </div>
		        <div class="input-field">
		            <input type="password" name="rePassword" id="rePassword" class="${rePassMsg}" />
		            <label class="ifc-color-2-text" for="rePassword">Confirmar Nova Senha</label><br>
		        </div>
		        <div class="input-field center-align">
		            <button type="submit" class="btn ifc-green waves-effect waves-light">
		                Salvar Aterações
		            </button>
		        </div>
			</form>
		</div>
	</div>

<c:import url="/includes/footer.jsp" />