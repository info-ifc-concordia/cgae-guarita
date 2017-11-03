<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

	<c:import url="/includes/searchNavBar.jsp" />
	
	<div class="row">
		<form class="col s4 offset-s4" method="POST" 
				action="<c:url value="/users/guarita/profile" />" >
		
			<div class="input-field inline">
				<h6 class="left-align black-text">Movimento a verificar:</h6>
				<input name="inOrOut" type="radio" id="in">
				<label class="black-text" for="in">Entrada</label>
		
				<input name="inOrOut" type="radio" id="out">
				<label class="black-text" for="out">Saída</label>
			</div>
			<br><br>
			<hr>
			<div class="input-field col s12 center-align">
	           <a class="col s12 ifc-green waves-effect waves-light btn" href="<c:url value="/users/change-data"/>">
	               Alterar Dados
	           </a>
	       </div>
	       
	       <div class="input-field col s12 center-align">
	           <button class="col s12 ifc-green waves-effect waves-light btn" type="submit">
	               Sair
	           </button>
	       </div>
		</form>
	</div>
	

<c:import url="/includes/footer.jsp" />
