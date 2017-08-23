package br.usjt.arqdesis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.service.EmpresaService;
import br.usjt.arqdesis.utils.JSonFacade;

@WebServlet("/empresa")
public class ServicoManterEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/*
	 * configurar a request e a response para todos os métodos
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		super.service(request, response);
	}
	/*
	 * listar empresas
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chave = request.getParameter("chave");
		EmpresaService es = new EmpresaService();
		ArrayList<Empresa> lista = null;

		PrintWriter out = response.getWriter();

		try {
			if (chave != null && chave.length() > 0) {
				lista = es.listarEmpresas(chave);
			} else {
				lista = es.listarEmpresas();
			}
			out.println(JSonFacade.listToJSonEmpresa(lista));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
		
	}

	/*
	 * inclusão de clientes
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Empresa empresa = JSonFacade.jSonToEmpresa(sb.toString());
			EmpresaService es = new EmpresaService();
			int id = es.criar(empresa);
			empresa.setId(id);
			//retorna a empresa cadastrada com o id atribuido pelo banco
			out.println(JSonFacade.EmpresaToJSon(empresa));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
	/*
	 * atualiza clientes
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Empresa empresa = JSonFacade.jSonToEmpresa(sb.toString());
			EmpresaService es = new EmpresaService();
			es.atualizar(empresa);
			//retorna a empresa atualizada
			out.println(JSonFacade.EmpresaToJSon(empresa));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

	/*
	 * exclusao de empresa
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Empresa empresa = JSonFacade.jSonToEmpresa(sb.toString());
			EmpresaService es = new EmpresaService();
			es.excluir(empresa.getId()); 
			empresa = es.carregar(empresa.getId());
			//retorna dados null se a empresa foi deletada
			out.println(JSonFacade.EmpresaToJSon(empresa));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
	
}
