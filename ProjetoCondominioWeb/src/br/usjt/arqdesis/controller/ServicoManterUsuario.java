package br.usjt.arqdesis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.service.UsuarioService;
import br.usjt.arqdesis.utils.JSonFacade;

@WebServlet("/usuario")
public class ServicoManterUsuario extends HttpServlet {
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
	 * listar clientes
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chave = request.getParameter("chave");
		UsuarioService us = new UsuarioService();
		ArrayList<Usuario> lista = null;

		PrintWriter out = response.getWriter();

		try {
			if (chave != null && chave.length() > 0) {
				lista = us.listarUsuarios(chave);
			} else {
				lista = us.listarUsuarios();
			}
			out.println(JSonFacade.listToJSon(lista));
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
			Usuario usuario = JSonFacade.jSonToCliente(sb.toString());
			UsuarioService us = new UsuarioService();
			int id = us.criar(usuario);
			usuario.setId(id);
			//retorna o cliente cadastrado com o id atribuido pelo banco
			out.println(JSonFacade.clienteToJSon(usuario));
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
			Usuario usuario = JSonFacade.jSonToCliente(sb.toString());
			UsuarioService us = new UsuarioService();
			us.atualizar(usuario);
			//retorna o cliente atualizado
			out.println(JSonFacade.clienteToJSon(usuario));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}

	/*
	 * exclusão de clientes
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = JSonFacade.montaJSon(request);
		PrintWriter out = response.getWriter();

		try {
			Usuario usuario = JSonFacade.jSonToCliente(sb.toString());
			UsuarioService us = new UsuarioService();
			us.excluir(usuario.getId()); 
			usuario = us.carregar(usuario.getId());
			//retorna dados null se o cliente foi deletado
			out.println(JSonFacade.clienteToJSon(usuario));
		} catch (Exception e) {
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
	
}
