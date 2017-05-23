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
        <div class="col-sm-8 col-md-20">
        <div id="main" class="container">

            <h3 class="page-header">Visualizar Usuário</h3>
            <form action="controller.do" method="post">
            <div class="row">
                <div class="col-md-6">
                    <p><strong>CPF</strong></p>
                    <p>
                    <input type="text" class="form-control" name="cpf" id="cpf" readonly value="${usuario.cpf}">
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <p><strong>Nome</strong>
                    </p>
                    <p>
                    <input type="text" class="form-control" name="nome" id="nome" maxlength="40" value="${usuario.nome}">
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>E-mail</strong>
                    </p>
                    <p>
                    <input type="email" class="form-control" name="email" id="email" maxlength="40" value="${usuario.email}">
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>Telefone</strong>
                    </p>
                    <p>
                    <input type="tel" class="form-control" name="telefone" id="telefone" maxlength="15" value="${usuario.telefone}">
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>Empresa associado</strong>
                    </p>
                    <p>
                    <input type="text" class="form-control" name="empresa" id="empresa" maxlength="40" value="${usuario.empresa}">
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>Login</strong>
                    </p>
                    <p>
                    <input type="text" class="form-control" name="login" id="login" maxlength="40" value="${usuario.username}">
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>Senha</strong>
                    </p>
                    <p>
                    <input type="password" class="form-control" name="senha" id="senha" maxlength="40" value="${usuario.password}">
                    </p>
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
               		<button type="submit" class="btn btn-primary" name="command" value="AlterarUsuario">Salvar</button>
                    <a href="ConsultarUsuarioAlterar.jsp" class="btn btn-default">Voltar</a>
                </div>
            </div>
            </form>
        </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
	
</body>

</html>