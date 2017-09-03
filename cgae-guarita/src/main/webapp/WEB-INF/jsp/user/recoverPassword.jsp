<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

<div class="row">
	<form method="POST" class="col s6 offset-s3" 
			action="<c:url value="/users/recover-password" />">
			
		<h6 class="red-text">${errorMsg}</h6>
		<!-- USRNAME -->
		<div class="input-field">
		    <input name="username" id="username" type="text" class="${usrNameMsg}">
		    <label for="username">Nome de Usuário</label>
		</div>
		<!-- EMAIL -->
		<div class="input-field">
		   	<input name="email" id="email" type="email" class="${emailMsg}">
		    <label for="email">E-mail</label>
		</div>
		<div class="input-field center-align">
		    <button type="submit" class="btn ifc-green waves-effect waves-light">
		        Enviar
		    </button>
		</div>
	</form>
</div>

<c:import url="/includes/footer.jsp" />
