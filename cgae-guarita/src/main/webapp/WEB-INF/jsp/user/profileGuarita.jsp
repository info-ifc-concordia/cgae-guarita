<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

	<c:import url="/includes/searchNavBar.jsp" />
	
	<div class="row">
		<form class="col s4 offset-s4" method="POST" 
				action="<c:url value="/users/guarita/profile" />" >
		
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
