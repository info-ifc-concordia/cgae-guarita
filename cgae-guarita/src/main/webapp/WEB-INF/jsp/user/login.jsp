<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

<h3 class="center-align">Login de Usuário</h3>
<div class="row">
    <form class="col s6 offset-s3" method="POST"
    		action="<c:url value="/login" />">
        <h6 class="red-text">${errorMsg}</h6>
        <div class="input-field">
            <i class="material-icons prefix">account_circle</i>
            <input type="text" name="username" id="username" class="${usrNameMsg}" />
            <label for="username">Nome de Usuário</label>
        </div>
        <!--  -->
        <div class="input-field">
            <i class="material-icons prefix">vpn_key</i>
            <input type="password" name="password" id="password" class="${passMsg}" />
            <label for="password">Senha</label><br>
        </div>
        <!--  -->
        <p><a href="<c:url value="/users/recover-password" />">
       		Recuperar senha
       	</a></p>
        <div class="input-field center-align">
            <button type="submit" class="btn ifc-green waves-effect waves-light">
                Entrar
                <i class="material-icons right">send</i>
            </button>
        </div>
    </form>

    <div class="col s3">
        <!-- ESPAÇAMENTO LATERAL -->
    </div>
</div>

<c:import url="/includes/footer.jsp" />
