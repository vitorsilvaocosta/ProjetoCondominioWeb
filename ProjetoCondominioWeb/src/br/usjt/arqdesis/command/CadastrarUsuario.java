package br.usjt.arqdesis.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.UsuarioService;

public class CadastrarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		 	String pCpf = request.getParameter("cpf");
	        String pNome = request.getParameter("nome");
	        String pEmail = request.getParameter("email");
	        String pTelefone = request.getParameter("telefone");
	        String pEmpresa = request.getParameter("empresa");
	        String pLogin = request.getParameter("login");
	        String pSenha = request.getParameter("senha");
	        
	        Usuario usuario = new Usuario();
	        usuario.setCpf(pCpf);
	        usuario.setNome(pNome);
	        usuario.setEmail(pEmail);
	        usuario.setTelefone(pTelefone);
	        usuario.setEmpresa(pEmpresa);
	        usuario.setUsername(pLogin);
	        usuario.setPassword(pSenha);
	        
	        UsuarioService us = new UsuarioService();
	        
	        RequestDispatcher view = null;
			HttpSession session = request.getSession();
			
	        us.criar(usuario);
	        
	        session.setAttribute("usuario", usuario);
			view = request.getRequestDispatcher("MostrarUsuario.jsp");

			view.forward(request, response);
		
	}
}
