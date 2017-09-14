<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- <nav class="ifc-green"> -->
<!--     <div class="nav-wrapper"> -->
<%--         <form method="POST" action="<c:url value="/students/list" />" > --%>
<!--             <div class="input-field"> -->
<%--                 <input name="registration" id="searchNavBar" type="search" value="${filter}" required> --%>
<!--                 <label for="searchNavBar" class="white-text search-nav-bar-label"> -->
<!--                     Buscar aluno pelo número de matrícula -->
<!--                 </label> -->
<!--                 <i class="material-icons">close</i> -->
<!--             </div> -->
<!--         </form> -->
<!--     </div> -->
<!-- </nav> -->
<!-- <br> -->

<!-- DROPDOWN -->
<ul id="dropdown1" class="dropdown-content">
  	<li><a href="<c:url value="/login" />"><i class="material-icons left">arrow_back</i>Sair</a></li>
	<li><a href="<c:url value="${usrProfURL}" />"><i class="material-icons left">home</i>Home</a></li>
  	<li class="divider"></li>
</ul>

<!-- NAVBAR -->
<nav class="row ifc-green">
    <div class="nav-wrapper">
    	<ul class="right col s4">
			<li><a class="dropdown-button" href="#!" data-activates="dropdown1">Opções<i class="material-icons right">arrow_drop_down</i></a></li>
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
