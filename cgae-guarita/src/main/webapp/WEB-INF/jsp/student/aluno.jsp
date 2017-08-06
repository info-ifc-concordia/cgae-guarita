<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/headers.jsp" />

<!-- MODAL -->

<div id="modal2" class="modal">
    <div class="modal-content">
        <h4>Nova Observação</h4>
        <div class="input-field">
            <textarea id="textarea2" class="materialize-textarea"></textarea>
            <label for="textarea2">Detalhes da Observação</label>

        </div>
    </div>
    <div class="modal-footer">
        <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat">Cancelar</a>
        <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Salvar</a>
    </div>
</div>

<!-- Código vem aqui -->

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
</nav><br>
<div class="center">
    <img src="http://www.motsandco.com/wp-content/uploads/avatar-1-300x300.png" class="responsive-img"> <!-- MUDAR -->
</div>

<h5 class="center-align">Nome do Aluno</h5>
<h6 class="center-align">Curso do Aluno</h6>


<div class="row">
<div class="col s2">
    <!-- ESPAÇAMENTO LATERAL -->
</div>


<div class="col s8">

    <div class="row">
        <p class="col s4">Última Observação</p>
        <div class="input-field col s5 right-align">
            <a class="ifc-color-1 waves-effect waves-light btn" href="#modal2">
                Nova Observação
                <i class="material-icons right">library_add</i>
            </a>
        </div>
        <div class="input-field col s3 right-align">
            <button type="submit" class="ifc-color-1 waves-effect waves-light btn">
                Visão Geral
                <i class="material-icons right">visibility</i>
            </button>
        </div>

        <div class="col s12 card-panel grey lighten-3 z-depth-1">
            <p class="col s12">Última observação feita para o aluno</p>
            <p class="col s12 right-align ifc-color-1-text">DD/MM/AAAA</p>
        </div>
    </div>

</div>


<div class="col s2">
    <!-- ESPAÇAMENTO LATERAL -->
    </div>
</div>


<c:import url="/includes/footer.jsp" />