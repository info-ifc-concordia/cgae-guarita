<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="ifc-green">
    <div class="nav-wrapper">
        <form method="POST" action="<c:url value="/students/list" />" >
            <div class="input-field">
                <input name="registration" id="searchNavBar" type="search" value="${filter}" required>
                <label for="searchNavBar" class="white-text">
                    Buscar aluno pelo número de matrícula
                </label>
                <i class="material-icons">close</i>
            </div>
        </form>
    </div>
</nav>
<br>