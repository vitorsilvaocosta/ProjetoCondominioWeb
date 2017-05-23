<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Alterar Empresa</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
	
        <!-- Container Principal -->
        <div class="col-sm-8">
        <h3 class="page-header">Visualizar Empresa</h3>
        <div id="main" class="container col-md-20">
            <form action="controller.do" method="post">
            <div class="row">
                <div class="col-md-6">
                    <p><strong>CNPJ</strong></p>
                    <p>
                    <input type="text" class="form-control" name="cnpj" id="cnpj" readonly required maxlength="14" value="${empresa.cnpj}">
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <p><strong>Razão Social</strong>
                    </p>
                    <p>
                       <input type="text" class="form-control" name="razaoSocial" id="razaoSocial" maxlength="40" value="${empresa.razaoSocial}">
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>Horario de funcionamento</strong>
                    </p>
                    <p>
                        <input type="text" class="form-control" name="horarioEmpresa" id="horarioEmpresa" maxlength="10" value="${empresa.horarioEmpresa}">
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>Temperatura Ar-condicionado</strong>
                    </p>
                    <p>
                        <input type="text" class="form-control" name="temperaturaAr" id="temperaturaAr" maxlength="10" value="${empresa.temperaturaArCondicionado}">
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>Horario de funcionamento Ar</strong>
                    </p>
                    <p>
                        <input type="text" class="form-control" name="horarioAr" id="horarioAr" maxlength="10" value="${empresa.horarioArCondicionado}">
                    </p>
                </div>
            </div>
            </form>
        </div>
        <hr />
        <div id="actions" class="row">
                <div class="col-md-12">
               		<button type="submit" class="btn btn-primary" name="command" value="AlterarEmpresa">Salvar</button>
                    <a href="ConsultarEmpresaAlterar.jsp" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
	
</body>
</html>