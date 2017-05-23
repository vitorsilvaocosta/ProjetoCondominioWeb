package br.usjt.arqdesis.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.service.EmpresaService;

public class ListarEmpresas implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
EmpresaService es = new EmpresaService();
		
		List<Empresa> lista = es.carregarTodasEmpresas();
		HttpSession session = request.getSession();
		
        //enviar para o jsp
        session.setAttribute("lista", lista);
        
        RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarEmpresas.jsp");
		dispatcher.forward(request, response);
	}
}
