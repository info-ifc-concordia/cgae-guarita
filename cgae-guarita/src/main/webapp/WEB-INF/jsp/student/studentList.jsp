<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />
<c:import url="/includes/searchNavBar.jsp" />
	
	<h3 class="center-align">Alunos</h3>
	<div class="row">
		<div class="col s6 offset-s3">			
			<table class="bordered centered highlight card-panel">
				<thead>
					<tr>
						<th>Matricula</th>
						<th>Nome</th>
						<th>Turma</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${students}" var="student">
						<tr>
							<td>${student.registration}</td>
							<td><a href="<c:url value="/students/${student.registration}/profile" />">
								${student.name}
							</a></td>
							<td>${student.grade}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

<c:import url="/includes/footer.jsp" />