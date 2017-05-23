<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<title>Cadastrar usuário</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegacao -->
	<c:import url="Menu.jsp"/>
	
    <!-- Container Principal -->
    <div class="col-sm-9 col-md-20">
    <div class="well">
    <div id="main" class="container">
        <h3 class="page-header">Cadastrar Usuário</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-lg-8">
                    <label for="cpf">CPF</label>
                    <input type="text" class="form-control" name="cpf" id="cpf" required maxlength="14" placeholder="Informe o CPF">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-lg-8">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" maxlength="40" placeholder="Informe o nome">
                </div>
	
                <div class="form-group col-lg-8">
                    <label for="email">E-mail</label>
                    <input type="email" class="form-control" name="email" id="email" maxlength="40" placeholder="Informe o e-mail" >
                </div>
                
                <div class="form-group col-lg-8">
                    <label for="telefone">Telefone</label>
                    <input type="tel" class="form-control" name="telefone" id="telefone" maxlength="15" placeholder="Informe o telefone">
                </div>
                
                <div class="form-group col-lg-8">
                    <label for="empresa">Empresa associado</label>
                    <input type="text" class="form-control" name="empresa" id="empresa" maxlength="40" placeholder="Informe a empresa associado">
                </div>
                
                
                <div class="form-group col-lg-8">
                    <label for="login">Login</label>
                    <input type="text" class="form-control" name="login" id="login" maxlength="40" placeholder="Informe o login do usuário">
                </div>
                
                <div class="form-group col-lg-8">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" name="senha" id="senha" maxlength="40" placeholder="Informe a senha do usuário">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CadastrarUsuario">Salvar</button>
                    <a href="index.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    </div>
    </div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>