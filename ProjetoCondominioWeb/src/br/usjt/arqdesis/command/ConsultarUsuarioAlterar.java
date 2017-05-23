package br.usjt.arqdesis.command;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.UsuarioService;


public class ConsultarUsuarioAlterar implements Command{

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

			String pCpf = request.getParameter("cpf");
			
			Usuario usuario = new Usuario();  
			UsuarioService us = new UsuarioService();;
			
			usuario = us.carregarPorCpf(pCpf);

			RequestDispatcher view = null;
			HttpSession session = request.getSession();
				
			session.setAttribute("usuario", usuario);
			view = request.getRequestDispatcher("AlterarUsuario.jsp");
				
			view.forward(request, response);
		
		
		
	}
}
