package br.usjt.arqdesis.service;

import br.usjt.arqdesis.model.Empresa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.arqdesis.dao.EmpresaDAO;

public class EmpresaService {

	EmpresaDAO dao = new EmpresaDAO();
	
	public int criar(Empresa empresa){
		return dao.criar(empresa);
	}
	
	public void atualizar(Empresa empresa){
		dao.atualizar(empresa);
	}
	public void atualizarPorCnpj(Empresa empresa){
		dao.atualizarPorCnpj(empresa);
	}
	public void excluir(int id){
		dao.excluir(id);
	}
	public void excluirPorCnpj(String cnpj){
		dao.excluirPorCnpj(cnpj);
	}
	public Empresa carregar(int id){
		return dao.carregar(id);
	}
	public Empresa carregarPorCnpj(String cnpj){
		return dao.carregarPorCnpj(cnpj);
	}
	public List<Empresa> carregarTodasEmpresas(){
		return dao.carregarTodasEmpresas();
	}
	public ArrayList<Empresa> listarEmpresas() throws IOException{
		return dao.listarEmpresas();
	}
	public ArrayList<Empresa> listarEmpresas(String chave) throws IOException{
		return dao.listarEmpresas(chave);
	}
}
