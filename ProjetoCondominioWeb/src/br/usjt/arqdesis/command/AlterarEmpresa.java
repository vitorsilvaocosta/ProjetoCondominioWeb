package br.usjt.arqdesis.command;

import java.io.IOException;
//import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.service.EmpresaService;


public class AlterarEmpresa implements Command{

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String pCnpj = request.getParameter("cnpj");
        String pRazaoSocial = request.getParameter("razaoSocial");
        String pHorarioEmpresa = request.getParameter("horarioEmpresa");
        Double pTemperaturaAr = Double.parseDouble(request.getParameter("temperaturaAr"));
        String pHorarioAr = request.getParameter("horarioAr");
       
		

        Empresa empresa = new Empresa();
        empresa.setCnpj(pCnpj);
		empresa.setRazaoSocial(pRazaoSocial);
		empresa.setHorarioEmpresa(pHorarioEmpresa);
		empresa.setTemperaturaArCondicionado(pTemperaturaAr);
		empresa.setHorarioArCondicionado(pHorarioAr);
		
		EmpresaService es = new EmpresaService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		es.atualizarPorCnpj(empresa);
		

		session.setAttribute("empresa", empresa);
		view = request.getRequestDispatcher("ConsultarEmpresaAlterar.jsp");

		view.forward(request, response);

	}
}
