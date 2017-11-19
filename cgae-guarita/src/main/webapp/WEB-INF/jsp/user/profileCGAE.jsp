<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

	<c:import url="/includes/searchNavBar.jsp" />
	
	<div class="row">
		<div id="studentData">
			<form class="col s4 offset-s4" method="POST"
					action="<c:url value="/users/cgae/profile" />" >
			       <div class="input-field col s12 center-align">
			           <a class="col s12 ifc-green waves-effect waves-light btn" href="<c:url value="/students/register"/>">
			               Cadastrar Novo Aluno
			           </a>
			       </div>
			       
			       <div class="input-field col s12 center-align">
			           <a class="col s12 ifc-green waves-effect waves-light btn" href="<c:url value="/users/register"/>">
			               Cadastrar Novo Usuário
			           </a>
			       </div>
			       
			       <div class="input-field col s12 center-align">
			           <a class="col s12 ifc-green waves-effect waves-light btn" href="<c:url value="/users/control"/>">
			               Controlar Usuários
			           </a>
			       </div>
			       
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
	</div>
	

<c:import url="/includes/footer.jsp" />
<script src="<c:url value="/js/ajax.js" /> "></script>