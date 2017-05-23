<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visualizar Empresas</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Modal -->
            <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="modalLabel">Excluir Empresa</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir esta empresa?
                        </div>
                        <div class="modal-footer">
                            <form action="controller.do" method="post">
                                <input type="hidden" name="id" id="cnpj_excluir" />
                                <button type="submit" class="btn btn-primary" name="command" value="ExcluirEmpresaLista">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.modal -->	


	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
	
    <!-- Container Principal -->
    <div class="col-sm-9 col-md-22">

    <div id="main" class="table-responsive col-md-12" >
    	<h3 class="page-header">Lista de Empresas</h3>
			<table class="table table-striped">
				<thead>
					<tr>
                		<th>Razão Social</th>
                		<th>CNPJ</th>
                		<th>Horário de funcionamento</th>
                		<th>Temp Ar - ºC</th>
                		<th>Horário ar-condicionado</th>
                		<th class="actions">Ações</th>
                	</tr>
                </thead>
				<c:forEach var="empresa" items="${lista}">
					<tr>
                        <td>
                        ${empresa.razaoSocial }
                        </td>
                        <td>
                        ${empresa.cnpj }
                        </td>
                        <td>
                        ${empresa.horarioEmpresa }
                        </td>
                        <td>
                        ${empresa.temperaturaArCondicionado }
                        </td>
                        <td>
                        ${empresa.horarioArCondicionado }
                        </td>
                        <td class="actions">
                        <a class="btn btn-success btn-xs" href="controller.do?command=ConsultarEmpresa&cnpj=${empresa.cnpj }">Visualizar</a>
                        <a class="btn btn-warning btn-xs" href="controller.do?command=ConsultarEmpresaAlterar&cnpj=${empresa.cnpj }">Editar</a>
                        <a class="btn btn-danger btn-xs" href="controller.do?command=ConsultarEmpresaExcluir&cnpj=${empresa.cnpj }">Excluir</a>
                        </td>
					</tr>
				</c:forEach>
				
		
			</table>

            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.jsp" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>