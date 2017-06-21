<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/headers.jsp" />

<h3 class="center green-text text-draken-1">Login de Usuário</h3>
<div class="row">
    <form class="col s6 offset-s3" method="POST"
    		action="<c:url value="/login" />">
        <c:if test="${not empty errorMsg}">
	        <div class="alert">
	        	${errorMsg}
	        </div>
        </c:if>
        <div class="input-field col s12">
            <i class="material-icons prefix">account_circle</i>
            <input type="text" name="username" id="username" class="validate" required />
            <label for="username">Nome de Usuário</label>
        </div>
        <!--  -->
        <div class="input-field col s12">
            <i class="material-icons prefix">vpn_key</i>
            <input type="password" name="password" id="password" />
            <label for="password">Senha</label><br>
        </div>
        <!--  -->
        <div class="input-field col s12 center-align">
        	<p><a href="<c:url value="/recover-password" />">
        		Recuperar senha
        	</a></p>
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
