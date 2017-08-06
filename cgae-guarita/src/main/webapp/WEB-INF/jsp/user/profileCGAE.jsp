<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/headers.jsp" />

	<nav class="ifc-green">
	    <div class="nav-wrapper">
	        <form>
	            <div class="input-field">
	                <input name="search" id="searchNavBar" type="search" required>
	                <label for="searchNavBar" class="white-text">
	                    Buscar aluno pelo número de matrícula
	                </label>
	                <i class="material-icons">close</i>
	            </div>
	        </form>
	    </div>
	</nav>
	<br>
	
	<div class="row">
		<form class="col s4 offset-s4" method="POST"
				action="<c:url value="/users/cgae/profile" />">
	       
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
	

<c:import url="/includes/footer.jsp" />
