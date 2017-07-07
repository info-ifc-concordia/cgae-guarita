<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/headers.jsp" />
	
<h3 class="center-align ifc-color-1-text">Cadastro de Novo Usuário</h3>
<div class="row">		
    <form class="col s6 offset-s3" method="POST"
    		action="<c:url value="/users/perfil" />">
    		
		<div class="input-field">
        	<i class="material-icons prefix">account_circle</i>
            <input name="username" id="username" type="text">
            <label for="username">Nome de Usuário</label>
        </div>

        <div class="input-field">
        	<i class="material-icons prefix grey-text text-darken-1">account_circle</i>
            <input name="name" id="nam	e" type="text">
            <label for="name">Nome Completo</label>
        </div>
        
        <div class="input-field">
        	<i class="material-icons prefix">email</i>
            <input name="email" id="email" type="text">
            <label for="email">E-mail</label>
        </div>
        
        <div class="input-field">
           <select>
               <option value="" disabled selected>Tipo de Usuário</option>
               <option value="CGAE">CGAE</option>
               <option value="Guarita">Guarita</option>
           </select>
       </div>
        
        <div class="input-field">
        	<i class="material-icons prefix">vpn_key</i>
            <input id="password" type="password">
            <label for="password">Senha</label>
        </div>
        
        <div class="input-field">
        	<i class="material-icons prefix grey-text text-darken-1">vpn_key</i>
            <input id="repassword" type="password">
            <label for="repassword">Confirmar Senha</label>
        </div>


        <div class="input-field col s12 center-align">
            <button type="submit" class="green darken-1 waves-effect waves-light btn">
                Cadastrar
            </button>
        </div>

    </form>
	
</div>

<c:import url="/includes/footer.jsp" />