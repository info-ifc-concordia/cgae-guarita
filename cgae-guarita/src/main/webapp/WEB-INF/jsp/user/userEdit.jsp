<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/headers.jsp" />
	
	<h3 class="center-align ifc-color-1-text">Usuários</h3>
	<div class="row">
		<!--<div class="col s6 offset-s3">
			${userInfo}
		</div>-->
		<div class="col s6 offset-s3">
			<div class="card-panel">
				<h4>${user.name}</h4>
				<h6>Editar usuário</h6>
				<form action="" method="GET">
				</form>
			</div>
		</div>
	</div>

<c:import url="/includes/footer.jsp" />