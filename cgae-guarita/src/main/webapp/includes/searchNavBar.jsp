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

<!--
<nav class="row ifc-green">
    <div class="nav-wrapper">
    	<ul class="right col s4">
			<li><a href="sass.html"><i class="material-icons left">search</i>Link with Left Icon</a></li>
			<li><a href="badges.html"><i class="material-icons right">view_module</i>Link with Right Icon</a></li>
		</ul>
        <form class="col s8" method="POST" action="<c:url value="/students/list" />" >
            <div class="input-field">
                <input name="registration" id="searchNavBar" type="search" value="${filter}" required>
                <label for="searchNavBar" class="white-text">
                    <p>Buscar aluno pelo número de matrícula</p>
                </label>
                <i class="material-icons">close</i>
            </div>
        </form>
    </div>
</nav> 
 -->