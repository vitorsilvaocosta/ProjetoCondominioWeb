package br.usjt.arqdesis.command;

import java.io.IOException;
//import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.service.UsuarioService;


public class ExcluirUsuario implements Command{

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String pCpf = request.getParameter("cpf");
		
		UsuarioService us = new UsuarioService();
        us.excluirPorCpf(pCpf);
		

        RequestDispatcher view = null;
		HttpSession session = request.getSession();
			
		session.setAttribute("usuario", null);
		view = request.getRequestDispatcher("ConsultarUsuarioExcluir.jsp");
			
		view.forward(request, response);

	}
}
