package br.usjt.arqdesis.command;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.service.EmpresaService;


public class ConsultarEmpresa implements Command{

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
			String pCnpj = request.getParameter("cnpj");
			
			Empresa empresa = new Empresa();   
			EmpresaService es = new EmpresaService();
			
			empresa = es.carregarPorCnpj(pCnpj);

			RequestDispatcher view = null;
			HttpSession session = request.getSession();
				
			session.setAttribute("empresa", empresa);
			view = request.getRequestDispatcher("MostrarEmpresa.jsp");
				
			view.forward(request, response);
		
		
	}
}
