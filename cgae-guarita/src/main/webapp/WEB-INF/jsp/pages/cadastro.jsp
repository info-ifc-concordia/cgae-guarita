<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/headers.jsp" />

<div class="row">
	<div class="col s3">
	    <!-- ESPAÇAMENTO LATERAL -->
	</div>
	
	<div class="col s6">
	    <h3 class="center-align ifc-color-1-text">Cadastro de Novo Aluno</h3>
	
	    <form class="" action="index.html" method="post">
	
	        <div class="input-field">
	            <input id="name" type="text">
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
	            <input id="course" type="text">
	            <label for="course">Curso do Aluno</label>
	        </div>
	
	        <div class="input-field">
	            <select>
	                <option value="" disabled selected>Ano que o aluno cursa</option>
	                <option value="1">Primeiro</option>
	                <option value="2">Option 2</option>
	                <option value="3">Option 3</option>
	            </select>
	        </div>
	
	        <div class="input-field">
	            <input id="date" type="date" class="datepicker">
	            <label for="date">Data de ingresso no instituto</label>
	        </div>
	
	        <div class="input-field center-align">
	            <a class="btn ifc-color-1 waves-effect waves-light">
	                Salvar
	            </a>
	        </div>
	
	    </form>
	
	</div>
	
	<div class="col s3">
	    <!-- ESPAÇAMENTO LATERAL -->
	</div>
</div>

<c:import url="/includes/footer.jsp" />