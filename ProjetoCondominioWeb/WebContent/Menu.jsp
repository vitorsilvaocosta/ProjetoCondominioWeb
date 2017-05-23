<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>    
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                 <ul class="nav navbar-nav navbar-left">
                 <li class="active"><a class="navbar-brand" href="index.jsp">Home</a></li>
             	 <li><a href="controller.do?command=ListarEmpresas">Listar empresas</a></li>
             	 <li><a href="controller.do?command=ListarUsuarios">Listar usuarios</a></li>
                 
                </ul>
            </div>
        </div>
    </nav>
    	
        <div class="col-sm-3 col-md-3">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><span class="glyphicon glyphicon-chevron-down pull-right">
                            </span>Acesso</a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <span class="glyphicon glyphicon-pencil text-primary">
                                        </span><a href="Login.jsp">Login</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                            <span class="glyphicon glyphicon-oil "></span>Empresa</a>
                            <span class="glyphicon glyphicon-chevron-down pull-right"></span>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <a href="CadastrarEmpresa.jsp">Cadastrar empresa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="ConsultarEmpresa.jsp">Consultar empresa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="ConsultarEmpresaAlterar.jsp">Alterar empresa</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="ConsultarEmpresaExcluir.jsp" class="text-danger">Excluir empresa</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree"><span class="glyphicon glyphicon-user">
                            </span>Usuários</a>
                            <span class="glyphicon glyphicon-chevron-down pull-right"></span>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse">
                        <div class="panel-body">
                            <table class="table">
                                <tr>
                                    <td>
                                        <a href="CadastrarUsuario.jsp">Cadastrar usuários</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="ConsultarUsuario.jsp">Consultar usuários</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="ConsultarUsuarioAlterar.jsp">Alterar usuários</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="ConsultarUsuarioExcluir.jsp" class="text-danger">Excluir usuários</a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       
        