<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

<c:import url="/includes/searchNavBar.jsp" />

<h3 class="center-align">Cadastro de Novo Aluno</h3>
<div class="row">	
    <form class="col s12 m6 offset-m3" method="POST"
    		action="<c:url value="/students/register" />" enctype="multipart/form-data">
    	<h6 class="red-text">${errorMsg}</h6>

        <div class="input-field">
            <input name="registration" id="registration" type="text" class="${inputCls.get(0)}" value="${inputVal.get(0)}">
            <label for="registration">Matrícula</label>
        </div>
        
        <div class="input-field">
            <input name="name" id="name" type="text" class="${inputCls.get(1)}" value="${inputVal.get(1)}">
            <label for="name">Nome Completo</label>
        </div>
       
		<div class="image-upload center-align">
			<input name="studentImg" id="fileInput" type="file" class="hide"/>
			<label for="fileInput" class="waves-effect waves-light">
			<img src="<c:url value="/img/avatar.png" /> " id="imgFileInput" class="responsive-img"/>
			</label>
		</div>
		<p class="center-align" id="imgTip">Clique na imagem para alterar</p>

        <div class="input-field">
            <input name="course" id="course" type="text" class="${inputCls.get(2)}" value="${inputVal.get(2)}">
            <label for="course">Curso do Aluno</label>
        </div>

        <div class="input-field">
            <input name="grade" id="grade" type="text" class="${inputCls.get(3)}" value="${inputVal.get(3)}">
            <label for="grade">Turma do Aluno</label>
        </div>

	    <div class="input-field col s12 center-align">
            <button type="submit" class="btn ifc-green waves-effect waves-light">
                Cadastrar
            </button>
        </div>


    </form>

</div>

<c:import url="/includes/footer.jsp" />