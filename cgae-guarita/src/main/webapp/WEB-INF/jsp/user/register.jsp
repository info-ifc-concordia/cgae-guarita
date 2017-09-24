<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />
	
<h3 class="center-align">Cadastro de Novo Usuário</h3>
<div class="row">		
    <form class="col m6 s12 offset-m3" method="POST"
    		action="<c:url value="/users/register" />">
    	<h6 class="red-text">${errorMsg}</h6>
		
		<div class="input-field">
            <input name="username" id="username" type="text" class="${usrNameMsg}" value="${inputVal.get(0)}">
            <label for="username">Nome de Usuário</label>
        </div>

        <div class="input-field">
            <input name="name" id="name" type="text" class="${nameMsg}" value="${inputVal.get(1)}">
            <label for="name">Nome Completo</label>
        </div>
        
        <div class="input-field">
            <input name="email" id="email" type="email" class="${emailMsg}" value="${inputVal.get(2)}">
            <label for="email">E-mail</label>
        </div>
        
        <div class="input-field">
           <select name="userType" class="${usrTypeMsg}">
               <option value="0" disabled selected>Tipo de Usuário</option>
               <option value="5">CGAE</option>
               <option value="3">Guarita</option>
           </select>
       </div><br>
        
        <div class="input-field">
            <input name="password" id="password" type="password" class="${passMsg}" value="${inputVal.get(4)}">
            <label for="password">Senha</label>
        </div>
        
        <div class="input-field">
            <input name="rePassword" id="repassword" type="password" class="${rePassMsg}" value="${inputVal.get(5)}">
            <label for="repassword">Confirmar Senha</label>
        </div>


        <div class="input-field col s12 center-align">
            <button type="submit" class="btn ifc-green waves-effect waves-light">
                Cadastrar
            </button>
        </div>

    </form>
	
</div>

<c:import url="/includes/footer.jsp" />