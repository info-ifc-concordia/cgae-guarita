<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

<div class="row">

    <div class="col m8 offset-m2">
    
        <table class="centered striped">
            <thead>
                <tr>
                    <th>Data e Horário</th>
                    <th>Tipo de Movimento</th>
                    <th>Verificada Por</th>
                </tr>
            </thead>

            <tbody>
            	<c:forEach items="${movements}" var="movement">
	                <tr>
	                    <td>${movement.date}  ${movement.time}</td>
	                    <td>${movement.movementType}</td>
	                    <td>${movement.userName}</td>
	                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<c:import url="/includes/footer.jsp" />