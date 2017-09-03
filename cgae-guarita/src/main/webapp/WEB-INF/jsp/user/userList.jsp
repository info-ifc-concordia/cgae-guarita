<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />
	
	<h3 class="center-align">Usuários</h3>
	<div class="row">
		<div class="col s6 offset-s3">
			
			<form action="" method="GET" class="card=panel z-depth-1">
				<nav class="ifc-green">
				    <div class="nav-wrapper">
			            <div class="input-field">
			                <input name="filter" id="searchNavBar" type="search" value="${filter}" required>
			                <label for="searchNavBar" class="gray-text text-lighten-4">
			                    Buscar usuário pelo nome
			                </label>
			                <i class="material-icons">close</i>
			            </div>
				    </div>
				</nav>
			</form>
			
			<table class="bordered centered highlight card-panel">
				<thead>
					<tr>
						<th>ID#</th>
						<th>Nome</th>
						<th>E-mail</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.id}</td>
							<td><a href="<c:url value="/users/${user.id}/edit" />">
								${user.name}
							</a></td>
							<td>${user.email}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

<c:import url="/includes/footer.jsp" />