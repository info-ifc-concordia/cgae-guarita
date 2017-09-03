<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.jsp" />

<div class="row">
              <div class="col s2">
                  <!-- ESPAÇAMENTO LATERAL -->
              </div>
				<div id="modal1" class="modal">
            <div class="modal-content">
                <h4>Editar Observação</h4>
                <textarea id="textarea1" class="materialize-textarea">
                </textarea>
            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-action modal-close waves-effect waves-red btn-flat">Cancelar</a>
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Salvar</a>
            </div>
        </div>

              <div class="col s8">
                  <h4 class="center-align">Nome do Aluno</h4>
                  <h6 class="center-align">Visão de todas as observações</h6><br>
                  <!--  -->
                  <div class="card-panel row">
                      <h5 class="center-align">DD/MM/AAAA</h5>
                      <div class="card-panel col s12 grey lighten-3 z-depth-1">
                          <p>O aluno está autorizado para...</p>
                          <p class="right-align col s9 ifc-green-text">HH:MM</p>

                          <div class="input-field right-align">
                              <a class="ifc-green waves-effect waves-light btn">
                                  Editar
                                  <i class="material-icons right">mode_edit</i>
                              </a>
                          </div>
                      </div>
                      <div class="card-panel col s12 grey lighten-3 z-depth-1">
                          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                          <p class="right-align col s9 ifc-green-text">HH:MM</p>

                          <div class="input-field right-align">
                              <a  class="ifc-green waves-effect waves-light btn" href="#modal1">
                                  Editar
                                  <i class="material-icons right">mode_edit</i>
                              </a>
                          </div>
                      </div>
                      <div class="card-panel col s12 grey lighten-3 z-depth-1">
                          <p>O aluno está autorizado para...</p>
                          <p class="right-align col s9 ifc-green-text">HH:MM</p>

                          <div class="input-field right-align">
                              <a class="ifc-green waves-effect waves-light btn">
                                  Editar
                                  <i class="material-icons right">mode_edit</i>
                              </a>
                          </div>
                      </div>
                  </div>

              </div>

              <div class="col s2">
                  <!-- ESPAÇAMENTO LATERAL -->
              </div>
          </div>

<c:import url="/includes/footer.jsp" />