<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/headers.jsp" />

<div class="row">
	<div class="col s6 offset-s3">
	    <h3 class="center-align">Cadastro de Novo Aluno</h3>
	
	    <form class="" action="<c:url value="/students/register" />" method="POST">
	
	        <div class="input-field">
	            <input name="registration" id="registration" type="text">
	            <label for="registration">Matrícula</label>
	        </div>
	        
	        <div class="input-field">
	            <input name="name" id="name" type="text">
	            <label for="name">Nome Completo</label>
	        </div>
	
	        <div class="input-field center-align">
	            <a class="card-panel waves-effect waves-light ">
	            	<label>
	                	<img src="<c:import url="/img/avatar.png"/>" class="circle responsive-img">
	                </label>
	                
	                <input type="file" id="fileInput"/>
	            </a>
	            <p class="center-align">Clique na imagem para alterar</p>
	        </div>
	
	        <div class="input-field">
	            <input name="course" id="course" type="text">
	            <label for="course">Curso do Aluno</label>
	        </div>
	
	        <div class="input-field">
	            <input name="grade" id="grade" type="text">
	            <label for="grade">Turma do Aluno</label>
	        </div>
	
		    <div class="input-field col s12 center-align">
	            <button type="submit" class="btn ifc-green waves-effect waves-light">
	                Cadastrar
	            </button>
	        </div>

	
	    </form>
	
	</div>
</div>

<c:import url="/includes/footer.jsp" />