<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

	<c:import url="/includes/searchNavBar.jsp" />
	
	<div class="row" >
		<div class="input-field inline">
			<h6 class="left-align black-text">Movimento a verificar:</h6>
			<input name="movementTypeRadio" type="radio" id="in" value="Entrada">
			<label class="black-text" for="in">Entrada</label>
	
			<input name="movementTypeRadio" type="radio" id="out" value="Saída">
			<label class="black-text" for="out">Saída</label>
		</div>
		<br><br>
		<hr>
		
		
		<div id="studentData">
			<form class="col s4 offset-s4" method="POST" 
					action="<c:url value="/users/guarita/profile" />" >
				
				<div id="clearData"> 
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
		       </div>
			</form>
		</div>
	</div>
	

<c:import url="/includes/footer.jsp" />
<script src="<c:url value="/js/ajax.js" /> "></script>
