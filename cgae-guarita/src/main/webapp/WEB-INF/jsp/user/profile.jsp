<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/headers.jsp" />

	<nav class="ifc-color-1">
	    <div class="nav-wrapper">
	        <form>
	            <div class="input-field">
	                <input id="search_btn_search" type="search" required>
	                <label id="search_lb_search" for="search" class="grey-text text-lighten-4">
	                    Insira a Matricula aqui
	                </label>
	                <i class="material-icons">close</i>
	            </div>
	        </form>
	    </div>
	</nav>
	<br>
	
	<div class="row">
		<div class="col s4 offset-s4">
	       
	       <div class="input-field col s12 center-align">
	           <a class="col s12 green darken-1 waves-effect waves-light btn" href="<c:url value="/students/register"/>">
	               Cadastrar Novo Aluno
	           </a>
	       </div>
	       
	       <div class="input-field col s12 center-align">
	           <a class="col s12 green darken-1 waves-effect waves-light btn" href="<c:url value="/users/register"/>">
	               Cadastrar Novo Usuário
	           </a>
	       </div>
	       
	       <div class="input-field col s12 center-align">
	           <a class="col s12 green darken-1 waves-effect waves-light btn" href="<c:url value="/users/control"/>">
	               Controlar Usuários
	           </a>
	       </div>
	       
	       <div class="input-field col s12 center-align">
	           <a class="col s12 green darken-1 waves-effect waves-light btn" href="<c:url value="/users/change-password"/>">
	               Alterar Senha
	           </a>
	       </div>
	       
        </div>
	</div>
	

<c:import url="/includes/footer.jsp" />
