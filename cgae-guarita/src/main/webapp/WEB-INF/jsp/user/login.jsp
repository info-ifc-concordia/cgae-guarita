<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/headers.jsp" />

<h3 class="center green-text text-draken-1">Login de Usuário</h3>
<div class="row">
    <div class="col s3">
        <!-- ESPAÇAMENTO LATERAL -->
    </div>
    <form class="col s6">
        <div class="input-field col s12">
            <i class="material-icons prefix">account_circle</i>
            <input type="text" id="name">
            <label for="name">Nome de Usuário</label>
        </div>
        <!--  -->
        <div class="input-field col s12">
            <i class="material-icons prefix">vpn_key</i>
            <input type="password" id="password">
            <label for="password">Senha</label><br>
            <a href="http://www.google.com">Mudar Senha</a>
        </div>
        <!--  -->
        <div class="input-field col s12 center-align">
            <button type="submit" class="green darken-1 waves-effect waves-light btn">
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
