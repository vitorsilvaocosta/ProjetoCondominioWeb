<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<title>Cadastrar empresa</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Menus -->
	<c:import url="Menu.jsp"/>
	
    <!-- Container Principal -->
    <div class="col-sm-8">
    <div class="well">
    <h3 class="page-header">Cadastrar Empresa</h3>
    <div id="main" class="container col-md-20">
        <!-- Formulario para inclusao de empresas -->
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-lg-8">
                    <label for="cnpj">CNPJ</label>
                    <input type="text" class="form-control" name="cnpj" id="cnpj" required maxlength="14" placeholder="Informe o CNPJ" >
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-8">
                    <label for="razaoSocial">Razão Social</label>
                    <input type="text" class="form-control" name="razaoSocial" id="razaoSocial" maxlength="40" placeholder="Informe a Razão Social" >
                </div>
	
                <div class="form-group col-lg-8">
                    <label for="horarioEmpresa">Horario de funcionamento empresa</label>
                    <input type="text" class="form-control" name="horarioEmpresa" id="horarioEmpresa" maxlength="10" placeholder="Informe o horário de funcionamento" >
                </div>
                
                <div class="form-group col-lg-8">
                    <label for="temperaturaAr">Temperatura Ar-condicionado</label>
                    <input type="text" class="form-control" name="temperaturaAr" id="temperaturaAr" maxlength="10" placeholder="Informe a temperatura padrão do Ar-Condicionado" >
                </div>
                
                <div class="form-group col-lg-8">
                    <label for="horarioAr">Horario de funcionamento ar</label>
                    <input type="text" class="form-control" name="horarioAr" id="horarioAr" maxlength="10" placeholder="Informe o horário de funcionamento do Ar-Condicionado">
                </div>
            </div>
                <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="command" value="CadastrarEmpresa">Salvar</button>
                    			<a href="index.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <hr/>
    </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>