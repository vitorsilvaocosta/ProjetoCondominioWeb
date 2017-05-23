package br.usjt.arqdesis.service;

import java.util.List;

import br.usjt.arqdesis.dao.UsuarioDAO;
import br.usjt.arqdesis.model.Usuario;

public class UsuarioService {

	UsuarioDAO dao = new UsuarioDAO();
	
	public int criar(Usuario usuario){
		return dao.criar(usuario);
	}
	public void atualizar(Usuario usuario){
		dao.atualizar(usuario);
	}
	public void atualizarPorCpf(Usuario usuario){
		dao.atualizarPorCpf(usuario);
	}
	public void excluir(int id){
		dao.excluir(id);
	}
	public void excluirPorCpf(String cpf){
		dao.excluirPorCpf(cpf);
	}
	public Usuario carregar(int id){
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
}
