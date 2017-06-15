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

<c:import url="/includes/footer.jsp" />
