package br.usjt.arqdesis.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.arqdesis.dao.UsuarioDAO;
import br.usjt.arqdesis.model.Usuario;

public class UsuarioService {

	UsuarioDAO dao = new UsuarioDAO();
	
	public int criar(Usuario usuario) throws IOException{
		return dao.criar(usuario);
	}
	public void atualizar(Usuario usuario) throws IOException{
		dao.atualizar(usuario);
	}
	public void atualizarPorCpf(Usuario usuario){
		dao.atualizarPorCpf(usuario);
	}
	public void excluir(int id) throws IOException{
		dao.excluir(id);
	}
	public void excluirPorCpf(String cpf){
		dao.excluirPorCpf(cpf);
	}
	public Usuario carregar(int id) throws IOException{
		return dao.carregar(id);
	}
	public Usuario carregarPorCpf(String cpf){
		return dao.carregarPorCpf(cpf);
	}
	public List<Usuario> carregarTodosUsuarios(){
		return dao.carregarTodosUsuarios();
	}
	public boolean validar(Usuario usuario){
		return dao.validar(usuario);
	}
	
	public ArrayList<Usuario> listarUsuarios() throws IOException{
		return dao.listarUsuarios();
	}
	public ArrayList<Usuario> listarUsuarios(String chave) throws IOException{
		return dao.listarUsuarios(chave);
	}
	
}
