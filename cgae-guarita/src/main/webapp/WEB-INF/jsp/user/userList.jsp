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
				<form action="" method="GET">
					<input type="search" name="filter" placeholder="Buscar por nome" value="${filter}" />
				</form>
				<table class="bordered">
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
	</div>

<c:import url="/includes/footer.jsp" />